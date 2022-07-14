package com.example.demo;

import com.example.domain.Board;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


@Service
public class BoardServiceRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // EntityManagerFactory 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BoardWeb");

        // EntityManager 생성
        EntityManager em = emf.createEntityManager();

        Board board = em.find(Board.class, 1L);
        System.out.println("검색된 게시 글 : " + board.toString());

        // EntityManagerFactory, EntityManager 종료
        em.close();
        emf.close();
    }
}
