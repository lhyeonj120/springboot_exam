package com.example.restservice.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(value = {"password", "ssn"})
public class User {
    private Integer id;
    @Size(min = 2, message = "Name은 2글자 이상 입력하세요")
    private String name;
    private Date joinDate;

    //@JsonIgnore
    private String password;
    private String ssn;
}
