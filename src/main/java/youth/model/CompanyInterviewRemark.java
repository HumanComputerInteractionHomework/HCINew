package youth.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @author lw
 */


@Entity
@Table(name = "company_interview_remark")
public class CompanyInterviewRemark {

    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private Integer id;

    private String company;
    private Double avgDifficulty;//面试难度均值
    private Double avgFeeling;//面试感受均值


    public CompanyInterviewRemark(){

    }

    public CompanyInterviewRemark(String company, Double avgDifficulty, Double avgFeeling) {
        this.company = company;
        this.avgDifficulty = avgDifficulty;
        this.avgFeeling = avgFeeling;
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

    public Double getAvgDifficulty() {
        return avgDifficulty;
    }

    public void setAvgDifficulty(Double avgDifficulty) {
        this.avgDifficulty = avgDifficulty;
    }

    public Double getAvgFeeling() {
        return avgFeeling;
    }

    public void setAvgFeeling(Double avgFeeling) {
        this.avgFeeling = avgFeeling;
    }
}

