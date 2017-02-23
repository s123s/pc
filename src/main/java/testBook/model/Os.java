package testBook.model;

import javax.persistence.*;

/**
 * Created by yasha on 23.02.2017.
 */
@Entity
@Table(name="os")
public class Os {

    @Id
    @Column(name = "id_os")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    public Os(){}
    public Os(String name){
        this.name= name;
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
