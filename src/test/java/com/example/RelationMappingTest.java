package com.example;

import com.example.domain.Board;
import com.example.domain.Member;
import com.example.persistence.BoardRepository;
import com.example.persistence.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class RelationMappingTest {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void testOneToMany() {
        Member member = memberRepository.findById("member1").get();

        System.out.println("=============================");
        System.out.println(member.getName() + "가(이) 저장한 게시글 목록");
        System.out.println("=============================");
//        List<Board> list = member.getBoardList();
//        for (Board board : list) {
//            System.out.println(board.toString());
        }
//    }


//    @Test
    public void testManyToOne() {
        Board board = boardRepository.findById(5L).get();

        System.out.println("[ " + board.getSeq() + "번 게시글 정보 ]");
        System.out.println("제목 : " + board.getTitle());
        System.out.println("내용 : " + board.getContent());
//        System.out.println("작성자 : " + board.getMember().getName());
//        System.out.println("작성자 권한 : " + board.getMember().getRole());
    }

//    @BeforeEach
    public void testInsert() {
        Member member1 = new Member();
//        member1.setId("member1");
        member1.setPassword("member111");
        member1.setName("제이");
//        member1.setRole("User");
        memberRepository.save(member1);

        Member member2 = new Member();
//        member2.setId("member2");
        member2.setPassword("member222");
        member2.setName("제이지");
//        member2.setRole("Admin");
        memberRepository.save(member2);

        for (int i = 1; i <= 3; i++) {
            Board board = new Board();
            board.setTitle("제이가 등록한 게시글 " + i);
            board.setContent("제이가 등록한 게시글 내용 " + i);
            board.setCreateDate(new Date());
            board.setCnt(0L);
//            board.setMember(member1);
            boardRepository.save(board);
        }

        for (int i = 1; i <= 3; i++) {
            Board board = new Board();
            board.setTitle("제이지가 등록한 게시글 " + i);
            board.setContent("제이지가 등록한 게시글 내용 " + i);
            board.setCreateDate(new Date());
            board.setCnt(0L);
//            board.setMember(member2);
            boardRepository.save(board);
        }
    }
}
