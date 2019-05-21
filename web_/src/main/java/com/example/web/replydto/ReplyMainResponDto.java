package com.example.web.replydto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.example.web.reply.Reply;

import lombok.Getter;

@Getter
public class ReplyMainResponDto
{
    private Long id;
    private String replyContent;
    private String authorId;
    private String modifiedDate;

    public ReplyMainResponDto(Reply entity)
    {
        id = entity.getId();
        replyContent = entity.getReplyContent();
        authorId = entity.getAuthorId();

        modifiedDate = toStringDateTime(entity.getModifiedDate());
    }

    public String toStringDateTime(LocalDateTime localDateTime)
    {
        if(localDateTime == null)
        {
            return "";
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return formatter.format(localDateTime);
    }
}