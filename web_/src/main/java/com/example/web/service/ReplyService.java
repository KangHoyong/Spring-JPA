package com.example.web.service;

import java.util.List;
import java.util.stream.Collectors;

import com.example.web.reply.ReplyRepository;
import com.example.web.replydto.ReplyMainResponDto;
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

    @Transactional(readOnly = true)
    public List<ReplyMainResponDto> findAllDesc()
    {
        return replyRepository.findAllDesc()
                .map(ReplyMainResponDto::new)
                .collect(Collectors.toList());
    }
    
  
   

    
}