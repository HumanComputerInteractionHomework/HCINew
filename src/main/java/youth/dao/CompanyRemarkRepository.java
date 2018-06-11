package youth.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import youth.model.CompanyRemark;
import youth.model.Education;

import javax.transaction.Transactional;


public interface CompanyRemarkRepository extends JpaRepository<CompanyRemark, Integer> {


    @Transactional
    void deleteByCompany(@Param("company") String company);

    CompanyRemark findByCompany(String company);


}
