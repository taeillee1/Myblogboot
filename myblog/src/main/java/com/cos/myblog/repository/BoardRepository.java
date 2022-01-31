package com.cos.myblog.repository;

import com.cos.myblog.model.Board;
import com.cos.myblog.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//자동으로 bean등록이 된다
//@Repository 생락가능
public interface BoardRepository extends JpaRepository<Board, Integer> {
    Page<Board> findByTitleContaining(String title,  Pageable pageable);
}