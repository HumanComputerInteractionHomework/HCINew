package youth.bean;

import lombok.Data;


public class SingleCompanyRemarkBean {

/*
* @author:MAX
* 就是单条的评价，威威加油~
*/
    private String phone;
    private String company;
    private int recomandScore;
    private int futureScore;
    private int ceoScore;
    private String remark;

    public SingleCompanyRemarkBean(){

    }

    public SingleCompanyRemarkBean(String phone, String company, int recomandScore, int futureScore, int ceoScore, String remark) {
        this.phone = phone;
        this.company = company;
        this.recomandScore = recomandScore;
        this.futureScore = futureScore;
        this.ceoScore = ceoScore;
        this.remark = remark;
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

    public int getRecomandScore() {
        return recomandScore;
    }

    public void setRecomandScore(int recomandScore) {
        this.recomandScore = recomandScore;
    }

    public int getFutureScore() {
        return futureScore;
    }

    public void setFutureScore(int futureScore) {
        this.futureScore = futureScore;
    }

    public int getCeoScore() {
        return ceoScore;
    }

    public void setCeoScore(int ceoScore) {
        this.ceoScore = ceoScore;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "SingleCompanyRemarkBean{" +
                "phone='" + phone + '\'' +
                ", company='" + company + '\'' +
                ", recomandScore=" + recomandScore +
                ", futureScore=" + futureScore +
                ", ceoScore=" + ceoScore +
                ", remark='" + remark + '\'' +
                '}';
    }
}

