package youth.bean;



public class JobDescOutputBean {

/*
* @author:lw
*
*
*/

    private String jobId;
    private String word;
    private Double weight;

    public JobDescOutputBean(){

    }

    public JobDescOutputBean(String jobId, String word, Double weight) {
        this.jobId = jobId;
        this.word = word;
        this.weight = weight;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
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
        return "JobDescOutputBean{" +
                "jobId='" + jobId + '\'' +
                ", word='" + word + '\'' +
                ", weight=" + weight +
                '}';
    }
}

