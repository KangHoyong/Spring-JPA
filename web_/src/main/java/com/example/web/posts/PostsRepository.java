package com.example.web.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


import java.util.stream.Stream;

public interface PostsRepository extends JpaRepository<Posts, Long>
{
    // 게시판 조회 쿼리 
    @Query("SELECT a " +
    "FROM Posts a " +
    "ORDER BY a.id DESC")
    Stream<Posts> findAllDesc();

    
    // 게시판 수정 쿼리 
    @Modifying
    @Query("UPDATE Posts p "
            + "SET p.title = ?1, "
            + "p.content = ?2, "
            + "p.author = ?3 "
            + "WHERE p.id = ?4")
    void modify(String title, String content, String author, Long id);
    
}


