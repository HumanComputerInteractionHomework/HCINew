package youth.bean;

import lombok.Data;
/*
      * @author:MAX
      */

public class UserBasicMessageBean {

    private String phone;
    private String realName;
    private String birthday;
    private String gender;
    private String address;
    private Double jobYear;



    private String salary;
    private Integer lowSalary;
    private Integer highSalary;
    private Integer basicSalary;
    private Integer bonus;
    private Integer commission;
    private Integer stockShareOption;
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRealName() {
        return realName;
    }


    public UserBasicMessageBean(){

    }

    public UserBasicMessageBean(String phone, String realName, String birthday, String gender, String address,
                                Double jobYear, String salary, Integer lowSalary, Integer highSalary,
                                Integer basicSalary, Integer bonus, Integer commission, Integer stockShareOption) {
        this.phone = phone;
        this.realName = realName;
        this.birthday = birthday;
        this.gender = gender;
        this.address = address;
        this.jobYear = jobYear;
        this.salary = salary;
        this.lowSalary = lowSalary;
        this.highSalary = highSalary;
        this.basicSalary = basicSalary;
        this.bonus = bonus;
        this.commission = commission;
        this.stockShareOption = stockShareOption;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getJobYear() {
        return jobYear;
    }

    public void setJobYear(Double jobYear) {
        this.jobYear = jobYear;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public Integer getLowSalary() {
        return lowSalary;
    }

    public void setLowSalary(Integer lowSalary) {
        this.lowSalary = lowSalary;
    }

    public Integer getHighSalary() {
        return highSalary;
    }

    public void setHighSalary(Integer highSalary) {
        this.highSalary = highSalary;
    }

    public Integer getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(Integer basicSalary) {
        this.basicSalary = basicSalary;
    }

    public Integer getBonus() {
        return bonus;
    }

    public void setBonus(Integer bonus) {
        this.bonus = bonus;
    }

    public Integer getCommission() {
        return commission;
    }

    public void setCommission(Integer commission) {
        this.commission = commission;
    }

    public Integer getStockShareOption() {
        return stockShareOption;
    }

    public void setStockShareOption(Integer stockShareOption) {
        this.stockShareOption = stockShareOption;
    }

    @Override
    public String toString() {
        return "UserBasicMessageBean{" +
                "phone='" + phone + '\'' +
                ", realName='" + realName + '\'' +
                ", birthday='" + birthday + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", jobYear=" + jobYear +
                ", salary='" + salary + '\'' +
                ", lowSalary=" + lowSalary +
                ", highSalary=" + highSalary +
                ", basicSalary=" + basicSalary +
                ", bonus=" + bonus +
                ", commission=" + commission +
                ", stockShareOption=" + stockShareOption +
                '}';
    }
}
