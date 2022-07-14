package com.example.service;


import com.example.domain.Board;
import com.example.persistence.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    public void insertBoard(Board board) {
        boardRepository.save(board);
    }

    public void updateBoard(Board board) {
        Board findBoard = boardRepository.findById(board.getSeq()).get();
        findBoard.setTitle(board.getTitle());
        findBoard.setContent(board.getContent());
        boardRepository.save(findBoard);
    }

    public void deleteBoard(Board board) {
        boardRepository.deleteById(board.getSeq());
    }

    public Board getBoard(Board board) {
        return boardRepository.findById(board.getSeq()).get();
    }

    public List<Board> getBoardList() {
        Pageable paging = (Pageable) PageRequest.of(0, 100);
        return boardRepository.findByTitleContaining("", paging);
    }
}
