package com.example.web.postsDto;

//import static org.mockito.ArgumentMatchers.endsWith;

import com.example.web.posts.Posts;

import lombok.Getter;

@Getter
public class PostsInfoResponseDto
{
    private Long id;
    private String title;
    private String content;
    private String author;

    public PostsInfoResponseDto(Posts entity)
    {
        id = entity.getId();
        title = entity.getTitle();
        content = entity.getContent();
        author = entity.getAuthor();
    }
}