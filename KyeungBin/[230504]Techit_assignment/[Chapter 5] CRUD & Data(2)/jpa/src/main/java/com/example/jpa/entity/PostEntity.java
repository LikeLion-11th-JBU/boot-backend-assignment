package com.example.jpa.entity;

import javax.persistence.*;

@Entity
@Table(name = "post")
public class PostEntity extends BaseEntity{
    @Id // primitive key 역할을 해주는 변수라고 지정해줌
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // 테이블을 생성하면서 ( Auto generated, auto implement, unique primary key등 )
    // Id를 생성하는 규칙을 생성하는 설정
    private Long id; // jpa를 사용하면 primitive 타입은 자제하고 class 기반의 object 사용
    private String title;
    private String content;
    private String writer;

    @ManyToOne( // 질문 -> BoardEntity의 primary key를 가리키는 Foreign Key 인가??
            targetEntity = BoardEntity.class,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "board_id")
    private BoardEntity boardEntity;
    // 게시글은 게시판 소속이므로,
    // 게시판은 여러가지 글을 가지고 있을 수 있다.
    // ManyToOne() => 포스트가 여러개이고 보드는 한 개다? 라는 의미다?? (질문 or 검색) 해결? : X
    public PostEntity() {
    }

    public PostEntity(Long id, String title, String content, String writer, BoardEntity boardEntity) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.boardEntity = boardEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public BoardEntity getBoardEntity() {
        return boardEntity;
    }

    public void setBoardEntity(BoardEntity boardEntity) {
        this.boardEntity = boardEntity;
    }

    @Override
    public String toString() {
        return "PostEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                '}';
    }

}
