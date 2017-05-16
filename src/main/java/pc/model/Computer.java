package pc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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

	@Column(name = "id_type_computer")
	private Integer idTypeComputer;
	
	@Column(name = "inv_number")
    @JsonView(View.REST.class)
	private Integer invNumber;
    
    @Column(name = "buh_name")
	private String buhName;
    
	@Column(name = "domain_name")
	private String domainName;

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

	public Integer getIdTypeComputer() {
		return idTypeComputer;
	}

	public void setIdTypeComputer(Integer idTypeComputer) {
		this.idTypeComputer = idTypeComputer;
	}
}
