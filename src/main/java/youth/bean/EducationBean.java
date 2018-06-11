package youth.bean;

import java.util.List;

public class EducationBean {

/*
* @author:MAX
*/

private String phone;
private String educationDegree;
private String school;
private String major;
private String fromTime;
private String toTime;
private List<HonorBean> honorBeans;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public EducationBean(){

    }

    public EducationBean(String phone, String educationDegree, String school, String major, String fromTime, String toTime, List<HonorBean> honorBeans) {
        this.phone = phone;
        this.educationDegree = educationDegree;
        this.school = school;
        this.major = major;
        this.fromTime = fromTime;
        this.toTime = toTime;
        this.honorBeans = honorBeans;
    }

    public String getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(String educationDegree) {
        this.educationDegree = educationDegree;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getFromTime() {
        return fromTime;
    }

    public void setFromTime(String fromTime) {
        this.fromTime = fromTime;
    }

    public String getToTime() {
        return toTime;
    }

    public void setToTime(String toTime) {
        this.toTime = toTime;
    }

    public List<HonorBean> getHonorBeans() {
        return honorBeans;
    }

    public void setHonorBeans(List<HonorBean> honorBeans) {
        this.honorBeans = honorBeans;
    }


    @Override
    public String toString() {
        return "EducationBean{" +
                "phone='" + phone + '\'' +
                ", educationDegree='" + educationDegree + '\'' +
                ", school='" + school + '\'' +
                ", major='" + major + '\'' +
                ", fromTime='" + fromTime + '\'' +
                ", toTime='" + toTime + '\'' +
                ", honorBeans=" + honorBeans +
                '}';
    }
}

