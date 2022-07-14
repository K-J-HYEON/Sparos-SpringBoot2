package com.example.controller;

import com.example.domain.Board;
import com.example.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

// RestController은 Rest 메소드가 리턴한 문자열을 JSON 형태로 전달하기 때문에 Controller을 씀
@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/board/insertBoard")
    public String insertBoardView() {
        return "/board/insertBoard";
    }

    @PostMapping("/board/insertBoard")
    public String insertBoard(Board board) {
        boardService.insertBoard(board);
        return "redirect:/board/getBoardList";
    }

    @PostMapping("/board/updateBoard")
    public String updateBoard(Board board) {
        boardService.updateBoard(board);
        return "forward:/board/getBoardList";
    }

    @GetMapping("/board/deleteBoard")
    public String deleteBoard(Board board) {
        boardService.deleteBoard(board);
        return "forward:/board/getBoatdList";
    }

    @GetMapping("/board/getBoatd")
    public String getBoard(Board board, Model model) {
        model.addAttribute("board", boardService.getBoard(board));
        return "/board/getBoard";
    }

    @RequestMapping("/board/getBoardList")
    public String getBoardList(Board board, Model model) {
        List<Board> boardList = boardService.getBoardList();

        model.addAttribute("boardList", boardList);
        return "getBoardList";
    }
}
