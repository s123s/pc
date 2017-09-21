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
@Table(name = "type_computer")
public class TypeComputer implements Cloneable{
	

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_type_computer")
    @JsonView(View.REST.class)
	private Integer idTypeComputer;

	@Column
	private String description;
	
	public Integer getIdTypeComputer() {
		return idTypeComputer;
	}

	public void setIdTypeComputer(Integer idTypeComputer) {
		this.idTypeComputer = idTypeComputer;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String toString() {
		return "{" + idTypeComputer + ", " + description +"}";
	}
}
