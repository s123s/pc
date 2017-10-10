package pc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "wp_summ_view")
public class WpSummView {

	@Id
	@Column(name = "id_workplace")
	private Integer idWorkplace;

	@Column(name = "c_inv_number")
	private Integer cInvNumber;

	@Column(name = "c_buh_name")
	private String cBuhName;

	@Column(name = "id_type_computer")
	private String idTypeComputer;

	@Column(name = "c_type_computer")
	private String cTypeComputer;

	@Column(name = "mon_inb_number")
	private Integer monInvNumber;

	@Column(name = "mon_model")
	private String monName;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "user_login")
	private String userLogin;

	@Column(name = "c_domain_name")
	private String cDomainName;

	@Column(name = "model")
	private String model;

	@Column(name = "ram_count")
	private Integer ramCount;

	@Column(name = "ram_capacity_all")
	private String ramCapacityAll;

	@Column(name = "hdd_count")
	private Integer hddCount;

	@Column(name = "hdd_capacity_all")
	private String hddCapacityAll;

	@Column(name = "os_name")
	private String osName;

	public WpSummView() {
	};

	public String toString() {
		return "" + idWorkplace;
	}

	public Integer getcInvNumber() {
		return cInvNumber;
	}

	public void setcInvNumber(Integer cInvNumber) {
		this.cInvNumber = cInvNumber;
	}

	public String getcBuhName() {
		return cBuhName;
	}

	public void setcBuhName(String cBuhName) {
		this.cBuhName = cBuhName;
	}

	public String getcTypeComputer() {
		return cTypeComputer;
	}

	public void setcTypeComputer(String cTypeComputer) {
		this.cTypeComputer = cTypeComputer;
	}

	public Integer getMonInvNumber() {
		return monInvNumber;
	}

	public void setMonInvNumber(Integer monInvNumber) {
		this.monInvNumber = monInvNumber;
	}

	public String getMonName() {
		return monName;
	}

	public void setMonName(String monName) {
		this.monName = monName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}

	public String getcDomainName() {
		return cDomainName;
	}

	public void setcDomainName(String cDomainName) {
		this.cDomainName = cDomainName;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getRamCount() {
		return ramCount;
	}

	public void setRamCount(Integer ramCount) {
		this.ramCount = ramCount;
	}

	public String getRamCapacityAll() {
		return ramCapacityAll;
	}

	public void setRamCapacityAll(String ramCapacityAll) {
		this.ramCapacityAll = ramCapacityAll;
	}

	public Integer getHddCount() {
		return hddCount;
	}

	public void setHddCount(Integer hddCount) {
		this.hddCount = hddCount;
	}

	public String getHddCapacityAll() {
		return hddCapacityAll;
	}

	public void setHddCapacityAll(String hddCapacityAll) {
		this.hddCapacityAll = hddCapacityAll;
	}

	public String getOsName() {
		return osName;
	}

	public void setOsName(String osName) {
		this.osName = osName;
	}

	public Integer getIdWorkplace() {
		return idWorkplace;
	}

	public void setIdWorkplace(Integer idWorkplace) {
		this.idWorkplace = idWorkplace;
	}

	public String getIdTypeComputer() {
		return idTypeComputer;
	}

	public void setIdTypeComputer(String idTypeComputer) {
		this.idTypeComputer = idTypeComputer;
	}

}
