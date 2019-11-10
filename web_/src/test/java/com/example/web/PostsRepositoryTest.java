package com.example.web;


import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.List;

import com.example.web.posts.Posts;
import com.example.web.posts.PostsRepository;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import static org.hamcrest.CoreMatchers.is;




@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest
{
    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanup()
    {
        postsRepository.deleteAll();
        /*
        이후 테스트 코드에 영향을 끼치지 않기 위해 
        테스트 메소드가 끝날때 마다 respository 전체 비우는 코드
        */
    }

    @Test
    public void 게시글저장_불러오기() {

        //given 
        postsRepository.save(Posts.builder()
            .title("테스트 게시글")
            .content("테스트 본문")
            .author("yugioh9@naver.com")
            .build()
        );

        //when
        List<Posts> postsList = postsRepository.findAll();
        
        //then 
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle(), is("테스트 게시글"));
        assertThat(posts.getContent(), is("테스트 본문"));
    }

    @Test
    public void BaseTimeEntity_등록() {

        //given
        LocalDateTime now = LocalDateTime.now();
        postsRepository.save(Posts.builder()
            .title("테스트 게시글")
            .content("테스트 분문")
            .author("yugioh9@naver.com")
            .build());

        //when
        List<Posts> postsList = postsRepository.findAll();
        //then 
        Posts posts = postsList.get(0);
        assertTrue(posts.getCreatedDate().isAfter(now));
        assertTrue(posts.getModifiedDate().isAfter(now));

    }


}
