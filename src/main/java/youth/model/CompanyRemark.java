package youth.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @author lw
 */


@Entity
@Table(name = "company_remark")
public class CompanyRemark {

    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private Integer id;

    private String company;
    private Double avgRecomandScore;//推荐指数（百分比）
    private Double avgFutureScore;//公司前景看好指数（百分比）
    private Double avgCeoScore;//CEO支持指数（百分比）

    public CompanyRemark(){

    }

    public CompanyRemark(String company, Double avgRecomandScore, Double avgFutureScore, Double avgCeoScore) {
        this.company = company;
        this.avgRecomandScore = avgRecomandScore;
        this.avgFutureScore = avgFutureScore;
        this.avgCeoScore = avgCeoScore;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Double getAvgRecomandScore() {
        return avgRecomandScore;
    }

    public void setAvgRecomandScore(Double avgRecomandScore) {
        this.avgRecomandScore = avgRecomandScore;
    }

    public Double getAvgFutureScore() {
        return avgFutureScore;
    }

    public void setAvgFutureScore(Double avgFutureScore) {
        this.avgFutureScore = avgFutureScore;
    }

    public Double getAvgCeoScore() {
        return avgCeoScore;
    }

    public void setAvgCeoScore(Double avgCeoScore) {
        this.avgCeoScore = avgCeoScore;
    }
}

