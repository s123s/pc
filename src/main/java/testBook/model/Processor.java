package testBook.model;

import javax.persistence.*;

/**
 * Created by yasha on 24.02.2017.
 */
@Entity
@Table(name="processor")
public class Processor {

    @Id
    @Column(name = "id_processor")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy="processor",fetch=FetchType.EAGER)
    private Tproc tprocessor;

    @OneToOne(mappedBy="computer",fetch=FetchType.EAGER)
    private Computer computer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Tproc getTprocessor() {
        return tprocessor;
    }

    public void setTprocessor(Tproc tprocessor) {
        this.tprocessor = tprocessor;
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }
}
