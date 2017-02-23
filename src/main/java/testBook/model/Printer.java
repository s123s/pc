package testBook.model;

import javax.persistence.*;

/**
 * Created by yasha on 23.02.2017.
 */
@Entity
@Table(name="printer")
public class Printer {

    @Id
    @Column(name = "id_printer")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "inv_number")
    private Long invNumber;
    @Column(name = "model")
    private String model;
    @Column(name = "cartridge")
    private String cartridge;

    public Printer(){}
    public Printer(Long invNumber, String model, String cartridge) {
        this.invNumber = invNumber;
        this.model = model;
        this.cartridge = cartridge;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getInvNumber() {
        return invNumber;
    }

    public void setInvNumber(Long invNumber) {
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
