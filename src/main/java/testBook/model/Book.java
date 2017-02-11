package testBook.model;

import javax.persistence.*;

/**
 * Created by yasha on 04.12.2016.
 */



@Entity
@Table(name = "book")
    public class Book {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;
    @Column(name = "name")
        private String name;
    @Column(name = "isdn")
        private String isdn;
    @Column(name = "autor_id")
        private int autor_id;

        public Book(){}

        public Book(String name, String isdn, int autor_id){
            this.name = name;
            this.isdn = isdn;
            this.autor_id = autor_id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setIsdn(String isdn) {
            this.isdn = isdn;
        }

        public void setAutor_id(int autor_id) {
            this.autor_id = autor_id;
        }

        public long getId() { return id;}

        public String getName() {
            return name;
        }

        public String getIsdn() {
            return isdn;
        }

        public int getAutor_id() {
            return autor_id;
        }
    }


