package com.cos.myblog.service;

import com.cos.myblog.model.Board;
import com.cos.myblog.model.Reply;
import com.cos.myblog.model.RoleType;
import com.cos.myblog.model.User;
import com.cos.myblog.repository.BoardRepository;
import com.cos.myblog.repository.ReplyRepository;
import com.cos.myblog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Service //스프링이 컴포넌트 스캔을 통해서 bean에 등록을 해준다 ->Ioc를 해준다는 뜻
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private ReplyRepository replyRepository;

    @Transactional //아래의 save함수를 하나의 트렌젝션으로 취급하고 여러개중 하나라도 실패시 롤백
    public void write(Board board, User user){
        board.setCount(0);
        board.setUser(user);
        boardRepository.save(board);
    }

    @Transactional(readOnly = true)
    public Page<Board> list(Pageable pageable,@RequestParam(required = false, defaultValue = "") String searchText){

        return boardRepository.findByTitleContaining(searchText,pageable);
    }

    @Transactional(readOnly = true)
    public Board lookContent(int id){
        return boardRepository.findById(id).orElseThrow(()->{
            return new IllegalArgumentException("글상세보기 실패");
        });
    }

    @Transactional
    public void deleteBoard(int id){
        boardRepository.deleteById(id);
    }

    @Transactional
    public void chageBoard(int id, Board requestBoard){
        Board board = boardRepository.findById(id).orElseThrow(()->{
            return new IllegalArgumentException("글찾기 실패");
        });
        board.setTitle(requestBoard.getTitle());
        board.setContent(requestBoard.getContent());
    }

    @Transactional
    public void replyWrite(User user, int boardId, Reply requestReply){

        Board board = boardRepository.findById(boardId).orElseThrow(()->{
            return new IllegalArgumentException("댓글쓰기 실패");
        });
        requestReply.setUser(user);
        requestReply.setBoard(board);

        replyRepository.save(requestReply);

    }
}
