package pc.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import pc.jackson.View;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "type_mother")
public class TypeMother {
	

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_type_mother")
    @JsonView(View.REST.class)
	private Integer idTypeMother;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "id_producer")
    private Producer producer;

	@Column
    @JsonView(View.REST.class)
	private String model;

	@Column
    @JsonView(View.REST.class)
	private String socket;

    /**Нужно для проверки, есть ли ссылающиеся записи*/
/*    @OneToMany(mappedBy="typeMother", fetch=FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)*/
    @OneToMany(mappedBy="typeMother", fetch=FetchType.LAZY)
    private Set<Mother> mothers;
	
	public String toString() {
		return "{" + idTypeMother + ", " + producer.getIdProducer() +", " +producer.getShortname() + ", " + model + ", " + socket + "}";
	}
	
	public Producer getProducer() {
		return producer;
	}
	public void setProducer(Producer producer) {
		this.producer = producer;
	}	
	
	public Integer getIdTypeMother() {
		return idTypeMother;
	}

	public void setIdTypeMother(Integer idTypeMother) {
		this.idTypeMother = idTypeMother;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}

	public String getSocket() {
		return socket;
	}
	public void setSocket(String socket) {
		this.socket = socket;
	}

	public Set<Mother> getMothers() {
		return mothers;
	}

	public void setMothers(Set<Mother> mothers) {
		this.mothers = mothers;
	}
	/**Собрать удобное имя*/
	public String combineDisplayName () {
		return producer.getShortname() +", Model:" + model +", Socket:" +socket;
	}
}
