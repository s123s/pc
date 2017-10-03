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
@Table(name = "type_proc")
public class TypeProc {
	

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_type_proc")
    @JsonView(View.REST.class)
	private Integer idTypeProc;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "id_producer")
    private Producer producer;

	@Column
    @JsonView(View.REST.class)
	private String model;

	@Column
    @JsonView(View.REST.class)
	private String socket;
	
    /**Нужно для проверки, есть ли ссылающиеся записи*/
/*    @OneToMany(mappedBy="typeProc", fetch=FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)*/
    @OneToMany(mappedBy="typeProc", fetch=FetchType.LAZY)
    private Set<Processor> processors;


	public String toString() {
		return "{" + idTypeProc + ", " + producer.getIdProducer() +", " +producer.getShortname() + ", " + model + ", " + socket + "}";
	}
	
	public Producer getProducer() {
		return producer;
	}
	public void setProducer(Producer producer) {
		this.producer = producer;
	}

	public Integer getIdTypeProc() {
		return idTypeProc;
	}
	public void setIdTypeProc(Integer idTypeProc) {
		this.idTypeProc = idTypeProc;
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

	public Set<Processor> getProcessors() {
		return processors;
	}

	public void setProcessors(Set<Processor> processors) {
		this.processors = processors;
	}

	/**Собрать удобное имя*/
	public String combineDisplayName () {
		return producer.getShortname() +", Model:" + model +", Socket:" +socket;
	}
}
