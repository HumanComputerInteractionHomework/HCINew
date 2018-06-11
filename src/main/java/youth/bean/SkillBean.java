package youth.bean;

import lombok.Data;


public class SkillBean {

/*
* @author:MAX
*/
private String phone;
private String skillName;
private String degree;
private String certificate;
private String description;

    public SkillBean(){

    }

    public SkillBean(String phone, String skillName, String degree, String certificate, String description) {
        this.phone = phone;
        this.skillName = skillName;
        this.degree = degree;
        this.certificate = certificate;
        this.description = description;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "SkillBean{" +
                "phone='" + phone + '\'' +
                ", skillName='" + skillName + '\'' +
                ", degree='" + degree + '\'' +
                ", certificate='" + certificate + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

