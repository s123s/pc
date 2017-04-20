package testBook.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by yasha on 24.02.2017.
 */
@Entity
@Table(name="ram")
public class Ram {

    @Id
    @Column(name = "id_ram")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy="ram",fetch=FetchType.EAGER)
    private Set<Computer> computer = new HashSet<Computer>(0);

    public void setComputer(Set<Computer> computer) {
        this.computer = computer;
    }

    public Set<Computer> getComputer() {
        return this.computer;
    }


    @ManyToOne(targetEntity = Tram.class, cascade = {CascadeType.REFRESH}, fetch=FetchType.EAGER)
    @JoinColumn(name = "type_ram")
    private Tram typeRam;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Tram getTypeRam() {
        return typeRam;
    }

    public void setTypeRam(Tram typeRam) {
        this.typeRam = typeRam;
    }
}
