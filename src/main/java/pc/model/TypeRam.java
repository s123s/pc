package pc.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import pc.jackson.View;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "type_ram")
public class TypeRam {
	

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_type_ram")
    @JsonView(View.REST.class)
	private Integer idTypeRam;

    @ManyToOne
    @JoinColumn(name = "id_type_ram_spec")
    private TypeRamSpec typeRamSpec;


	@Column
	private Integer capacity;
	
    /**Нужно для проверки, есть ли ссылающиеся записи*/
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "typeRam")
    private Set<Ram> rams;
	
	public String toString () {
		return "{" + getIdTypeRam() + ", " + getTypeRamSpec().getIdTypeRamSpec() +", " +getTypeRamSpec().getDescription() +", " +capacity + "}";
	}

	public Integer getIdTypeRam() {
		return idTypeRam;
	}

	public void setIdTypeRam(Integer idTypeRam) {
		this.idTypeRam = idTypeRam;
	}

	public TypeRamSpec getTypeRamSpec() {
		return typeRamSpec;
	}

	public void setTypeRamSpec(TypeRamSpec typeRamSpec) {
		this.typeRamSpec = typeRamSpec;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public Set<Ram> getRams() {
		return rams;
	}

	public void setRams(Set<Ram> rams) {
		this.rams = rams;
	}



}
