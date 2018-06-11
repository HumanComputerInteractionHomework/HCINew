package youth.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import youth.model.ProjectExperience;
import youth.model.Skill;

import javax.transaction.Transactional;
import java.util.List;


public interface SkillRepository extends JpaRepository<Skill, Integer> {


    @Transactional
    void deleteByPhone(@Param("phone") String phone);

    List<Skill> findByPhone(String phone);

}
