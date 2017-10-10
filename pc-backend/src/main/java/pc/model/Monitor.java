package pc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import pc.jackson.View;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "monitor")
public class Monitor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_monitor")
	@JsonView(View.REST.class)
	private Integer idMonitor;

	@Column(name = "inv_number")
	private Integer invNumber;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_producer")
	private Producer producer;
	@Column
	private String model;
	@Column
	private Integer size;

	public String toString() {
		return "{" + idMonitor + ", " + invNumber + ", "
				+ producer.getIdProducer() + ", " + producer.getShortname()
				+ ", " + model + ", " + size + "}";
	}

	public Integer getIdMonitor() {
		return idMonitor;
	}

	public void setIdMonitor(Integer idMonitor) {
		this.idMonitor = idMonitor;
	}

	public Integer getInvNumber() {
		return invNumber;
	}

	public Producer getProducer() {
		return producer;
	}

	public void setProducer(Producer producer) {
		this.producer = producer;
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

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}
}
