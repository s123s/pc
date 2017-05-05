package pc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

	@Column(name = "id_computer")
	private Integer idComputer;
	
	@Column(name = "id_type_ram")
	private Integer idTypeRam;

	public Integer getIdRam() {
		return idRam;
	}
	public void setIdRam(Integer idRam) {
		this.idRam = idRam;
	}
	public Integer getIdComputer() {
		return idComputer;
	}
	public void setIdComputer(Integer idComputer) {
		this.idComputer = idComputer;
	}
	public Integer getIdTypeRam() {
		return idTypeRam;
	}
	public void setIdTypeRam(Integer idTypeRam) {
		this.idTypeRam = idTypeRam;
	}

	public String toString() {
		return "{" + idRam + ", " + idComputer +", " +idTypeRam + "}";
	}

}
