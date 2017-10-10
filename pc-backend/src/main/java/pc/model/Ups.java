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
@Table(name = "ups")
public class Ups {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_ups")
	@JsonView(View.REST.class)
	private Integer idUps;

	@Column(name = "inv_number")
	private Integer invNumber;

	@Column
	private String model;

	public String toString() {
		return "{" + idUps + ", " + invNumber + ", " + model + "}";
	}

	public Integer getIdUps() {
		return idUps;
	}

	public void setIdUps(Integer idUps) {
		this.idUps = idUps;
	}

	public Integer getInvNumber() {
		return invNumber;
	}

	public void setInvNumber(Integer invNumber) {
		this.invNumber = invNumber;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

}
