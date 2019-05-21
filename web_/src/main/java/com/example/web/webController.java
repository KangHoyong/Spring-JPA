package com.example.web;

import com.example.web.service.PostsService;
import com.example.web.service.ReplyService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class webController 
{
    private PostsService postsService;
    private ReplyService replyService;
    
    @GetMapping("/")
    public String main(Model model)
    {
        model.addAttribute("posts", postsService.findAllDesc());
        return "main";
    }
    @GetMapping("/posts")
    public String posts(@RequestParam(name = "id", defaultValue = "0") Long id , Model model)
    {
        model.addAttribute("post", postsService.findPosts(id));
        model.addAttribute("reply", replyService.findAllDesc());
        return "post";
    }
    
}