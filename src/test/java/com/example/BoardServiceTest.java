package com.example;

import com.example.domain.Board;
import com.example.service.BoardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;



@SpringBootTest
class BoardServiceTest {

    @Autowired
    private BoardService boardService;

    @Test
    void testRepositoryMethod() {
        Board board = new Board();
        board.setTitle("JPA 제목");
//        board.setWriter("제이");
        board.setContent("JPA.........");
        boardService.insertBoard(board);


//        board.setSeq(1L);
//        Board findBoard = boardService.getBoard(board);
//        findBoard.setTitle("---제목 수정---");
//        boardService.updateBoard(findBoard);

//        boardService.deleteBoard(findBoard);

        List<Board> boardList = boardService.getBoardList();
        for (Board brd : boardList) {
            System.out.println(brd.toString());
        }
    }

}