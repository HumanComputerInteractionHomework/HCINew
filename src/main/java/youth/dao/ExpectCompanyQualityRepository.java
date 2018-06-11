package youth.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import youth.model.ExpectCompanyQuality;
import youth.model.ExpectLocation;

import javax.transaction.Transactional;
import java.util.List;


public interface ExpectCompanyQualityRepository extends JpaRepository<ExpectCompanyQuality, Integer> {


    @Transactional
    void deleteByPhone(@Param("phone") String phone);

    List<ExpectCompanyQuality> findByPhone(String phone);


}
