package youth.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import youth.model.JobExperience;
import youth.model.LikedJob;

import javax.transaction.Transactional;

/*
* @author:MAX
*/
public interface LikedJobRepository extends JpaRepository<LikedJob, Integer> {
    @Transactional
int deleteByPhoneAndJobId(String phone,String jobId);





}

