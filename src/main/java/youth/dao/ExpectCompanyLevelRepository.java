package youth.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import youth.model.ExpectCompanyLevel;
import youth.model.ExpectCompanyQuality;

import javax.transaction.Transactional;
import java.util.List;


public interface ExpectCompanyLevelRepository extends JpaRepository<ExpectCompanyLevel, Integer> {


    @Transactional
    void deleteByPhone(@Param("phone") String phone);

    List<ExpectCompanyLevel> findByPhone(String phone);


}
