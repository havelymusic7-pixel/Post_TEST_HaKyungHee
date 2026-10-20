package com.example.post.dto;

import lombok.Data;

/** 페이징 처리용 클래스 (문항5) */
@Data
public class Page {
    private int page = 1;        // 현재 페이지
    private int size = 10;       // 한 페이지에 보여줄 글 수
    private int blockSize = 10;  // 하단에 보여줄 페이지 번호 개수
    private int total;           // 전체 글 수
    private int last = 1;        // 마지막 페이지
    private int startPage = 1;   // 하단 번호 시작
    private int endPage = 1;     // 하단 번호 끝

    /** 전체 글 수가 정해지면 나머지 값을 계산한다. */
    public void setTotal(int total) {
        this.total = total;
        this.last = Math.max(1, (int) Math.ceil((double) total / size));
        if (page < 1) page = 1;
        if (page > last) page = last;
        this.startPage = ((page - 1) / blockSize) * blockSize + 1;
        this.endPage = Math.min(startPage + blockSize - 1, last);
    }

    /** LIMIT size OFFSET offset 의 offset */
    public int getOffset() {
        return (page - 1) * size;
    }
}
