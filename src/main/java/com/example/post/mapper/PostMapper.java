package com.example.post.mapper;

import com.example.post.dto.Post;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PostMapper {
    int insert(Post post);                 // 등록
    Post select(int postNo);               // 조회
    int update(Post post);                 // 수정
    int delete(int postNo);                // 삭제

    // 문항5 : 페이징
    List<Post> list(@Param("offset") int offset, @Param("size") int size);
    int count();
}
