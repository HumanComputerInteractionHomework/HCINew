package youth.model;

import lombok.Data;

import javax.persistence.*;

/*
* @author:MAX
*/

@Entity
@Table(name = "job2_0")
public class JobDetail {


    @Id
    private Integer id;

    @Column(name = "job_id")
    private String jobId;
    @Column(name = "job_name")
    private String jobName;
    @Column(name = "job_location")
    private String jobLocation;
    @Column(name = "salary")
    private String salary;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "company_nature")
    private String companyNature;
    @Column(name = "company_people_num")
    private String companyPeopleNum;
    @Column(name = "companyIndustry")
    private String companyIndustry;
    @Column(name = "job_experience")
    private String jobExperience;

    @Column(name = "education_degree")
    private String educationDegree;
    @Column(name = "job_people_num")
    private String jobPeopleNum;
    @Column(name = "job_time")
    private String jobTime;
    @Column(name = "welfare")
    private String welfare;
    @Column(name = "job_description")
    private String jobDescription;
    @Column(name = "company_description")
    private String companyDescription;
    @Column(name = "job_description_html")
    private String jobDescriptionHtml;
    @Column(name = "company_description_html")
    private String companyDescriptionHtml;
    @Column(name = "job_city")
    private String jobCity;
    @Column(name = "salary_low")
    private Integer salaryLow;
    @Column(name = "salary_high")
    private Integer salaryHigh;
    @Column(name = "company_people_num_low")
    private Integer companyPeopleNumLow;
    @Column(name = "company_people_num_high")
    private Integer companyPeopleNumHigh;

    public JobDetail(){

    }

    public JobDetail(Integer id, String jobId, String jobName, String jobLocation, String salary, String companyName, String companyNature, String companyPeopleNum, String companyIndustry, String jobExperience, String educationDegree, String jobPeopleNum, String jobTime, String welfare, String jobDescription, String companyDescription, String jobDescriptionHtml, String companyDescriptionHtml, String jobCity, Integer salaryLow, Integer salaryHigh, Integer companyPeopleNumLow, Integer companyPeopleNumHigh) {
        this.id = id;
        this.jobId = jobId;
        this.jobName = jobName;
        this.jobLocation = jobLocation;
        this.salary = salary;
        this.companyName = companyName;
        this.companyNature = companyNature;
        this.companyPeopleNum = companyPeopleNum;
        this.companyIndustry = companyIndustry;
        this.jobExperience = jobExperience;
        this.educationDegree = educationDegree;
        this.jobPeopleNum = jobPeopleNum;
        this.jobTime = jobTime;
        this.welfare = welfare;
        this.jobDescription = jobDescription;
        this.companyDescription = companyDescription;
        this.jobDescriptionHtml = jobDescriptionHtml;
        this.companyDescriptionHtml = companyDescriptionHtml;
        this.jobCity = jobCity;
        this.salaryLow = salaryLow;
        this.salaryHigh = salaryHigh;
        this.companyPeopleNumLow = companyPeopleNumLow;
        this.companyPeopleNumHigh = companyPeopleNumHigh;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobLocation() {
        return jobLocation;
    }

    public void setJobLocation(String jobLocation) {
        this.jobLocation = jobLocation;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyNature() {
        return companyNature;
    }

    public void setCompanyNature(String companyNature) {
        this.companyNature = companyNature;
    }

    public String getCompanyPeopleNum() {
        return companyPeopleNum;
    }

    public void setCompanyPeopleNum(String companyPeopleNum) {
        this.companyPeopleNum = companyPeopleNum;
    }

    public String getCompanyIndustry() {
        return companyIndustry;
    }

    public void setCompanyIndustry(String companyIndustry) {
        this.companyIndustry = companyIndustry;
    }

    public String getJobExperience() {
        return jobExperience;
    }

    public void setJobExperience(String jobExperience) {
        this.jobExperience = jobExperience;
    }

    public String getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(String educationDegree) {
        this.educationDegree = educationDegree;
    }

    public String getJobPeopleNum() {
        return jobPeopleNum;
    }

    public void setJobPeopleNum(String jobPeopleNum) {
        this.jobPeopleNum = jobPeopleNum;
    }

    public String getJobTime() {
        return jobTime;
    }

    public void setJobTime(String jobTime) {
        this.jobTime = jobTime;
    }

    public String getWelfare() {
        return welfare;
    }

    public void setWelfare(String welfare) {
        this.welfare = welfare;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getCompanyDescription() {
        return companyDescription;
    }

    public void setCompanyDescription(String companyDescription) {
        this.companyDescription = companyDescription;
    }

    public String getJobDescriptionHtml() {
        return jobDescriptionHtml;
    }

    public void setJobDescriptionHtml(String jobDescriptionHtml) {
        this.jobDescriptionHtml = jobDescriptionHtml;
    }

    public String getCompanyDescriptionHtml() {
        return companyDescriptionHtml;
    }

    public void setCompanyDescriptionHtml(String companyDescriptionHtml) {
        this.companyDescriptionHtml = companyDescriptionHtml;
    }

    public String getJobCity() {
        return jobCity;
    }

    public void setJobCity(String jobCity) {
        this.jobCity = jobCity;
    }

    public Integer getSalaryLow() {
        return salaryLow;
    }

    public void setSalaryLow(Integer salaryLow) {
        this.salaryLow = salaryLow;
    }

    public Integer getSalaryHigh() {
        return salaryHigh;
    }

    public void setSalaryHigh(Integer salaryHigh) {
        this.salaryHigh = salaryHigh;
    }

    public Integer getCompanyPeopleNumLow() {
        return companyPeopleNumLow;
    }

    public void setCompanyPeopleNumLow(Integer companyPeopleNumLow) {
        this.companyPeopleNumLow = companyPeopleNumLow;
    }

    public Integer getCompanyPeopleNumHigh() {
        return companyPeopleNumHigh;
    }

    public void setCompanyPeopleNumHigh(Integer companyPeopleNumHigh) {
        this.companyPeopleNumHigh = companyPeopleNumHigh;
    }

    @Override
    public String toString() {
        return "JobDetail{" +
                "id=" + id +
                ", jobId='" + jobId + '\'' +
                ", jobName='" + jobName + '\'' +
                ", jobLocation='" + jobLocation + '\'' +
                ", salary='" + salary + '\'' +
                ", companyName='" + companyName + '\'' +
                ", companyNature='" + companyNature + '\'' +
                ", companyPeopleNum='" + companyPeopleNum + '\'' +
                ", companyIndustry='" + companyIndustry + '\'' +
                ", jobExperience='" + jobExperience + '\'' +
                ", educationDegree='" + educationDegree + '\'' +
                ", jobPeopleNum='" + jobPeopleNum + '\'' +
                ", jobTime='" + jobTime + '\'' +
                ", welfare='" + welfare + '\'' +
                ", jobDescription='" + jobDescription + '\'' +
                ", companyDescription='" + companyDescription + '\'' +
                ", jobDescriptionHtml='" + jobDescriptionHtml + '\'' +
                ", companyDescriptionHtml='" + companyDescriptionHtml + '\'' +
                ", jobCity='" + jobCity + '\'' +
                ", salaryLow=" + salaryLow +
                ", salaryHigh=" + salaryHigh +
                ", companyPeopleNumLow=" + companyPeopleNumLow +
                ", companyPeopleNumHigh=" + companyPeopleNumHigh +
                '}';
    }
}

