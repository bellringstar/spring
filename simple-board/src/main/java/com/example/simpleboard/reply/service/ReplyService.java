package com.example.simpleboard.reply.service;

import com.example.simpleboard.crud.CRUDAbstractService;
import com.example.simpleboard.post.db.PostRepository;
import com.example.simpleboard.reply.db.ReplyEntity;
import com.example.simpleboard.reply.db.ReplyRepository;
import com.example.simpleboard.reply.model.ReplyDto;
import com.example.simpleboard.reply.model.ReplyRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReplyService extends CRUDAbstractService<ReplyDto, ReplyEntity> {
//    private final ReplyRepository replyRepository;
//    private final PostRepository postRepository;
//    private final ReplyConverter replyConverter;
//
//    public ReplyDto create(ReplyRequest replyRequest){
//        var postEntity = postRepository.findById(replyRequest.getPostId());
//
//        if(postEntity.isEmpty()){
//            throw new RuntimeException("게시물이 존재하지 않습니다. : " + replyRequest.getPostId());
//        }
//
//        var entity = ReplyEntity.builder()
//                .post(postEntity.get())
//                .userName(replyRequest.getUserName())
//                .password(replyRequest.getPassword())
//                .status("REGISTERED")
//                .title(replyRequest.getTitle())
//                .content(replyRequest.getContent())
//                .repliedAt(LocalDateTime.now())
//                .build();
//        var saveEntity = replyConverter.toDto(replyRepository.save(entity));
//        return saveEntity;
//    }
//
//    public List<ReplyDto> findAllByPostId(Long postId){
//        List<ReplyEntity> replyEntities = replyRepository.findAllByPostIdAndStatusOrderByIdDesc(postId, "REGISTERED");
//        return replyEntities.stream().map(replyConverter::toDto).collect(Collectors.toList());
//    }
}
