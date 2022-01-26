package com.cos.myblog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@NoArgsConstructor //파라미터가 없는 기본생성자 생성
@AllArgsConstructor //모든 필드 값을 파라미터로 받는 생성자를 만듦
@Builder
//@DynamicInsert //db insert시에 null필드는 제외시켜준다 그래서 role값에 default값이 들어갈수있게해줌
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//프로젝트에 연결된 데이터베이스의 넘버링 전략을 따라간다는뜻
    private int id;

    @Column(nullable = false,length = 20)
    private String username;

    @Column(nullable = false,length = 100)
    private String password;

    @Column(nullable = false,length = 50)
    private String email;

    @Enumerated(EnumType.STRING)
    private RoleType role;//Enum을 쓰는게 좋다 //권한을 주는것

    @CreationTimestamp //시간이 자동으로 입력이 되게함
    private Timestamp createDate;
}
