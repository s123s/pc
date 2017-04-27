package pc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

	private Integer capacity;
	
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



}
