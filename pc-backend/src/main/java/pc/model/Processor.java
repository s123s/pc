package pc.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import pc.jackson.View;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "processor")
public class Processor {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_processor")
    @JsonView(View.REST.class)
	private Integer idProcessor;

    @ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "id_type_proc")
    @JsonView(View.REST.class)
	private TypeProc typeProc;
    
    @ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "id_computer")
    @JsonView(View.REST.class)
	private Computer computer;
    
	public Integer getIdProcessor() {
		return idProcessor;
	}
	public void setIdProcessor(Integer idProcessor) {
		this.idProcessor = idProcessor;
	}
	public TypeProc getTypeProc() {
		return typeProc;
	}
	public void setTypeProc(TypeProc typeProc) {
		this.typeProc = typeProc;
	}
	public Computer getComputer() {
		return computer;
	}
	public void setComputer(Computer computer) {
		this.computer = computer;
	}
	
    /**Указан компьютер*/
    public boolean hasComputer (){
    	return (computer == null) ? false:true;
    }
    
    public String toString() {
		return "{" + idProcessor 
				+", {" + computer.getIdComputer() +", " + computer.getInvNumber() + computer.getBuhName() + computer.getDomainName() +"},"
				+", {" +typeProc.getIdTypeProc() 
				+", {" + typeProc.getProducer().getIdProducer() +", " + typeProc.getProducer().getShortname() +"},"
				+", " +typeProc.getModel() +", " +typeProc.getSocket() + " }}";
	}
	
    /**Указан тип*/
    public boolean hasTypeProc (){
    	return (typeProc.getIdTypeProc()  == null) ? false:true;
    }
    
	/**Собрать удобное имя*/
	public String combineDisplayName () {
		return "" 
				+ (hasTypeProc() ? typeProc.combineDisplayName(): "");
	}

}
