package pc.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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

/*    @ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "id_computer")
    @JsonView(View.REST.class)*/
    @ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name = "id_computer")
    @JsonView(View.REST.class)
	private Computer computer;
	
	public String toString() {
		return "{" + idWorkplace + ", " + idWorkplace +"}";
	}

	public Integer getIdWorkplace() {
		return idWorkplace;
	}
	public void setIdWorkplace(Integer idWorkplace) {
		this.idWorkplace = idWorkplace;
	}
	public Computer getComputer() {
		return computer;
	}
	public void setComputer(Computer computer) {
		this.computer = computer;
	}
}
