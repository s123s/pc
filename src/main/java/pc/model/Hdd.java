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
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import pc.jackson.View;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "hdd")
public class Hdd {
	

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_hdd")
    @JsonView(View.REST.class)
	private Integer idHdd;

    @ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "id_type_hdd")
    @JsonView(View.REST.class)
	private TypeHdd typeHdd;
    
    @ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "id_computer")
    @JsonView(View.REST.class)
	private Computer computer;
	
	public String toString() {
		return "{" + idHdd 
				+", {" + computer.getIdComputer() +", " + computer.getInvNumber() + computer.getBuhName() + computer.getDomainName() +"},"
				+", {" +typeHdd.getIdTypeHdd() +", " +typeHdd.getCapacity() + " }}";
	}

	public TypeHdd getTypeHdd() {
		return typeHdd;
	}
	public void setTypeHdd(TypeHdd typeHdd) {
		this.typeHdd = typeHdd;
	}
	public Computer getComputer() {
		return computer;
	}
	public void setComputer(Computer computer) {
		this.computer = computer;
	}
	public Integer getIdHdd() {
		return idHdd;
	}
	public void setIdHdd(Integer idHdd) {
		this.idHdd = idHdd;
	}

    /**Указан тип*/
    public boolean hasTypeHdd (){
    	return (typeHdd.getIdTypeHdd()  == null) ? false:true;
    }
    
	/**Собрать удобное имя*/
	public String combineDisplayName () {
		return "" 
				+ (hasTypeHdd() ? typeHdd.combineDisplayName(): "");
	}}
