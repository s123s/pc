package testBook.model;

import javax.persistence.*;

/**
 * Created by yasha on 20.04.2017.
 */
@Entity
@Table(name="producer")
public class Producer {


    @Id
    @Column(name = "id_producer")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name="shortname")
    private String name;

    public Producer(){}

    public Producer(String name){
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
