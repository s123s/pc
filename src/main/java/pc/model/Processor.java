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
@Table(name = "processor")
public class Processor {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_processor")
    @JsonView(View.REST.class)
	private Integer idProcessor;

	@Column(name = "id_computer")
	private Integer idComputer;
	
	@Column(name = "id_type_proc")
	private Integer idTypeProc;

	public Integer getIdProcessor() {
		return idProcessor;
	}
	public void setIdProcessor(Integer idProcessor) {
		this.idProcessor = idProcessor;
	}
	public Integer getIdComputer() {
		return idComputer;
	}
	public void setIdComputer(Integer idComputer) {
		this.idComputer = idComputer;
	}
	public Integer getIdTypeProc() {
		return idTypeProc;
	}
	public void setIdTypeProc(Integer idTypeProc) {
		this.idTypeProc = idTypeProc;
	}

	public String toString() {
		return "{" + idProcessor + ", " + idComputer +", " +idTypeProc + "}";
	}

}
