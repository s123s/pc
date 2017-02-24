package testBook.model;

import javax.persistence.*;

/**
 * Created by yasha on 24.02.2017.
 */
@Entity
@Table(name="ram")
public class Ram {

    @Id
    @Column(name = "id_ram")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


}
