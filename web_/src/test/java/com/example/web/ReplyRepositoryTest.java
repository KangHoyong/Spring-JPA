package com.example.web;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.List;

import com.example.web.reply.Reply;
import com.example.web.reply.ReplyRepository;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReplyRepositoryTest 
{

    @Autowired
    ReplyRepository replyRepository;

    @After
    public void cleaup()
    {
        replyRepository.deleteAll();
    }

    @Test
    public void 댓글저장_불러오기()
    {
        replyRepository.save(Reply.builder()
                .replyContent("테스트 댓글")
                .authorId("yugioh9")
                .build());

        List<Reply> replyList = replyRepository.findAll();
        Reply reply = replyList.get(0);
        assertThat(reply.getReplyContent(), is("테스트 댓글"));
        assertThat(reply.getAuthorId(), is("yugioh9"));
    }

    @Test
    public void BaseTimeEntity_댓글등록()
    {
        LocalDateTime now = LocalDateTime.now();
        replyRepository.save(Reply.builder()
                .replyContent("테스트 댓글")
                .authorId("yugioh9")
                .build());


        List<Reply> replyList = replyRepository.findAll();

        Reply reply = replyList.get(0);
        assertTrue(reply.getCreatedDate().isAfter(now));
        assertTrue(reply.getModifiedDate().isAfter(now));
    }


    

}