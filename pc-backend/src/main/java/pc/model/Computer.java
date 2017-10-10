package pc.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import pc.jackson.View;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "computer")
public class Computer implements Cloneable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_computer")
	@JsonView(View.REST.class)
	private Integer idComputer;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_type_computer")
	@JsonView(View.REST.class)
	private TypeComputer typeComputer;

	@Column(name = "inv_number")
	@JsonView(View.REST.class)
	private Integer invNumber;

	@Column(name = "buh_name")
	private String buhName;

	@Column(name = "domain_name")
	private String domainName;

	@OneToOne(mappedBy = "computer", fetch = FetchType.LAZY)
	private Mother mother;

	@OneToOne(mappedBy = "computer", fetch = FetchType.LAZY)
	private Processor processor;

	/** Нужно для проверки, есть ли ссылающиеся записи */
	@OneToMany(mappedBy = "computer", fetch = FetchType.LAZY)
	private List<Workplace> workplace;

	/** Нужно для проверки, есть ли ссылающиеся записи */
	@OneToMany(mappedBy = "computer", fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Ram> rams;

	/** Нужно для проверки, есть ли ссылающиеся записи */
	@OneToMany(mappedBy = "computer", fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Hdd> hdds;

	public String toString() {
		return "{" + idComputer + ", " + invNumber + ", " + buhName + ", "
				+ domainName + "}";
	}

	public Integer getIdComputer() {
		return idComputer;
	}

	public void setIdComputer(Integer idComputer) {
		this.idComputer = idComputer;
	}

	public Integer getInvNumber() {
		return invNumber;
	}

	public String getBuhName() {
		return buhName;
	}

	public void setBuhName(String buhName) {
		this.buhName = buhName;
	}

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public TypeComputer getTypeComputer() {
		return typeComputer;
	}

	public void setTypeComputer(TypeComputer typeComputer) {
		this.typeComputer = typeComputer;
	}

	public List<Workplace> getWorkplace() {
		return workplace;
	}

	public void setWorkplace(List<Workplace> workplace) {
		this.workplace = workplace;
	}

	public Mother getMother() {
		return mother;
	}

	public void setMother(Mother mother) {
		this.mother = mother;
	}

	public Processor getProcessor() {
		return processor;
	}

	public void setProcessor(Processor processor) {
		this.processor = processor;
	}

	public List<Ram> getRams() {
		return rams;
	}

	public void setRams(List<Ram> rams) {
		this.rams = rams;
	}

	public List<Hdd> getHdds() {
		return hdds;
	}

	public void setHdds(List<Hdd> hdds) {
		this.hdds = hdds;
	}

	@Override
	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
