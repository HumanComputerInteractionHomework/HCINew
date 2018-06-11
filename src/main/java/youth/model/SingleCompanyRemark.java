package youth.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @author lw
 */


@Entity
@Table(name = "single_company_remark")
public class SingleCompanyRemark {

    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private Integer id;

    private String phone;
    private String company;
    private Integer recomandScore;
    private Integer futureScore;
    private Integer ceoScore;
    private String remark;

    public SingleCompanyRemark(){

    }

    public SingleCompanyRemark(String phone, String company, int recomandScore, int futureScore, int ceoScore, String remark) {
        this.phone = phone;
        this.company = company;
        this.recomandScore = recomandScore;
        this.futureScore = futureScore;
        this.ceoScore = ceoScore;
        this.remark = remark;
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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Integer getRecomandScore() {
        return recomandScore;
    }

    public void setRecomandScore(Integer recomandScore) {
        this.recomandScore = recomandScore;
    }

    public Integer getFutureScore() {
        return futureScore;
    }

    public void setFutureScore(Integer futureScore) {
        this.futureScore = futureScore;
    }

    public Integer getCeoScore() {
        return ceoScore;
    }

    public void setCeoScore(Integer ceoScore) {
        this.ceoScore = ceoScore;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}

