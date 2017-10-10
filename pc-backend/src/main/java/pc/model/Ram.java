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

import pc.jackson.View;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "ram")
public class Ram {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_ram")
    @JsonView(View.REST.class)
	private Integer idRam;

/*    @ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "id_type_ram")
    @JsonView(View.REST.class)*/
    @ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name = "id_type_ram")
    @JsonView(View.REST.class)
	private TypeRam typeRam;
    
/*    @ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "id_computer")
    @JsonView(View.REST.class)*/
    @ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name = "id_computer")
    @JsonView(View.REST.class)
	private Computer computer;
    
	public Integer getIdRam() {
		return idRam;
	}
	public void setIdRam(Integer idRam) {
		this.idRam = idRam;
	}
	public TypeRam getTypeRam() {
		return typeRam;
	}
	public void setTypeRam(TypeRam typeRam) {
		this.typeRam = typeRam;
	}
	public Computer getComputer() {
		return computer;
	}
	public void setComputer(Computer computer) {
		this.computer = computer;
	}

	public String toString() {
		return "{" + idRam 
				+", {" + computer.getIdComputer() +", " + computer.getInvNumber() + computer.getBuhName() + computer.getDomainName() +"},"
				+", {" +typeRam.getIdTypeRam() +", " +typeRam.getCapacity() + " }}";
	}

    /**Указан тип*/
    public boolean hasTypeRam (){
    	return (typeRam.getIdTypeRam()  == null) ? false:true;
    }
    
	/**Собрать удобное имя*/
	public String combineDisplayName () {
		return "" 
				+ (hasTypeRam() ? typeRam.combineDisplayName(): "");
	}
}
