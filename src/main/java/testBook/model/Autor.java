package testBook.model;

import org.springframework.context.annotation.Lazy;

import javax.persistence.*;


/**
 * Created by yasha on 10.12.2016.
 */
@Entity
@Table(name = "autor")

public class Autor {

    @Id
    @Column(name = "id")
    @Lazy(false)
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long id;
    @Column(name = "name")
    private String name;

    public Autor(){}
    public Autor(String name){
        this.name = name;
    }

    public long getId() {
        return id;
    }

   /* public void setId(long id) {
        this.id = id;
    }
*/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
