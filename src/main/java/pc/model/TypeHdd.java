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
@Table(name = "type_hdd")
public class TypeHdd {
	

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_type_hdd")
    @JsonView(View.REST.class)
	private Integer idTypeHdd;

	@Column(name = "model")
	private String model;
	
	@Column
	private String capacity;

	public Integer getIdTypeHdd() {
		return idTypeHdd;
	}

	public void setIdTypeHdd(Integer idTypeHdd) {
		this.idTypeHdd = idTypeHdd;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public String toString() {
		return "{" + idTypeHdd + ", " + model + ", " + capacity + "}";
	}
}
