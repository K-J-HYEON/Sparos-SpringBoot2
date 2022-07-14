package com.example.domain;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Board {
    @Id
    @GeneratedValue
    private Long seq;

    private String title;

    @Column(updatable = false)
    private String wriete;

    private String content;

    @Column(insertable = false, updatable = false, columnDefinition = "date default sysdate")
    private Date createDate;

    @Column(insertable = false, updatable = false, columnDefinition = "number default 0")
    private Long cnt = 0L;


}
