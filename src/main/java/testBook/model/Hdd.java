package testBook.model;

import javax.persistence.*;

/**
 * Created by yasha on 24.02.2017.
 */
@Entity
@Table(name="hdd")
public class Hdd {

    @Id
    @Column(name = "id_hdd")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



}
