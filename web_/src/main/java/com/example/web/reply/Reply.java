package com.example.web.reply;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;

import com.example.web.BaseTimeEntity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity

// Entity 클래스 
public class Reply extends BaseTimeEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //기본값은 AUTO 로, MySQL의 auto_increment와 같이 자동증가하는 정수형 값이 됩니다.
    private Long id;

    @Column(columnDefinition = "TEXT" , nullable = false)
    private String replyContent;

    @Column(length = 500, nullable = false)
    private String authorId;

    @Builder
    public Reply(String replyContent, String authorId)
    {
            this.replyContent = replyContent;
            this.authorId = authorId;
    }
}