package youth.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import youth.model.Education;
import youth.model.JobExperience;
import youth.model.ProjectExperience;

import javax.transaction.Transactional;
import java.util.List;


public interface ProjectExperienceRepository extends JpaRepository<ProjectExperience, Integer> {


    @Transactional
    void deleteByPhone(@Param("phone") String phone);

    List<ProjectExperience> findByPhone(String phone);

}
