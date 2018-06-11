package youth.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import youth.model.CompanyDescriptionOutput;
import youth.model.CompanyInterviewRemark;

import javax.transaction.Transactional;
import java.util.List;


public interface CompanyDescriptionOutputRepository extends JpaRepository<CompanyDescriptionOutput, Integer> {


    @Transactional
    void deleteByCompanyName(@Param("companyName") String companyName);

    List<CompanyDescriptionOutput> findByCompanyName(String companyName);


}
