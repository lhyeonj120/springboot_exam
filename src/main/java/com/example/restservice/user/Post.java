package com.example.restservice.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
//    @Id
//    @GeneratedValue
    private Integer id;

    private String description;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JsonIgnore //연관관계는 설정하고 출력은 하지 않겠다
//    private User user;
    private int user_id;
}
