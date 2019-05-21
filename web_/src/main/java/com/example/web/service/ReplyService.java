package com.example.web.service;

import com.example.web.reply.ReplyRepository;
import com.example.web.replydto.ReplySaveRequestDto;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service

public class ReplyService 
{
    private ReplyRepository replyRepository;

    @Transactional
    public Long replySave(ReplySaveRequestDto dto)
    {
        return replyRepository.save(dto.toEntity()).getId();
    }

    
}