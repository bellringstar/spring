package com.example.simpleboard.board.controller;

import com.example.simpleboard.board.db.BoardEntity;
import com.example.simpleboard.board.model.BoardDto;
import com.example.simpleboard.board.model.BoardRequest;
import com.example.simpleboard.board.service.BoardConverter;
import com.example.simpleboard.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor
@Slf4j
public class BoardApiController {

    private final BoardService boardService;
    private final BoardConverter boardConverter;

    @PostMapping("")
    public BoardDto create(@Valid @RequestBody BoardRequest boardRequest){
        return boardService.create(boardRequest);
    }

    @GetMapping("/id/{id}")
    public BoardDto view(@PathVariable Long id){
        var entity = boardService.view(id);
        log.info(entity.toString());
        return entity;
    }
}
