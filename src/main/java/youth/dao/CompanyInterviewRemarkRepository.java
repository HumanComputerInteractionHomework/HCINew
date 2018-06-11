package youth.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import youth.model.CompanyInterviewRemark;
import youth.model.CompanyRemark;

import javax.transaction.Transactional;


public interface CompanyInterviewRemarkRepository extends JpaRepository<CompanyInterviewRemark, Integer> {


    @Transactional
    void deleteByCompany(@Param("company") String company);

    CompanyInterviewRemark findByCompany(String company);


}
