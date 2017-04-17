package testBook.model;

import javax.persistence.*;

/**
 * Created by yasha on 12.03.2017.
 */
@Entity
@Table(name="workplace")
public class Workplace {

    @Id
    @Column(name = "id_workplace")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idWorkplace;

    @OneToOne(fetch=FetchType.EAGER,cascade = {CascadeType.ALL})@JoinColumn(name = "id_computer")
    private Computer computer;

    @OneToOne(cascade = {CascadeType.REFRESH}, fetch=FetchType.EAGER)
    @JoinColumn(name = "id_monitor")
    private Monitor monitor;

    @OneToOne(cascade = {CascadeType.REFRESH}, fetch=FetchType.EAGER)
    @JoinColumn(name = "id_user")
    private User user;

    @OneToOne(cascade = {CascadeType.REFRESH}, fetch=FetchType.EAGER)
    @JoinColumn(name = "id_printer")
    private Printer printer;

    @OneToOne(cascade = {CascadeType.REFRESH}, fetch=FetchType.EAGER)
    @JoinColumn(name = "id_ups")
    private Ups ups;

    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch=FetchType.EAGER)
    @JoinColumn(name = "id_os")
    private Os os;

    public Workplace(){}

    public Workplace(Computer computer, Monitor monitor, User user, Printer printer, Ups ups, Os os) {
        this.computer = computer;
        this.monitor = monitor;
        this.user = user;
        this.printer = printer;
        this.ups = ups;
        this.os = os;
    }

    public Workplace(Computer computer, Monitor monitor, User user, Printer printer, Os os) {
        this.computer = computer;
        this.monitor = monitor;
        this.user = user;
        this.printer = printer;
        this.os = os;
    }

    public Workplace(Computer computer, Monitor monitor, User user, Os os) {

        this.computer = computer;
        this.monitor = monitor;
        this.user = user;
        this.os = os;
    }

    public Workplace(Computer computer, Monitor monitor, User user, Ups ups, Os os) {
        this.computer = computer;
        this.monitor = monitor;
        this.user = user;
        this.ups = ups;
        this.os = os;
    }

    public Long getIdWorkplace() {
        return idWorkplace;
    }

    public void setIdWorkplace(Long idWorkplace) {
        this.idWorkplace = idWorkplace;
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Printer getPrinter() {
        return printer;
    }

    public void setPrinter(Printer printer) {
        this.printer = printer;
    }

    public Ups getUps() {
        return ups;
    }

    public void setUps(Ups ups) {
        this.ups = ups;
    }

    public Os getOs() {
        return os;
    }

    public void setOs(Os os) {
        this.os = os;
    }
}
