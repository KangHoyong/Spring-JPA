package com.example.web;

import com.example.web.postsDto.PostsModifyRequestDto;
import com.example.web.postsDto.PostsSaveRequestDto;
import com.example.web.replydto.ReplySaveRequestDto;
import com.example.web.service.PostsService;
import com.example.web.service.ReplyService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor 
public class WebRestController{

    //private PostsRepository postsRepository;
    private PostsService postsService;
    private ReplyService replyService;

    // 생성자 생성해야하나 @AllArgsConstructor 쓰면 자동으로 생성 실제로는 밑에 코드 작성 필요 
    /*
    public WebRestController(PostsRepository postsRepository)
    {
        this.postsRepository = postsRepository;
    }
    */

    @GetMapping("/hello")
    public String hello()
    {
        return "HelloWorld";
    }

    @PostMapping("/posts")
    public Long savePosts(@RequestBody PostsSaveRequestDto dto)
    {
        return postsService.save(dto);
    }

    @PostMapping("/posts/modify")
    public Long postsModify(@RequestBody PostsModifyRequestDto dto)
    {
        return postsService.modify(dto);
    }

    @PostMapping("/posts/delete")
    public Long postsDelete(@RequestBody Long id)
    {
         return postsService.delete(id);
    }

    // 게시글 댓글 영역
    @PostMapping("/posts/reply")
    public Long saveReply(@RequestBody ReplySaveRequestDto dto)
    {
        return replyService.replySave(dto);
    }
    /*
    @PostMapping("/posts/modify")
    public Long postsModify(@RequestBody PostsModifyRequestDto dto)
    {
        return postsService.modify(dto);
    }
    */
    /*
    @PostMapping("/posts")
    public void savePosts(@RequestBody PostsSaveRequestDto dto)
    {
        postsRepository.save(dto.toEntity());
    }
    */

}