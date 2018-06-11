package youth.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @author lw
 */


@Entity
@Table(name = "honor")
public class Honor {
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private Integer id;

    private String phone;
    private String honorName;
    private String level;

    public Honor(){

    }

    public Honor(String phone, String honorName, String level) {
        this.phone = phone;
        this.honorName = honorName;
        this.level = level;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHonorName() {
        return honorName;
    }

    public void setHonorName(String honorName) {
        this.honorName = honorName;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
