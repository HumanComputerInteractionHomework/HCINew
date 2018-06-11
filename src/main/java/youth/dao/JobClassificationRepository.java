package youth.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import youth.model.JobClassification;
import youth.model.Keywords;


public interface JobClassificationRepository extends JpaRepository<JobClassification, String>,JpaSpecificationExecutor<JobClassification>{

   //JobClassification findByKeywords(String keywords);

}
