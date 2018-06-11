package youth.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;
import youth.model.Education;
import youth.model.JobVector;

import javax.transaction.Transactional;



public interface JobVectorRepository extends JpaRepository<JobVector, Integer>,JpaSpecificationExecutor<JobVector>{

    JobVector findByJobCity(String jobCity);


}
