package testBook.model;

import javax.persistence.*;

/**
 * Created by yasha on 21.02.2017.
 */
@Entity
@Table(name="computer")
public class Computer {

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

