package com.example.web.service;

//import static org.mockito.Mockito.RETURNS_SELF;

import java.util.List;
import java.util.stream.Collectors;


import com.example.web.postsDto.PostsInfoResponseDto;
import com.example.web.postsDto.PostsMainResponseDto;
import com.example.web.postsDto.PostsModifyRequestDto;
import com.example.web.postsDto.PostsSaveRequestDto;
import com.example.web.posts.PostsRepository;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PostsService
{
    private PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto dto)
    {
        return postsRepository.save(dto.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    public List<PostsMainResponseDto> findAllDesc()
    {
            return postsRepository.findAllDesc()
            .map(PostsMainResponseDto::new)
            .collect(Collectors.toList());
    }
    @Transactional(readOnly = true)
    public PostsInfoResponseDto findPosts(Long id)
    {
        return postsRepository.findById(id)
        .map(PostsInfoResponseDto::new).get();
       
    }

    // 게시글 수정 
    @Transactional
    public Long modify(PostsModifyRequestDto dto)
    {
        if(postsRepository.existsById(dto.getId())) 
        {
             postsRepository.modify(dto.getTitle(), dto.getContent(), dto.getAuthor(), dto.getId());
        }  
        return dto.getId();
    }

    // 게시글 삭제 
    @Transactional
    public Long delete(Long id)
    {
        //existsByid() 메소드로 데이터를 조회하고 테이블에 데이터가 존재하면 deletebyid() 메소드로 삭제 쿼리 실행 
        if(postsRepository.existsById(id))
        {
            postsRepository.deleteById(id);
        }
        return id;

    }
   
}