package testBook.model;

import javax.persistence.*;

/**
 * Created by yasha on 23.02.2017.
 */
@Entity
@Table(name="ups")
public class Ups {

    @Id
    @Column(name = "id_ups")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "inv_number")
    private Long invNumber;
    @Column(name = "model")
    private String model;

    public Ups(){}
    public Ups(Long invNumber, String model){
        this.invNumber = invNumber;
        this.model = model;
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
}
