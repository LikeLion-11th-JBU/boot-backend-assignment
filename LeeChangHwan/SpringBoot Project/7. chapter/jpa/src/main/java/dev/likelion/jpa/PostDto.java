package dev.likelion.jpa;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class PostDto {
    private int id;
//    @NotNull(message = "title not null")
    @NotBlank
    private String title;
    @NotBlank
    @Size(max = 40, message = "size under 40")
    private String content;
    @Size(min = 3, max = 10, message = "size between 3 - 10")
    private String writer;
    private int boardID;

    public PostDto(int intExact, String title, String content, String writer) {
    }

    public PostDto(int id, String title, String content, String writer, int boardID) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.boardID = boardID;
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

    public int getBoardID() {
        return boardID;
    }

    public void setBoardID(int boardID) {
        this.boardID = boardID;
    }

    @Override
    public String toString() {
        return "PostDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                ", boardID=" + boardID +
                '}';
    }
}

