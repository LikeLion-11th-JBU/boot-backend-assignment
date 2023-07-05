package com.example.jpa.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "board")
public class BoardEntity extends BaseEntity{
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "board_name")
    private String name;

    @OneToMany(
            targetEntity = PostEntity.class,
            fetch = FetchType.LAZY,
            mappedBy = "boardEntity"
            // BoardEntity의 OneToMany와 PostEntity의 ManyToOne이
            // 서로 다른 관계임을 알 수 있기 때문?
            // hibernate는 boardentity에 있던 타깃이 arraylist(postentity)에 들어가있음 알 수 있다?
            // (검색 or 질문)
    )
    private List<PostEntity> postEntityList = new ArrayList<>();

    public BoardEntity() {
    }

    public BoardEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BoardEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
