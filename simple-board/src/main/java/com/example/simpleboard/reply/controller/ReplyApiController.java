package com.example.simpleboard.reply.controller;

import com.example.simpleboard.crud.CRUDApiAbstractApiController;
import com.example.simpleboard.reply.db.ReplyEntity;
import com.example.simpleboard.reply.model.ReplyDto;
import com.example.simpleboard.reply.model.ReplyRequest;
import com.example.simpleboard.reply.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/reply")
@RequiredArgsConstructor
public class ReplyApiController extends CRUDApiAbstractApiController<ReplyDto, ReplyEntity> {

/*    private final ReplyService replyService;

    @PostMapping("")
    public ReplyDto create(@Valid @RequestBody ReplyRequest replyRequest){
        return replyService.create(replyRequest);
    }*/
}
