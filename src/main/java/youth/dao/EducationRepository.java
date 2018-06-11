package youth.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import youth.model.Education;
import youth.model.JobExperience;

import javax.transaction.Transactional;
import java.util.List;


public interface EducationRepository extends JpaRepository<Education, Integer> {

//    User findByPhone(String phone);
//    @Transactional
//    @Modifying
//    @Query(value = "UPDATE user u set u.password =:pa WHERE u.phone =:ph", nativeQuery = true)
//    int editPassword(@Param("ph") String phone, @Param("pa") String password);

//    @Transactional
//    @Modifying
//    @Query(value = "DELETE from job_experience u WHERE u.phone =:ph ", nativeQuery = true)
//    int cleanBeforeInfo(@Param("ph")String phone);

    @Transactional
    void deleteByPhone(@Param("phone") String phone);

    Education findByPhone(String phone);


}
