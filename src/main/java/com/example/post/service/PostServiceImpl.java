package com.example.post.service;

import com.example.post.dto.Page;
import com.example.post.dto.Post;
import com.example.post.mapper.PostMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private final PostMapper postMapper;

    public PostServiceImpl(PostMapper postMapper) {
        this.postMapper = postMapper;
    }

    @Override
    public int insert(Post post) {
        return postMapper.insert(post);
    }

    @Override
    public Post select(int postNo) {
        return postMapper.select(postNo);
    }

    @Override
    public int update(Post post) {
        return postMapper.update(post);
    }

    @Override
    public int delete(int postNo) {
        return postMapper.delete(postNo);
    }

    @Override
    public List<Post> list(Page page) {
        page.setTotal(postMapper.count());
        return postMapper.list(page.getOffset(), page.getSize());
    }
}
