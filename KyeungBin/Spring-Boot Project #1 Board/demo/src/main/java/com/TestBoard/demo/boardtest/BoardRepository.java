package com.TestBoard.demo.boardtest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
    // Jpa 레포지토리를 상속받는데, 이 클래스에는 기본적으로
    // CRUD 메소드가 포함되어 있다.

}
