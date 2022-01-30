package com.cos.myblog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//autoincrement 쓴다는말
    private int id;

    @Column(nullable = false, length = 100)
    private String title;

    @Lob //large object라는 뜻
    private String content;

    private int count; //조회수

    @ManyToOne(fetch = FetchType.EAGER) // Many = Board , User = one 한명은 여러개의 게시글 쓸수있음 여러개의 게시글은 한명에게 쓰일수있음
    @JoinColumn(name = "userId")
    private User user; //DB는 오브젝트 저장불가, Java는 오브젝트 저장가능

    @OneToMany(mappedBy = "board",fetch = FetchType.EAGER) //연관관계의 주인이 아니다 DB에 칼럼을 만들지마라 board를 select할떄 값을 얻기위해 쓰는 겁니다
    private List<Reply> reply;

    @CreationTimestamp
    private Timestamp createDate;

}
