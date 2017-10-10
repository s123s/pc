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
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import pc.jackson.View;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "type_hdd")
public class TypeHdd {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_type_hdd")
	@JsonView(View.REST.class)
	private Integer idTypeHdd;

	@ManyToOne(fetch = FetchType.EAGER)
	// @Fetch(FetchMode.JOIN)
	@JoinColumn(name = "id_producer")
	@JsonView(View.REST.class)
	private Producer producer;

	/** Нужно для проверки, есть ли ссылающиеся записи */
	@OneToMany(mappedBy = "typeHdd", fetch = FetchType.LAZY)
	// @Fetch(FetchMode.JOIN)
	private Set<Hdd> hdds;

	@Column
	@JsonView(View.REST.class)
	@NotNull(message = "capacity должно быть задано")
	// @Size(min = 3, message="Длина фамилии должна быть больше трех")
	@Pattern(regexp = "[0-9]*", message = "Должны быть символы")
	private String capacity;

	public Integer getIdTypeHdd() {
		return idTypeHdd;
	}

	public void setIdTypeHdd(Integer idTypeHdd) {
		this.idTypeHdd = idTypeHdd;
	}

	public Producer getProducer() {
		return producer;
	}

	public void setProducer(Producer producer) {
		this.producer = producer;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public String toString() {
		return "{" + idTypeHdd + ", "
				+ (producer == null ? "" : producer.getIdProducer()) + ", "
				+ (producer == null ? "" : producer.getShortname()) + ", "
				+ capacity + "}";
	}

	public Set<Hdd> getHdds() {
		return hdds;
	}

	public void setHdds(Set<Hdd> hdds) {
		this.hdds = hdds;
	}

	/** Собрать удобное имя */
	public String combineDisplayName() {
		return producer.getShortname() + " " + capacity;
	}

	public static void validate(Object object, Validator validator) {
		Set<ConstraintViolation<Object>> constraintViolations = validator
				.validate(object);

		System.out.println(object);
		System.out.println(String.format("Кол-во ошибок: %d",
				constraintViolations.size()));

		for (ConstraintViolation<Object> cv : constraintViolations)
			System.out
					.println(String
							.format("Внимание, ошибка! property: [%s], value: [%s], message: [%s]",
									cv.getPropertyPath(), cv.getInvalidValue(),
									cv.getMessage()));
	}

	public static void main(String[] args) {
		ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
		Validator validator = vf.getValidator();

		TypeHdd typeHdd = new TypeHdd();
		typeHdd.setCapacity("12");
		validate(typeHdd, validator);
	}
}