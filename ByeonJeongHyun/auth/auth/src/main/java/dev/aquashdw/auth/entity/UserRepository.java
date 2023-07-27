package dev.aquashdw.auth.entity;

import javax.persistence.*;

@Entity
@Table(name = "USER_ENTITY")
public class UserRepository {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    @Column
    private String password;

    @Column
    private String nickname;

    @Column
    private String role;

}
