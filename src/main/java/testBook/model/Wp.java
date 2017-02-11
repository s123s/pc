package testBook.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by yasha on 11.02.2017.
 */

@Entity
@Table(name="wp_summ_view")
public class Wp {

    @Id
    @Column(name = "id_workplace")
    private long idWorkplace;
    @Column(name = "id_computer")
    private long idComputer;
    @Column(name = "id_monitor")
    private long idMonitor;
    @Column(name = "id_user")
    private long idUser;
    @Column(name = "id_printer")
    private long idPrinter;
    @Column(name = "id_ups")
    private long idUps;
    @Column(name = "id_os")
    private long idOs;
    @Column(name = "description")
    private String description;
    @Column(name = "c_inv_number")
    private long cInvNumber;
    @Column(name = "c_buh_name")
    private String cBuhName;
    @Column(name = "mon_inb_number")
    private long monInvNumber;
    @Column(name = "mon_model")
    private String monModel;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_login")
    private String userLogin;
    @Column(name = "c_domain_name")
    private String cDomainName;
    @Column(name = "model")
    private String processor;
    @Column(name = "ram_id_computer")
    private Long idCompRam;
    @Column(name = "ram_count")
    private Long ramCount;
    @Column(name = "ram_capacity_all")
    private String ramAll;
    @Column(name = "hdd_id_computer")
    private Long idCompHdd;
    @Column(name = "hdd_count")
    private Long hddCount;
    @Column(name = "hdd_capacity_all")
    private String hddAll;
    @Column(name = "os_name")
    private String os;

    public long getIdWorkplace() {
        return idWorkplace;
    }

    public long getIdComputer() {
        return idComputer;
    }

    public long getIdMonitor() {
        return idMonitor;
    }

    public long getIdUser() {
        return idUser;
    }

    public long getIdPrinter() {
        return idPrinter;
    }

    public long getIdUps() {
        return idUps;
    }

    public long getIdOs() {
        return idOs;
    }

    public String getDescription() {
        return description;
    }

    public long getcInvNumber() {
        return cInvNumber;
    }

    public String getcBuhName() {
        return cBuhName;
    }

    public long getMonInvNumber() {
        return monInvNumber;
    }

    public String getMonModel() {
        return monModel;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public String getcDomainName() {
        return cDomainName;
    }

    public String getProcessor() {
        return processor;
    }

    public long getIdCompRam() {
        return idCompRam;
    }

    public long getRamCount() {
        return ramCount;
    }

    public String getRamAll() {
        return ramAll;
    }

    public long getIdCompHdd() {
        return idCompHdd;
    }

    public long getHddCount() {
        return hddCount;
    }

    public String getHddAll() {
        return hddAll;
    }

    public String getOs() {
        return os;
    }
}
