package youth.bean;

import lombok.Data;

import java.util.List;


public class CompanyInterviewRemarkBean {

/*
* @author:MAX
* 仿照Companyremark，你可以的！威威！相信自己！！！
*
*/
    private  String company;
    private  Double avgDifficulty;
    private  Double avgFeeling;
    private  List<SingleInterviewRemarkBean> singleInterviewRemarkBeans;

    public CompanyInterviewRemarkBean(){

    }

    public CompanyInterviewRemarkBean(String company, Double avgDifficulty, Double avgFeeling, List<SingleInterviewRemarkBean> singleInterviewRemarkBeans) {
        this.company = company;
        this.avgDifficulty = avgDifficulty;
        this.avgFeeling = avgFeeling;
        this.singleInterviewRemarkBeans = singleInterviewRemarkBeans;
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

    public List<SingleInterviewRemarkBean> getSingleInterviewRemarkBeans() {
        return singleInterviewRemarkBeans;
    }

    public void setSingleInterviewRemarkBeans(List<SingleInterviewRemarkBean> singleInterviewRemarkBeans) {
        this.singleInterviewRemarkBeans = singleInterviewRemarkBeans;
    }

    @Override
    public String toString() {
        return "CompanyInterviewRemarkBean{" +
                "company='" + company + '\'' +
                ", avgDifficulty=" + avgDifficulty +
                ", avgFeeling=" + avgFeeling +
                ", singleInterviewRemarkBeans=" + singleInterviewRemarkBeans +
                '}';
    }
}

