package com.example.demo;

import com.example.domain.Board;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;


//@Service
public class BoardServiceRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // EntityManagerFactory 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BoardWeb");

        // EntityManager 생성
        EntityManager em = emf.createEntityManager();

        // EntityTransaction 생성
        EntityTransaction tx = em.getTransaction();

        // Transaction 시작
        tx.begin();

        // 데이터 등록
        for (int i = 1; i <= 10; i++) {
            Board board = new Board();
            board.setTitle("MyBatis 제목");
//            board.setWriter("제이");
            board.setContent("MyBatis 내용........");
            em.persist(board);
        }

        // 글 목록 조회
        String jpql = "SELECT b FROM Board b WHERE b.seq > 5 ORDER BY b.seq DESC";
        List<Board> boardList = em.createQuery(jpql, Board.class).getResultList();
        for (Board board : boardList) {
            System.out.println("---> " + board.toString());
        }



//        // 데이터 수정
//        Board board = em.find(Board.class, 1L);
//        board.setTitle("---제목 수정---");
//        board.setContent("---내용 수정---");
//
//
//        // 데이터 삭제
//        em.remove(board);

        // Transaction 종료
        tx.commit();

        // EntityManagerFactory, EntityManager 종료
        em.close();
        emf.close();
    }
}
