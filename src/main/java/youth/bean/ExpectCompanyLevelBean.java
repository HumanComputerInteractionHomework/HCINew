package youth.bean;

import lombok.Data;

/**
 * @author lw
 */


public class ExpectCompanyLevelBean {
    private String phone;
    private String expectCompanyLevel;

    public ExpectCompanyLevelBean(){

    }

    public ExpectCompanyLevelBean(String phone, String expectCompanyLevel) {
        this.phone = phone;
        this.expectCompanyLevel = expectCompanyLevel;
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

    @Override
    public String toString() {
        return "ExpectCompanyLevelBean{" +
                "phone='" + phone + '\'' +
                ", expectCompanyLevel='" + expectCompanyLevel + '\'' +
                '}';
    }
}
