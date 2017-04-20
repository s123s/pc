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

    @OneToOne(cascade = {CascadeType.REFRESH}, fetch=FetchType.EAGER)
    @JoinTable(name="type_mother")@JoinColumn(name = "id_type_mother")
    private Tmother tMother;

    @OneToOne(cascade = {CascadeType.REFRESH}, fetch=FetchType.EAGER)
    @JoinTable(name="computer")@JoinColumn(name = "id_computer")
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

    public Tmother gettMother() {
        return tMother;
    }

    public void settMother(Tmother tMother) {
        this.tMother = tMother;
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }
}
