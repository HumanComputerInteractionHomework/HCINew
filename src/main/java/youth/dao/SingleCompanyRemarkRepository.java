package youth.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import youth.model.CompanyRemark;
import youth.model.SingleCompanyRemark;

import java.util.List;


public interface SingleCompanyRemarkRepository extends JpaRepository<SingleCompanyRemark, Integer> {


//    @Transactional
//    void deleteByPhone(@Param("phone") String phone);

    List<SingleCompanyRemark>  findByCompany(String company);


}
