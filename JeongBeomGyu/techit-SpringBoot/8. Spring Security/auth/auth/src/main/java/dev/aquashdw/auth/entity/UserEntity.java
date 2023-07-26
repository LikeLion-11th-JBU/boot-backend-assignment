package dev.aquashdw.auth.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "USER_ENTITY")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;            // 이것은 DB 에서 요구하는 사항이다.

    @Column(unique = true)
    private String userName;

    @Column
    private String password;

    @Column
    private String nickname;        // 서비스에 따라 불리는 닉네임에 대한 것을 Entity 에 추가한다.

    @Column
    private String role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return userName;
    }

    public void setUsername(String username) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
