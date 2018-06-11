package youth.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @author lw
 */


@Entity
@Table(name = "expect_company_level")
public class ExpectCompanyLevel {
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private Integer id;

    private String phone;
    private String expectCompanyLevel;

    public ExpectCompanyLevel(){

    }

    public ExpectCompanyLevel(String phone, String expectCompanyLevel) {
        this.phone = phone;
        this.expectCompanyLevel = expectCompanyLevel;
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

    public String getExpectCompanyLevel() {
        return expectCompanyLevel;
    }

    public void setExpectCompanyLevel(String expectCompanyLevel) {
        this.expectCompanyLevel = expectCompanyLevel;
    }
}
