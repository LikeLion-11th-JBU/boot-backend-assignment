package dev.likelion.jpa.entity;

import javax.persistence.*;

@Entity
@Table(name = "post")

public class PostEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private String writer;

//    @ManyToOne(
//            targetEntity = BoardEntity.class,
//            fetch = FetchType.LAZY
//    )
//
//    @JoinColumn(name = "board_id")
//    private static BoardEntity boardEntity;

    public PostEntity() {
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

//    public static BoardEntity getBoardEntity() {
//        return boardEntity;
//    }
//
//    public void setBoardEntity(BoardEntity boardEntity) {
//        this.boardEntity = boardEntity;
//    }
}
