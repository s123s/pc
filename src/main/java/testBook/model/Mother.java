package testBook.model;

import javax.persistence.*;

/**
 * Created by yasha on 24.02.2017.
 */
@Entity
@Table(name="mother")
public class Mother {

    @Id
    @Column(name = "id_mother")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
