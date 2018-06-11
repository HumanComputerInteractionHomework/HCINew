package youth.bean;

import lombok.Data;

/**
 * @author lw
 */


public class ExpectLocationBean {
    private String phone;
    private String expectLocation;

    public ExpectLocationBean(){

    }

    public ExpectLocationBean(String phone, String expectLocation) {
        this.phone = phone;
        this.expectLocation = expectLocation;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getExpectLocation() {
        return expectLocation;
    }

    public void setExpectLocation(String expectLocation) {
        this.expectLocation = expectLocation;
    }

    @Override
    public String toString() {
        return "ExpectLocationBean{" +
                "phone='" + phone + '\'' +
                ", expectLocation='" + expectLocation + '\'' +
                '}';
    }
}
