package com.example.post.service;

import com.example.post.dto.Page;
import com.example.post.dto.Post;

import java.util.List;

public interface PostService {
    int insert(Post post);
    Post select(int postNo);
    int update(Post post);
    int delete(int postNo);

    // 문항5 : 페이징 목록 (Page 에 전체 글 수를 채워서 돌려준다)
    List<Post> list(Page page);
}
