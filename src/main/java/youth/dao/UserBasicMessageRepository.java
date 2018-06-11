package youth.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import youth.bean.JobExperienceBean;
import youth.bean.UserBasicMessageBean;
import youth.model.JobExperience;
import youth.model.UserBasicMessage;

import javax.transaction.Transactional;
import java.util.List;


public interface UserBasicMessageRepository extends JpaRepository<UserBasicMessage, Integer> {


    @Transactional
    void deleteByPhone(@Param("phone") String phone);

    UserBasicMessage findByPhone(String phone);


}
