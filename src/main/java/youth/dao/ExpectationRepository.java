package youth.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import youth.model.Expectation;
import youth.model.Skill;

import javax.transaction.Transactional;
import java.util.List;


public interface ExpectationRepository extends JpaRepository<Expectation, Integer> {


    @Transactional
    void deleteByPhone(@Param("phone") String phone);

    Expectation findByPhone(String phone);

}
