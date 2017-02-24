package testBook.model;

import javax.persistence.*;

/**
 * Created by yasha on 24.02.2017.
 */
@Entity
@Table(name="type_proc")
public class Tproc {

    @Id
    @Column(name = "id_type_proc")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="model")
    private String model;

    @Column(name="socket")
    private Long socket;

    public Tproc(){}
    public Tproc(String model, Long socket){
        this.model = model;
        this.socket = socket;
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

    public Long getSocket() {
        return socket;
    }

    public void setSocket(Long socket) {
        this.socket = socket;
    }
}
