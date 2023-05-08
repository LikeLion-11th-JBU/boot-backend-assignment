package dev.SeungIL.jpa;

public class PostDto {
    private int id;
    private  String title;
    private String content;
    private String writer;
    private int boardid;

    public PostDto() {
    }

    public PostDto(int id, String title, String content, String writer, int boardid) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.boardid = boardid;
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

    public int getBoardid() {
        return boardid;
    }

    public void setBoardid(int boardid) {
        this.boardid = boardid;
    }

    @Override
    public String toString() {
        return "PostDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                ", boardid=" + boardid +
                '}';
    }
}
