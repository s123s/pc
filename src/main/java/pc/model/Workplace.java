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
@Table(name = "workplace")
public class Workplace {
	

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_workplace")
    @JsonView(View.REST.class)
	private Integer idWorkplace;


	public String toString() {
		return "{" + idWorkplace + ", " + idWorkplace +"}";
	}

	public Integer getIdWorkplace() {
		return idWorkplace;
	}
	public void setIdWorkplace(Integer idWorkplace) {
		this.idWorkplace = idWorkplace;
	}
}
