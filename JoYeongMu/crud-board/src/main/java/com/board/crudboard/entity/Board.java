package com.board.crudboard.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data //getter & setter
@Schema(description = "게시판 관련 VO")
public class Board {

    @Id // 프라이머리 키를 의미 한다.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // mysql 오라클에서는 identity를 활용합니다.
    // (데이터베이스 테이블의 기본 키(primary key) 값을 자동으로 생성하는 방법을 지정하는 데 사용됩니다.)

    @Schema(description = "게시글 프라이머리 키 값 ")
    private Integer id;

    @Schema(description = "게시글 제목")
    private String title;

    @Schema(description = "게시글 내용")
    private String content;

    @Schema(description = "게시글 작성자")
    private String writer;

    @Schema(description = "게시물 작성 시간")
    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Schema(description = "게시글 수정 시간")
    @Column(name = "modified_date")
    private LocalDateTime modifiedDate;

}
