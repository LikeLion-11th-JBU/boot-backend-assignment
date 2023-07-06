package dev.Seungil.noticeboard.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Getter
@Entity
@NoArgsConstructor
public class Board extends TimeEntity {
    @Id
    @GeneratedValue
    private Long Id;

    @Column(length = 10, nullable = false)
    private String writer;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Builder

    public Board(Long id, String writer, String title, String content) {
        Id = id;
        this.writer = writer;
        this.title = title;
        this.content = content;
    }
}
