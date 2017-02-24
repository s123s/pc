package testBook.model;

import javax.persistence.*;

/**
 * Created by yasha on 24.02.2017.
 */
@Entity
@Table(name="processor")
public class Processor {

    @Id
    @Column(name = "id_processor")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
