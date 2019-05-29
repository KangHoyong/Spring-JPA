package com.example.web.reply;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

// reply 
public interface ReplyRepository extends JpaRepository<Reply, Long>
{
    // 댓글 조회 
    @Query("SELECT a " +
    "FROM Reply a " +
    "ORDER BY a.id DESC")
    Stream<Reply> findAllDesc();
}