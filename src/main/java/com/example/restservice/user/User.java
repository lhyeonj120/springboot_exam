package com.example.restservice.user;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@JsonIgnoreProperties(value = {"password", "ssn"})
//@JsonFilter("UserInfo")
@Entity
public class User {
    @Id //주키
    @GeneratedValue //1씩 증가(DB에 따라 다름)
    private Integer id;
    @Size(min = 2, message = "Name은 2글자 이상 입력하세요")
    private String name;
    private Date joinDate;

    //@JsonIgnore
    private String password;
    private String ssn;

    @OneToMany(mappedBy = "user")
    private List<Post> posts;
}
