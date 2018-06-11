package youth.model;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private Integer id;


    @Column(name = "phone")
    private String phone;

    @Column(name = "mail")
    private String mail;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;


    public User(){

    }

    public User(String phone, String mail, String password, String name) {
        this.phone = phone;
        this.mail = mail;
        this.password = password;
        this.name = name;
    }


    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String passwor) {
        this.password = passwor;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }



}
