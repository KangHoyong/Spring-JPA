package com.example.web.replydto;

import com.example.web.reply.Reply;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReplySaveRequestDto
{
    private String replyContent;
    private String authorId;

    public Reply toEntity()
    {
        return Reply.builder()
            .replyContent(replyContent)
            .authorId(authorId)
            .build();
    }

    @Builder
    public ReplySaveRequestDto(String replyContent, String authorId)
    {
        this.replyContent = replyContent;
        this.authorId = authorId;
    }

}