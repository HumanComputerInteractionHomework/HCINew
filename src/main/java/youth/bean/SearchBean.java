package youth.bean;

import java.util.Arrays;
import java.util.List;

/*
* @author:lw
*/
public class SearchBean {

    private String jobName;

    // private String salary;
    private Integer salary;

    private  String[] jobCityList;
    //private List<String> jobCityList;
    private String companyNature;
    private String educationDegree;
    //private String jobExperience;
    private Double jobExperience;
    private Integer page;
    private Integer num;

    public SearchBean(){

    }


    public SearchBean(String jobName, Integer salary, String[] jobCityList, String companyNature, String educationDegree, Double jobExperience, Integer page, Integer num) {
        this.jobName = jobName;
        this.salary = salary;
        this.jobCityList = jobCityList;
        this.companyNature = companyNature;
        this.educationDegree = educationDegree;
        this.jobExperience = jobExperience;
        this.page = page;
        this.num = num;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String[] getJobCityList() {
        return jobCityList;
    }

    public void setJobCityList(String[] jobCityList) {
        this.jobCityList = jobCityList;
    }

    public String getCompanyNature() {
        return companyNature;
    }

    public void setCompanyNature(String companyNature) {
        this.companyNature = companyNature;
    }

    public String getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(String educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Double getJobExperience() {
        return jobExperience;
    }

    public void setJobExperience(Double jobExperience) {
        this.jobExperience = jobExperience;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "SearchBean{" +
                "jobName='" + jobName + '\'' +
                ", salary=" + salary +
                ", jobCityList=" + Arrays.toString(jobCityList) +
                ", companyNature='" + companyNature + '\'' +
                ", educationDegree='" + educationDegree + '\'' +
                ", jobExperience=" + jobExperience +
                ", page=" + page +
                ", num=" + num +
                '}';
    }
}

