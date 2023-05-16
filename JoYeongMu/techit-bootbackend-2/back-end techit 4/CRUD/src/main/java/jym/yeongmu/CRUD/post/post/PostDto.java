package post;

public class PostDto {
    private String tilte;
    private String content;
    private String writer;

    public PostDto(String tilte, String content, String writer) {
        this.tilte = tilte;
        this.content = content;
        this.writer = writer;
    }

    public String getTilte() {
        return tilte;
    }

    public void setTilte(String tilte) {
        this.tilte = tilte;
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
}
