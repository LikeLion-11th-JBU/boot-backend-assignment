package dev.aquashdw.crud.post;

public class PostDto {      // 데이터를 주고받는데 사용되는 객체 -> 게시판의 게시글을 만들기 위한 4가지 CRUD를 작업하기 위한 클래스
    private String title;
    private String content;
    private String writer;  // 나중에 이 작성자를 유저정보와 연동을 해서 닉네임을 넣는다. 유저 정보가 들어간다.

    public PostDto() {
    }

    public PostDto(String title, String content, String writer) {
        this.title = title;
        this.content = content;
        this.writer = writer;
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

    @Override
    public String toString() {
        return "PostDto{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                '}';
    }
}
