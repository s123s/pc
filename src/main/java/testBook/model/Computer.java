package testBook.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by yasha on 21.02.2017.
 */
@Entity
@Table(name="computer")
public class Computer {



    @OneToOne( cascade = {CascadeType.REFRESH}, fetch=FetchType.EAGER)
    @JoinTable(name="processor")@JoinColumn(name = "type_proc")
    private Tproc tProc;


    public Tproc gettProc() {
        return tProc;
    }

    public void settProc(Tproc tProc) {
        this.tProc = tProc;
    }



    @OneToOne(cascade = {CascadeType.REFRESH}, fetch=FetchType.EAGER)
    @JoinTable(name="mother")@JoinColumn(name = "type_mother")
    private Tmother tMother;

    public Tmother gettMother() {
        return tMother;
    }

    public void settMother(Tmother tMother) {
        this.tMother = tMother;
    }

    @ManyToOne(targetEntity = Thdd.class, cascade = {CascadeType.REFRESH}, fetch=FetchType.EAGER)
    @JoinTable(name="hdd")@JoinColumn(name = "type_hdd")
    private Thdd thdd;

    public Thdd getThdd() {
        return thdd;
    }

    public void setThdd(Thdd thdd) {
        this.thdd = thdd;
    }


    @ManyToOne(targetEntity = Tram.class, cascade = {CascadeType.REFRESH}, fetch=FetchType.EAGER)
    @JoinTable(name="ram")@JoinColumn(name = "type_ram")
    private Tram tram;

    public Tram getTram() {
        return tram;
    }

    public void setTram(Tram tram) {
        this.tram = tram;
    }

    @Id
    @Column(name = "id_computer")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="inv_number")
    private Long invNumber;

    @Column(name="buh_name")
    private String buhName;

    @Column(name="domain_name")
    private String domainName;

    public Computer(){}

    public Computer(Long invNumber, String buhName, String domainName){
        this.invNumber = invNumber;
        this.buhName = buhName;
        this.domainName = domainName;
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

    public String getBuhName() {
        return buhName;
    }

    public void setBuhName(String buhName) {
        this.buhName = buhName;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }



}

