package dev.park.mybatis.mybatis.dao;

import dev.park.mybatis.mybatis.dto.PostDto;
import dev.park.mybatis.mybatis.mapper.PostMapper;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PostDao {
    private final SqlSessionFactory sessionFactory;
    public  PostDao(
            @Autowired SqlSessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public int createPost(PostDto dto){
//        SqlSession session = sessionFactory.openSession();
        try (SqlSession session = sessionFactory.openSession()) {
            PostMapper mapper = session.getMapper(PostMapper.class);
            return mapper.createPost(dto);
        }
//        PostMapper mapper = session.getMapper(PostMapper.class);
//        int rowAffected = mapper.createPost(dto);
//        session.close();
//        return rowAffected;
    }
    public PostDto readPost(int id){
        try (SqlSession session = sessionFactory.openSession()) {
            PostMapper mapper = session.getMapper(PostMapper.class);
            return mapper.readPost(id);
        }
    }
    public List<PostDto> readPostAll(){
        try (SqlSession session = sessionFactory.openSession()) {
            PostMapper mapper = session.getMapper(PostMapper.class);
            return mapper.readPostAll();
        }
    }
    public int updatePost(PostDto dto){
        try (SqlSession session = sessionFactory.openSession()) {
            PostMapper mapper = session.getMapper(PostMapper.class);
            return mapper.updatePost(dto);
        }
    }
    public int deletePost(int id){
        try (SqlSession session = sessionFactory.openSession()){
            PostMapper mapper = session.getMapper(PostMapper.class);
            return mapper.deletePost(id);
        }
    }
}
