package youth.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @author lw
 */


@Entity
@Table(name = "expect_job_type")
public class ExpectJobType {
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private Integer id;

    private String phone;
    private String expectJobType;

    public ExpectJobType(){

    }

    public ExpectJobType(String phone, String expectJobType) {
        this.phone = phone;
        this.expectJobType = expectJobType;
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

    public String getExpectJobType() {
        return expectJobType;
    }

    public void setExpectJobType(String expectJobType) {
        this.expectJobType = expectJobType;
    }
}
