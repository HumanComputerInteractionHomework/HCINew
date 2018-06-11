package youth.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import youth.model.ExpectLocation;
import youth.model.Honor;

import javax.transaction.Transactional;
import java.util.List;


public interface ExpectLocationRepository extends JpaRepository<ExpectLocation, Integer> {


    @Transactional
    void deleteByPhone(@Param("phone") String phone);

    List<ExpectLocation> findByPhone(String phone);


}
