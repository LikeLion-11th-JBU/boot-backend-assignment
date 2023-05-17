package dev.aquashdw.mybatis.dao;

import dev.aquashdw.mybatis.dto.PostDto;
import dev.aquashdw.mybatis.mapper.PostMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Repository
public class PostDao {
    private final SqlSessionFactory sessionFactory;

    public PostDao(
            @Autowired SqlSessionFactory sessionFactory                 // sqlSessionFactory가 필요하므로 @Autowired를 이용하여서 가져온다.
    ) {
        this.sessionFactory = sessionFactory;
    }

    public int createPost(PostDto dto) {         // 이것은 외부에서 Dao를 사용할 때 사용할 함수를 정의하는 것이다.
//        SqlSession session = sessionFactory.openSession();      // 이 함수의 내용물을 채워줄 때 Sqlsession(mybatis에 정의된 인터페이스)이 필요하다. 이 Sqlsession을 변수 session으로 받고, 이것을 sessionFactory에서 openSession을 통해서 열어주면 된다. 즉 SessionFactory안에 정의가된 openSession()이라는 함수이다. 또한 이 함수에 true또는 false 값을 넣을 수 있는데, 아무거도 넣지 않으면 기본적으로 true가 들어간다.  -> 이것은 select를 제외한 table의 데이터에 영향을 주는 것들에 대해서, 실제로 그 행위를 저장을 할 것인지말지에 대한 것을 자동화하는지 아닌지에 대한 부분이다.
//        PostMapper mapper = session.getMapper(PostMapper.class);
//        int rowAffected = mapper.createPost(dto);       // 이 시점에서 DB와 통신이 완료된 것이다.
//        session.close();                    // 한번 통신이 완료되면 세션을 닫는다.
//        return rowAffected;
        // 위 내용을 더 쉽게 쓰는 방법
        try (SqlSession session = sessionFactory.openSession()) {
            PostMapper mapper = session.getMapper(PostMapper.class);
            return mapper.createPost(dto);          // try 중괄호 안에서만 session 변수가 살아있도록 하는 문법 중 하나이다. 이렇게 되면 중괄호 끝에 도달할 때 세션이 자동으로 closed가 된다.
        }
    }

    public PostDto readPost(int id) {
        try (SqlSession session = sessionFactory.openSession()) {
            PostMapper mapper = session.getMapper(PostMapper.class);
            return mapper.readPost(id);
        }
    }

    public List<PostDto> readPostAll() {
        try (SqlSession session = sessionFactory.openSession()) {
            PostMapper mapper = session.getMapper(PostMapper.class);
            return mapper.readPostAll();
        }
    }
    public int updatePost(PostDto dto){
        try(SqlSession session = sessionFactory.openSession()){
            PostMapper mapper = session.getMapper(PostMapper.class);
            return mapper.updatePost(dto);
    }
}
    public int delete(int id){
        try(SqlSession session = sessionFactory.openSession()){
            PostMapper mapper = session.getMapper(PostMapper.class);
            return mapper.deletePost(id);
    }
}
}