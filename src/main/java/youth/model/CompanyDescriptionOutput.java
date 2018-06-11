package youth.model;

import javax.persistence.*;

/**
 * @author lw
 */


@Entity
@Table(name = "company_description_output")
public class CompanyDescriptionOutput {

    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "word_id")
    @Id
    private Integer wordId;

    private String companyName;
    private String word;
    private Double weight;


    public CompanyDescriptionOutput(){

    }

    public CompanyDescriptionOutput(String companyName, String word, Double weight) {
        this.companyName = companyName;
        this.word = word;
        this.weight = weight;
    }

    public Integer getWordId() {
        return wordId;
    }

    public void setWordId(Integer wordId) {
        this.wordId = wordId;
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
}

