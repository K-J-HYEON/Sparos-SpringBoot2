package com.example.persistence;

import com.example.domain.Board;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.awt.print.Pageable;
import java.util.List;

public interface BoardRepository extends CrudRepository<Board, Long> {

    List<Board> findByTitleContaining(String searchKeyword, Pageable paging);

    @Query(value = "SELECT * FROM BOARD WHERE TITLE LIKE '%'||:keyword|| '%' ORDER BY SEQ DESC",
            nativeQuery = true)
    List<Board> getBoardList(@Param("keyword") String searchKeyword);
}
