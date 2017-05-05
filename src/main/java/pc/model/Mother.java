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
@Table(name = "mother")
public class Mother {
	

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_mother")
    @JsonView(View.REST.class)
	private Integer idMother;

	@Column(name = "id_computer")
	private Integer idComputer;
	
	@Column(name = "id_type_mother")
	private Integer idTypeMother;

	public Integer getIdMother() {
		return idMother;
	}
	public void setIdMother(Integer idMother) {
		this.idMother = idMother;
	}
	public Integer getIdComputer() {
		return idComputer;
	}
	public void setIdComputer(Integer idComputer) {
		this.idComputer = idComputer;
	}
	public Integer getIdTypeMother() {
		return idTypeMother;
	}
	public void setIdTypeMother(Integer idTypeMother) {
		this.idTypeMother = idTypeMother;
	}

	public String toString() {
		return "{" + idMother + ", " + idComputer +", " +idTypeMother + "}";
	}

}
