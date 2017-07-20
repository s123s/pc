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

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import pc.jackson.View;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "type_hdd")
public class TypeHdd {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_type_hdd")
    @JsonView(View.REST.class)
	private Integer idTypeHdd;

    @ManyToOne(fetch=FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "id_producer")
    @JsonView(View.REST.class)
    private Producer producer;

    /**Нужно для проверки, есть ли ссылающиеся записи*/
    @OneToMany(mappedBy="typeHdd", fetch=FetchType.LAZY)
    @Fetch(FetchMode.JOIN)
    private Set<Hdd> hdds;

	@Column
    @JsonView(View.REST.class)
	private String capacity;

	public Integer getIdTypeHdd() {
		return idTypeHdd;
	}
	public void setIdTypeHdd(Integer idTypeHdd) {
		this.idTypeHdd = idTypeHdd;
	}
	public Producer getProducer() {
		return producer;
	}
	public void setProducer(Producer producer) {
		this.producer = producer;
	}
	public String getCapacity() {
		return capacity;
	}
	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	
	public String toString() {
		return "{" + idTypeHdd + ", " + producer.getIdProducer() +", " +producer.getShortname() + ", " + capacity + "}";
	}
	public Set<Hdd> getHdds() {
		return hdds;
	}
	public void setHdds(Set<Hdd> hdds) {
		this.hdds = hdds;
	}
	
	/**Собрать удобное имя*/
	public String combineDisplayName () {
		return producer.getShortname() +" " +capacity;
	}

}