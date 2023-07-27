package dev.likelion.mybatis.dao;

import dev.likelion.mybatis.dto.BoardDto;
import dev.likelion.mybatis.mapper.BoardMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class BoardDao {
    private final SqlSessionFactory sessionFactory;

    public BoardDao(@Autowired SqlSessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public int createBoard(BoardDto dto){
        try (SqlSession session = sessionFactory.openSession()){
            BoardMapper mapper = session.getMapper(BoardMapper.class);
            return mapper.createBoard(dto);
        }
    }
}
