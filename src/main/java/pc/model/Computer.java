package pc.model;

import java.util.List;
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
import javax.persistence.OneToOne;
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
 
    /**Нужно для проверки, есть ли ссылающиеся записи*/
    @OneToMany(mappedBy="computer", fetch=FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    private Set<Workplace> workplace;

    //@OneToMany(mappedBy="computer", fetch=FetchType.EAGER)

	@OneToOne(mappedBy = "computer", fetch = FetchType.EAGER)
    private Mother mother;
	
	@OneToOne(mappedBy = "computer", fetch = FetchType.EAGER)
    private Processor processor;
	
	/*@OneToOne(mappedBy = "computer", fetch = FetchType.EAGER)
    private Ram ram;*/
    @OneToMany(mappedBy="computer", fetch=FetchType.LAZY)
	private List<Ram> rams;
		
	@Column(name = "inv_number")
    @JsonView(View.REST.class)
	private Integer invNumber;
    
    @Column(name = "buh_name")
	private String buhName;
    
	@Column(name = "domain_name")
	private String domainName;

/*    *//**Нужно для проверки, есть ли ссылающиеся записи*//*
    @OneToMany
    private Set<Hdd> hdds;*/

    /**Нужно для проверки, есть ли ссылающиеся записи*/
    @OneToMany(mappedBy="computer", fetch=FetchType.LAZY)
    private List<Hdd> hdds;
    
//    /**Указана материнка*/
//    public boolean hasMother (){
//    	return (mothersSet.size() == 0) ? false:true;
//    }
//    
//    public Mother fetchFirstMother () {
//    	if (hasMother()) 
//    		return mothersSet.iterator().next();
//    	return null;
//    }
    
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
	public Set<Workplace> getWorkplace() {
		return workplace;
	}
	public void setWorkplace(Set<Workplace> workplace) {
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

}
