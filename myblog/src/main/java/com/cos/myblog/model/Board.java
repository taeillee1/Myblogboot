package com.cos.myblog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

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

    @ColumnDefault("0")
    private int count;

    @ManyToOne // Many = Board , User = one 한명은 여러개의 게시글 쓸수있음 여러개의 게시글은 한명에게 쓰일수있음
    @JoinColumn(name = "userId")
    private User user; //DB는 오브젝트 저장불가, Java는 오브젝트 저장가능

    @CreationTimestamp
    private Timestamp createDate;

}
