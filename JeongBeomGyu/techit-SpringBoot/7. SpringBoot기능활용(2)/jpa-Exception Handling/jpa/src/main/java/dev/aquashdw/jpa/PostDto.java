package dev.aquashdw.jpa;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class PostDto {
    private int id;
    @NotNull(message = "title not null")
    private String title;
    @Size(max=400, message = "size under 40")
    private String content;
    @Size(min=3, max=10, message = "size between 3 -10")
    private String writer;
    private int boardId;

    public PostDto() {
    }

    public PostDto(int id, String title, String content, String writer, int boardId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.boardId = boardId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getBoardId() {
        return boardId;
    }

    public void setBoardId(int boardId) {
        this.boardId = boardId;
    }

    @Override
    public String toString() {
        return "PostDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                ", boardId=" + boardId +
                '}';
    }
}
