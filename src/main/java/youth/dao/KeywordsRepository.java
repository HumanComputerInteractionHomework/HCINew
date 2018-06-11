package youth.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import youth.model.JobVector;
import youth.model.Keywords;

import java.util.List;


public interface KeywordsRepository extends JpaRepository<Keywords, String>,JpaSpecificationExecutor<Keywords>{

//    @Transactional
//    @Modifying
//    @Query(value = "UPDATE user u set u.password =:pa WHERE u.phone =:ph", nativeQuery = true)
//    int editPassword(@Param("ph") String phone, @Param("pa") String password);

    @Query(value = "SELECT * from keywords u WHERE u.keywords LIKE %?1%", nativeQuery = true)
    List<Keywords> findThroughKey(String keywords );

    //TODO 现在只是在keywords表里面的字段完全匹配，所以只对应表的一条记录，但是
    //会有这样的问题，如果用户模糊搜索输入“架构师“，提取简拼为jgs，然后keywords表没有这样的，故默认返回22（其他），然后在job_class
    //ification表里面就查到“客户代表”这样的职位，并返回。。
    Keywords findByKeywords(String keywords );

}
