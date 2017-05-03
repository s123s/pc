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
@Table(name = "printer")
public class Printer {
	

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_printer")
    @JsonView(View.REST.class)
	private Integer idPrinter;

	@Column(name = "inv_number")
	private Integer invNumber;
    
    @Column
	private String model;
    @Column
	private String cartridge;

	public String toString() {
		return "{" + idPrinter + ", " + invNumber + ", " + model  + ", " + cartridge +"}";
	}

	public Integer getIdPrinter() {
		return idPrinter;
	}
	public void setIdPrinter(Integer idPrinter) {
		this.idPrinter = idPrinter;
	}	public Integer getInvNumber() {
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
	public String getCartridge() {
		return cartridge;
	}
	public void setCartridge(String cartridge) {
		this.cartridge = cartridge;
	}


}
