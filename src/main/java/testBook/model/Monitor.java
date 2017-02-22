package testBook.model;

import javax.persistence.*;

/**
 * Created by yasha on 22.02.2017.
 */
@Entity
@Table(name="monitor")
public class Monitor {

    @Id
    @Column(name = "id_monitor")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "inv_number")
    private Long invNumber;
    @Column(name = "name")
    private String name;
    @Column(name = "model")
    private String model;
    @Column(name = "size")
    private Long size;

    public Monitor(){}
    public Monitor(Long invNumber, String name, String model, Long size){
        this.invNumber = invNumber;
        this.name = name;
        this.model = model;
        this.size = size;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }
}
