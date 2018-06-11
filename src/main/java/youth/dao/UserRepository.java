package youth.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import youth.model.User;

import javax.transaction.Transactional;



public interface UserRepository extends JpaRepository<User, Integer> {

    User findByPhone(String phone);
    @Transactional
    @Modifying
    @Query(value = "UPDATE user u set u.password =:pa WHERE u.phone =:ph", nativeQuery = true)
    int editPassword(@Param("ph")String phone,@Param("pa") String password);











}
