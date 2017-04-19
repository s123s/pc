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
@Table(name = "producer")
public class Producer {
	

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_producer")
    @JsonView(View.REST.class)
	private Integer idProducer;

	@Column(name = "shortname")
    @JsonView(View.REST.class)
	private String shortname;

	public Integer getIdProducer() {
		return idProducer;
	}

	public void setIdProducer(Integer idProducer) {
		this.idProducer = idProducer;
	}

	public String getShortname() {
		return shortname;
	}

	public void setShortname(String shortname) {
		this.shortname = shortname;
	}

	public String toString() {
		return "{" + idProducer + ", " + shortname + "}";
	}
}
