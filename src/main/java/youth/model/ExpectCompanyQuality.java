package youth.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @author lw
 */


@Entity
@Table(name = "expect_company_quality")
public class ExpectCompanyQuality {
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private Integer id;

    private String phone;
    private String expectCompanyQuality;

    public ExpectCompanyQuality(){

    }

    public ExpectCompanyQuality(String phone, String expectCompanyQuality) {
        this.phone = phone;
        this.expectCompanyQuality = expectCompanyQuality;
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

    public String getExpectCompanyQuality() {
        return expectCompanyQuality;
    }

    public void setExpectCompanyQuality(String expectCompanyQuality) {
        this.expectCompanyQuality = expectCompanyQuality;
    }
}
