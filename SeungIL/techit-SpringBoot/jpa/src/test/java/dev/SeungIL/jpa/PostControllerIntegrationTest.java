//package dev.SeungIL.jpa;
//
//import dev.SeungIL.jpa.entity.PostEntity;
//import dev.SeungIL.jpa.repository.PostRepository;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultActions;
//
//import static org.hamcrest.Matchers.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(
//        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
//        classes = JpaApplication.class
//)
//@AutoConfigureMockMvc
//@EnableAutoConfiguration(exclude = SecurityAutoConfiguration.class)
//@AutoConfigureTestDatabase
//public class PostControllerIntegrationTest {
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private PostRepository postRepository;
//
//    @Before // test를 실행하기 전에 실행하는
//    public void setEntities(){
//        createTestPost("first post", "first post","test_writer");
//        createTestPost("second post", "second post", "second_writer");
//    }
//
//    @Test // 함수명 given, when, then 으로 쓰는게 좋다고함
//    void givenValidId_whenReadPost_then200() throws Exception{
//        // given
//        Long id = createTestPost("Read Post", "Create on readPost()","read_test");
//
//        // when
//        final ResultActions actions = mockMvc.perform(get("/post/{id}", id))
//                .andDo(print());
//        // then
//        actions.andExpectAll(
//                status().isOk(),
//                content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON),
//                jsonPath("$.title", is("Read post")),
//                jsonPath("$.content", is("Create on readPost()"))
//        );
//    }
//
//    private Long createTestPost(String title, String content, String writer){
//        PostEntity postEntity = new PostEntity();
//        postEntity.setTitle(title);
//        postEntity.setContent(content);
//        postEntity.setWriter(writer);
//        return postRepository.save(postEntity).getId();
//    }
//}
