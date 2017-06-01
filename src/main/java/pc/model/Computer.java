package pc.model;

import java.util.Set;

import javax.persistence.CascadeType;
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
@Table(name = "computer")
public class Computer {
	

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_computer")
    @JsonView(View.REST.class)
	private Integer idComputer;

    @ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "id_type_computer")
    @JsonView(View.REST.class)
	private TypeComputer typeComputer;
 
    @ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "id_workplace")
    @JsonView(View.REST.class)
	private Workplace workplace;
 
		
	@Column(name = "inv_number")
    @JsonView(View.REST.class)
	private Integer invNumber;
    
    @Column(name = "buh_name")
	private String buhName;
    
	@Column(name = "domain_name")
	private String domainName;

    /**Нужно для проверки, есть ли ссылающиеся записи*/
    @OneToMany
    private Set<Hdd> hdds;
    
	public String toString() {
		return "{" + idComputer + ", " + invNumber + ", " + buhName +", " +domainName +"}";
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

	public Workplace getWorkplace() {
		return workplace;
	}

	public void setWorkplace(Workplace workplace) {
		this.workplace = workplace;
	}

}
