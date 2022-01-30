package com.cos.myblog.repository;

import com.cos.myblog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//자동으로 bean등록이 된다
//@Repository 생락가능
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);

}


//    User findByUsernameAndPassword(String username, String password);

//    @Query(value = "SELECT * FROM user WHERE username =? AND password = ?", nativeQuery = true)
//    User login(String username, String password);
// findBy저거랑 이거랑 똑같은것임