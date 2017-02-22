package testBook.model;

import javax.persistence.*;

/**
 * Created by yasha on 22.02.2017.
 */
@Entity
@Table(name="user")
public class User {

    @Id
    @Column(name = "id_user")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "position")
    private String position;

    @Column(name = "name")
    private String name;

    @Column(name = "login")
    private String login;

    @Column(name = "mail")
    private String mail;


    public User(){}
    public User(String position, String name, String login, String mail){
        this.position = position;
        this.name = name;
        this.login = login;
        this.mail = mail;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }


    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
