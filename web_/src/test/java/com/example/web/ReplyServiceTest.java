package com.example.web;

import com.example.web.reply.Reply;
import com.example.web.reply.ReplyRepository;
import com.example.web.replydto.ReplySaveRequestDto;
import com.example.web.service.ReplyService;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest

public class ReplyServiceTest
{
    @Autowired
    private ReplyService replyService;

    @Autowired
    private ReplyRepository replyRepository;

    @After
    public void cleanup()
    {
        replyRepository.deleteAll();
    }

    @Test
    public void Dto데이터가reply테이블에저장체크()
    {
        ReplySaveRequestDto dto =  ReplySaveRequestDto.builder()
                    .replyContent("테스트 댓글")
                    .authorId("yugioh9")
                    .build();

        replyService.replySave(dto);

        Reply reply = replyRepository.findAll().get(0);
        assertThat(reply.getReplyContent()).isEqualTo(dto.getReplyContent());
        assertThat(reply.getAuthorId()).isEqualTo(dto.getAuthorId());


    }

}