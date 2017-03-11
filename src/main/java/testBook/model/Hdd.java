package testBook.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by yasha on 24.02.2017.
 */
@Entity
@Table(name="hdd")
public class Hdd {



    @Id
    @Column(name = "id_hdd")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy="hdd",fetch=FetchType.EAGER)
    private Set<Computer> computer = new HashSet<Computer>(0);

    public void setComputer(Set<Computer> computer) {
        this.computer = computer;
    }

    public Set<Computer> getComputer() {
        return this.computer;
    }


    @ManyToOne(targetEntity = Thdd.class, cascade = {CascadeType.REFRESH}, fetch=FetchType.EAGER)
    @JoinColumn(name = "type_hdd")
    private Thdd typeHdd;



    public Thdd getTypeHdd() {
        return this.typeHdd;
    }
    public void setTypeHdd(Thdd typeHdd) {
        this.typeHdd = typeHdd;
    }

}
