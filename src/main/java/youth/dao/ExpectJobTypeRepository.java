package youth.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import youth.model.ExpectJobType;
import youth.model.ExpectLocation;

import javax.transaction.Transactional;
import java.util.List;


public interface ExpectJobTypeRepository extends JpaRepository<ExpectJobType, Integer> {


    @Transactional
    void deleteByPhone(@Param("phone") String phone);

    List<ExpectJobType> findByPhone(String phone);


}
