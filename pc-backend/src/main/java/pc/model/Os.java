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
@Table(name = "os")
public class Os {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_os")
	@JsonView(View.REST.class)
	private Integer idOs;

	@Column
	@JsonView(View.REST.class)
	private String name;

	public String toString() {
		return "{" + idOs + ", " + name + "}";
	}

	public Integer getIdOs() {
		return idOs;
	}

	public void setIdOs(Integer idOs) {
		this.idOs = idOs;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
