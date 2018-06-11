package youth.bean;

import java.util.List;



public class CompanyDescOutputBean {

/*
* @author:lw
*
*
*/

    private String companyName;
    private String word;
    private Double weight;

    public CompanyDescOutputBean(){

    }

    public CompanyDescOutputBean(String companyName, String word, Double weight) {
        this.companyName = companyName;
        this.word = word;
        this.weight = weight;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "CompanyDescOutputBean{" +
                "companyName='" + companyName + '\'' +
                ", word='" + word + '\'' +
                ", weight=" + weight +
                '}';
    }
}

