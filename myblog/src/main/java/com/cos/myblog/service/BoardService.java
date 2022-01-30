package com.cos.myblog.service;

import com.cos.myblog.model.Board;
import com.cos.myblog.model.RoleType;
import com.cos.myblog.model.User;
import com.cos.myblog.repository.BoardRepository;
import com.cos.myblog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service //스프링이 컴포넌트 스캔을 통해서 bean에 등록을 해준다 ->Ioc를 해준다는 뜻
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Transactional //아래의 save함수를 하나의 트렌젝션으로 취급하고 여러개중 하나라도 실패시 롤백
    public void write(Board board, User user){
        board.setCount(0);
        board.setUser(user);
        boardRepository.save(board);
    }
}
