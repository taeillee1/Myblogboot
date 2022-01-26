package com.cos.myblog.repository;

import com.cos.myblog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//자동으로 bean등록이 된다
//@Repository 생락가능
public interface UserRepository extends JpaRepository<User, Integer> {


}
