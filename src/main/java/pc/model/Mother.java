package pc.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import pc.jackson.View;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "mother")
public class Mother {
	

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_mother")
    @JsonView(View.REST.class)
	private Integer idMother;

/*	@Column(name = "id_computer")
	private Integer idComputer;
	
	@Column(name = "id_type_mother")
	private Integer idTypeMother;
*/
    @ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "id_type_mother")
    @JsonView(View.REST.class)
	private TypeMother typeMother;
    
    @ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "id_computer")
    @JsonView(View.REST.class)
	private Computer computer;
    
    public Integer getIdMother() {
		return idMother;
	}
	public void setIdMother(Integer idMother) {
		this.idMother = idMother;
	}

    /**Не указан тип материнки*/
    public boolean noTypeMother (){
    	return (typeMother.getIdTypeMother()  == null) ? true:false;
    }

	public String toString() {
		return "{" + idMother 
				+", {" + computer.getIdComputer() +", " + computer.getInvNumber() + computer.getBuhName() + computer.getDomainName() +"},"
				+", {" +typeMother.getIdTypeMother() 
				+", {" + typeMother.getProducer().getIdProducer() +", " + typeMother.getProducer().getShortname() +"},"
				+", " +typeMother.getModel() +", " +typeMother.getSocket() + " }}";
	}

	public TypeMother getTypeMother() {
		return typeMother;
	}
	public void setTypeMother(TypeMother typeMother) {
		this.typeMother = typeMother;
	}
	public Computer getComputer() {
		return computer;
	}
	public void setComputer(Computer computer) {
		this.computer = computer;
	}
	/**Собрать удобное имя*/
	public String combineDisplayName () {
		return idMother+", " 
				+ (noTypeMother()? "": getTypeMother().combineDisplayName());
	}

}
