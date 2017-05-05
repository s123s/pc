package pc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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

//    @ManyToOne
//    @JoinColumn(name = "id_computer")
//    private Computer computer;

	@Column(name = "id_computer")
	private Integer idComputer;
	
//	@Column(name = "id_type_hdd")
//	private Integer idTypeHdd;
	@OneToOne
	@JoinColumn(name="id_type_hdd")
	private TypeHdd typeHdd;
	
	
	public Integer getIdHdd() {
		return idHdd;
	}
	public void setIdHdd(Integer idHdd) {
		this.idHdd = idHdd;
	}
	public Integer getIdComputer() {
		return idComputer;
	}
	public void setIdComputer(Integer idComputer) {
		this.idComputer = idComputer;
	}
	public TypeHdd getTypeHdd() {
		return typeHdd;
	}
	public void setTypeHdd(TypeHdd typeHdd) {
		this.typeHdd = typeHdd;
	}
	public String toString() {
		return "{" + idHdd + ", " + idComputer +", {" +typeHdd.getIdTypeHdd() +", " +typeHdd.getCapacity() + " }}";
	}

}
