package pc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

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

    @ManyToOne
    @JoinColumn(name = "id_type_hdd")
	private TypeHdd typeHdd;
    
    @ManyToOne
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

}
