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
@Table(name = "type_ram_spec")
public class TypeRamSpec {
	

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_type_ram_spec")
    @JsonView(View.REST.class)
	private Integer idTypeRamSpec;

  	@Column
	private String description;

	public String toString () {
		return "{" + idTypeRamSpec + ", " + description + "}";
	}

	public Integer getIdTypeRamSpec() {
		return idTypeRamSpec;
	}

	public void setIdTypeRamSpec(Integer idTypeRamSpec) {
		this.idTypeRamSpec = idTypeRamSpec;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/**Собрать удобное имя*/
	public String combineDisplayName () {
		return description;
	}
}
