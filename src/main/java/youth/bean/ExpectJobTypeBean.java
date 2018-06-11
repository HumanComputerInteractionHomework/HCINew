package youth.bean;

import lombok.Data;

/**
 * @author lw
 */


public class ExpectJobTypeBean {
    private String phone;
    private String expectJobType;

    public ExpectJobTypeBean(){

    }

    public ExpectJobTypeBean(String phone, String expectJobType) {
        this.phone = phone;
        this.expectJobType = expectJobType;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getExpectJobType() {
        return expectJobType;
    }

    public void setExpectJobType(String expectJobType) {
        this.expectJobType = expectJobType;
    }

    @Override
    public String toString() {
        return "ExpectJobTypeBean{" +
                "phone='" + phone + '\'' +
                ", expectJobType='" + expectJobType + '\'' +
                '}';
    }
}
