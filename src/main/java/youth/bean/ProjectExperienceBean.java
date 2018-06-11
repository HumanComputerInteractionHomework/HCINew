package youth.bean;

import lombok.Data;


public class ProjectExperienceBean {
    /*
    * @author:MAX
    */
    private String phone;
    private String projectName;
    private String projectLevel;
    private String fromTime;
    private String toTime;
    private String projectDescription;
    private String jobDescription;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectLevel() {
        return projectLevel;
    }

    public void setProjectLevel(String projectLevel) {
        this.projectLevel = projectLevel;
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

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }


    public ProjectExperienceBean(){

    }

    public ProjectExperienceBean(String phone, String projectName, String projectLevel, String fromTime, String toTime, String projectDescription, String jobDescription) {
        this.phone = phone;
        this.projectName = projectName;
        this.projectLevel = projectLevel;
        this.fromTime = fromTime;
        this.toTime = toTime;
        this.projectDescription = projectDescription;
        this.jobDescription = jobDescription;
    }

    @Override
    public String toString() {
        return "ProjectExperienceBean{" +
                "phone='" + phone + '\'' +
                ", projectName='" + projectName + '\'' +
                ", projectLevel='" + projectLevel + '\'' +
                ", fromTime='" + fromTime + '\'' +
                ", toTime='" + toTime + '\'' +
                ", projectDescription='" + projectDescription + '\'' +
                ", jobDescription='" + jobDescription + '\'' +
                '}';
    }
}
