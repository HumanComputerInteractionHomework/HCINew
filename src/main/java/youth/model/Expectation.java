package youth.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @author lw
 */


@Entity
@Table(name = "expectation")
public class Expectation {
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private Integer id;

    private String phone;
    private String salary;
    private Integer lowSalary;
    private Integer highSalary;


    public Expectation(){

    }

    public Expectation(String phone, String salary, Integer lowSalary, Integer highSalary) {
        this.phone = phone;
        this.salary = salary;
        this.lowSalary = lowSalary;
        this.highSalary = highSalary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
}
