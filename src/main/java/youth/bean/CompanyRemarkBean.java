package youth.bean;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/*
* @author:MAX
*/

public class CompanyRemarkBean {

    private String company;
    private Double avgRecomandScore;//推荐指数（百分比）
    private Double avgFutureScore;//公司前景看好指数（百分比）
    private Double avgCeoScore;//CEO支持指数（百分比）

    private List<SingleCompanyRemarkBean> singleCompanyRemarkBeans;
    //所以对公司的单个评价singleCompanyRemarkBean
    // 属性应该有phone,company,recomandScore, futureScore, ceoScore, String remark

    public CompanyRemarkBean(){

    }

    public CompanyRemarkBean(String company, Double avgRecomandScore, Double avgFutureScore, Double avgCeoScore, ArrayList<SingleCompanyRemarkBean> singleCompanyRemarkBeans) {
        this.company = company;
        this.avgRecomandScore = avgRecomandScore;
        this.avgFutureScore = avgFutureScore;
        this.avgCeoScore = avgCeoScore;
        this.singleCompanyRemarkBeans = singleCompanyRemarkBeans;
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

    public List<SingleCompanyRemarkBean> getSingleCompanyRemarkBeans() {
        return singleCompanyRemarkBeans;
    }

    public void setSingleCompanyRemarkBeans(List<SingleCompanyRemarkBean> singleCompanyRemarkBeans) {
        this.singleCompanyRemarkBeans = singleCompanyRemarkBeans;
    }

    @Override
    public String toString() {
        return "CompanyRemarkBean{" +
                "company='" + company + '\'' +
                ", avgRecomandScore=" + avgRecomandScore +
                ", avgFutureScore=" + avgFutureScore +
                ", avgCeoScore=" + avgCeoScore +
                ", singleCompanyRemarkBeans=" + singleCompanyRemarkBeans +
                '}';
    }
}

