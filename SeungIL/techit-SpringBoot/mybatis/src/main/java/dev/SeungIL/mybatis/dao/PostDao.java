package dev.SeungIL.mybatis.dao;

import dev.SeungIL.mybatis.dto.PostDto;
import dev.SeungIL.mybatis.mapper.PostMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostDao {
    private final SqlSessionFactory sessionFactory;
    public PostDao(
            @Autowired SqlSessionFactory sessionFactory
    ){
        this.sessionFactory = sessionFactory;
    }

    public int createPost(PostDto dto){
        try (SqlSession session = sessionFactory.openSession()){
            PostMapper mapper = session.getMapper(PostMapper.class);
            return mapper.createPost(dto);
            // 아래와 같음 얘는 좀더 편하고 자동으로 세션 close가 됨.
        }
        //SqlSession session = sessionFactory.openSession(/*여기에 아무것도 안쓰면 true 값이 자동으로 들어감 sql에서*/);
        /*PostMapper mapper = session.getMapper(PostMapper.class);
        int rowAffected = mapper.createPost(dto); // 이 시점에서 DB와 통신 완료
        session.close();
        return rowAffected;*/
    }
    public PostDto readPost(int id){
        try (SqlSession session = sessionFactory.openSession()){
            PostMapper mapper = session.getMapper(PostMapper.class);
            return mapper.readPost(id);
        }
    }
    public List<PostDto> readPostAll(){
        try (SqlSession session = sessionFactory.openSession()){
            PostMapper mapper = session.getMapper(PostMapper.class);
            return mapper.readPostAll();
        }
    }
    public int updatePost(PostDto dto) {
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
