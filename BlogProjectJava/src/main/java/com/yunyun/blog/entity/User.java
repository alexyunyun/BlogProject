package com.yunyun.blog.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

/**
 * @author 旋木頵頵
 * @date 2021/2/10 13:28
 */
@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;
    private String avatar;
    private String email;
    private String password;
    private Integer status;
    private Date created;
    private Date last_login;
}
