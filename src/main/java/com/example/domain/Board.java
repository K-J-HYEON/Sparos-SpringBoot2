package com.example.domain;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class Board {
    @Id
    @GeneratedValue
    private Long seq;
    private String title;
    private String writer;
    private String content;
    private Date createDate = new Date();
    private Long cnt = 0L;
}
