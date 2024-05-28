package com.jwt.jwt.repostry;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jwt.jwt.model.User;




@Repository
public interface UserRepostry extends JpaRepository<User, Long> {
	
	@Query(value="select * from User u where u.email_Id=:emailId and u.password=:password",nativeQuery =true)
	User findOneByemailIdignorecaseAndpassword(String emailId, String password);

}
