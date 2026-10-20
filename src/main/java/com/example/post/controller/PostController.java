package com.example.post.controller;

import com.example.post.dto.Page;
import com.example.post.dto.Post;
import com.example.post.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/Post")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    // 목록 (페이징)
    @GetMapping("/list")
    public String list(@RequestParam(defaultValue = "1") int page, Model model) {
        Page pageInfo = new Page();
        pageInfo.setPage(page);
        List<Post> list = postService.list(pageInfo);
        model.addAttribute("list", list);
        model.addAttribute("page", pageInfo);
        return "Post/list";
    }

    // 조회
    @GetMapping("/read")
    public String read(@RequestParam int postNo, Model model) {
        model.addAttribute("post", postService.select(postNo));
        return "Post/read";
    }

    // 등록 화면
    @GetMapping("/insert")
    public String insertForm() {
        return "Post/insert";
    }

    // 등록 처리
    @PostMapping("/insert")
    public String insert(Post post) {
        postService.insert(post);
        return "redirect:/Post/list";
    }

    // 수정 화면
    @GetMapping("/update")
    public String updateForm(@RequestParam int postNo, Model model) {
        model.addAttribute("post", postService.select(postNo));
        return "Post/update";
    }

    // 수정 처리
    @PostMapping("/update")
    public String update(Post post) {
        postService.update(post);
        return "redirect:/Post/read?postNo=" + post.getPostNo();
    }

    // 삭제 처리
    @PostMapping("/delete")
    public String delete(@RequestParam int postNo) {
        postService.delete(postNo);
        return "redirect:/Post/list";
    }
}
