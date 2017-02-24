package testBook.model;

import javax.persistence.*;

/**
 * Created by yasha on 24.02.2017.
 */
@Entity
@Table(name="type_hdd")
public class Thdd {

    @Id
    @Column(name = "id_type_hdd")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="model")
    private String model;

    @Column(name="capacity")
    private Long capacity;

    public Thdd(){}
    public Thdd(String model, Long capacity){
        this.model = model;
        this.capacity = capacity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Long getCapacity() {
        return capacity;
    }

    public void setCapacity(Long capacity) {
        this.capacity = capacity;
    }
}
