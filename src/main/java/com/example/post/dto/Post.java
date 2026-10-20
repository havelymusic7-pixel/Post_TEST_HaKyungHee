package com.example.post.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Post {
    private int postNo;            // 글번호 (PK, auto increment)
    private String title;          // 제목
    private String writer;         // 작성자
    private String content;        // 내용
    private LocalDateTime regDate; // 등록일
    private LocalDateTime updDate; // 수정일
}
