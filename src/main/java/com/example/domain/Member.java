package com.example.domain;


import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@ToString(exclude = "boardList")
public class Member {
    @Id
    private String username;
    private String password;
    private String name;

    @Enumerated(EnumType.ORDINAL)
    private Role role;

    private boolean enabled;

//    @OneToMany(mappedBy = "member")
//    private List<Board> boardList = new ArrayList<Board>();
}
