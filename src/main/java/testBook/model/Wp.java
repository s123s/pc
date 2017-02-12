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
    private Long idWorkplace;
    @Column(name = "id_computer")
    private Long idComputer;
    @Column(name = "id_monitor")
    private Long idMonitor;
    @Column(name = "id_user")
    private Long idUser;
    @Column(name = "id_printer")
    private Long idPrinter;
    @Column(name = "id_ups")
    private Long idUps;
    @Column(name = "id_os")
    private Long idOs;
    @Column(name = "description")
    private String description;
    @Column(name = "c_inv_number")
    private Long cInvNumber;
    @Column(name = "c_buh_name")
    private String cBuhName;
    @Column(name = "mon_inb_number")
    private Long monInvNumber;
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

    public void setIdWorkplace(long idWorkplace) {
        this.idWorkplace = idWorkplace;
    }

    public void setIdComputer(long idComputer) {
        this.idComputer = idComputer;
    }

    public void setIdMonitor(long idMonitor) {
        this.idMonitor = idMonitor;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public void setIdPrinter(long idPrinter) {
        this.idPrinter = idPrinter;
    }

    public void setIdUps(long idUps) {
        this.idUps = idUps;
    }

    public void setIdOs(long idOs) {
        this.idOs = idOs;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setcInvNumber(long cInvNumber) {
        this.cInvNumber = cInvNumber;
    }

    public void setcBuhName(String cBuhName) {
        this.cBuhName = cBuhName;
    }

    public void setMonInvNumber(long monInvNumber) {
        this.monInvNumber = monInvNumber;
    }

    public void setMonModel(String monModel) {
        this.monModel = monModel;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public void setcDomainName(String cDomainName) {
        this.cDomainName = cDomainName;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public void setIdCompRam(Long idCompRam) {
        this.idCompRam = idCompRam;
    }

    public void setRamCount(Long ramCount) {
        this.ramCount = ramCount;
    }

    public void setRamAll(String ramAll) {
        this.ramAll = ramAll;
    }

    public void setIdCompHdd(Long idCompHdd) {
        this.idCompHdd = idCompHdd;
    }

    public void setHddCount(Long hddCount) {
        this.hddCount = hddCount;
    }

    public void setHddAll(String hddAll) {
        this.hddAll = hddAll;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public Long getIdWorkplace() {
        return idWorkplace;
    }

    public Long getIdComputer() {
        return idComputer;
    }

    public Long getIdMonitor() {
        return idMonitor;
    }

    public Long getIdUser() {
        return idUser;
    }

    public Long getIdPrinter() {
        return idPrinter;
    }

    public Long getIdUps() {
        return idUps;
    }

    public Long getIdOs() {
        return idOs;
    }

    public String getDescription() {
        return description;
    }

    public Long getcInvNumber() {
        return cInvNumber;
    }

    public String getcBuhName() {
        return cBuhName;
    }

    public Long getMonInvNumber() {
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

    public Long getIdCompRam() {
        return idCompRam;
    }

    public Long getRamCount() {
        return ramCount;
    }

    public String getRamAll() {
        return ramAll;
    }

    public Long getIdCompHdd() {
        return idCompHdd;
    }

    public Long getHddCount() {
        return hddCount;
    }

    public String getHddAll() {
        return hddAll;
    }

    public String getOs() {
        return os;
    }
}
