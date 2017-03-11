package testBook.model;

import javax.persistence.*;

/**
 * Created by yasha on 24.02.2017.
 */
@Entity
@Table(name="mother")
public class Mother {

    @Id
    @Column(name = "id_mother")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy="mother",fetch=FetchType.EAGER)
    private Tmother tMother;

    @OneToOne(mappedBy="computer",fetch=FetchType.EAGER)
    private Computer computer;

    public Mother(Tmother tMother, Computer computer) {
        this.tMother = tMother;
        this.computer = computer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
