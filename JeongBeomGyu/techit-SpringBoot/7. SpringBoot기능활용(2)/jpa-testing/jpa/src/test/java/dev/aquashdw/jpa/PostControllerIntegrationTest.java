package dev.aquashdw.jpa;

import dev.aquashdw.jpa.entity.PostEntity;
import dev.aquashdw.jpa.repository.PostRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;



import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,     // integration 을 진행할 때 실제환경이 어디일 것이라고 가정을 하느냐에 대한 내용이다.
        classes = JpaApplication.class              // classes 는 사용하는 application 일 것이다.
)
@AutoConfigureMockMvc
@EnableAutoConfiguration(exclude = SecurityAutoConfiguration.class)
@AutoConfigureTestDatabase
public class PostControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PostRepository postRepository;          // integrate test 를 할 것이기 때문에 모든 Bean 들이 들어와 있는 상태이다.

    @Before                 // test를 진행하기 전에 실행이 되는 함수이다. 즉 test가 실행되기 전에 몇개의 Entity를 넣어주기 위한 선언이다.
    public void setEntities(){
        createTestPost("first post", "first post content", "test_writer");
        createTestPost("second post", "second post content", "test_writer");
    }

    @Test
    void givenValidId_whenReadPost_then200() throws Exception{        // read를 위해서 Id를 줄 예정이다_ReadPost 함수를 위한 언드포인트를 의미한다._기대하는것 200
        // given
        Long id = createTestPost("Read Post", "Created on readPost()", "read_test");

        // when
        final ResultActions actions = mockMvc.perform(get("/post/{id}", id))
                .andDo(print());

        //then
        actions.andExpectAll(
                status().isOk(),
                content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON),
                jsonPath("$.title", is("Read Post")),
                jsonPath("$.content", is("Created on readPost()"))
        );
    }
    // integrate test 를 하면서 임의의 entity를 많이 만들어둘 필요가 있기 때문에 밖에 함수를 빼서 만든다.
    // long을 반환값으로 해 놓은 이유는 read나 update, delete 같은 요청을 할 때 id가 없으면 어떤 것을 조작을 할지를 전달할 수 없기 때문에 Long을 반환값으로 놓았다.
    private Long createTestPost(String title, String content, String writer){
        PostEntity postEntity = new PostEntity();
        postEntity.setTitle(title);
        postEntity.setContent(content);
        postEntity.setWriter(writer);
        return postRepository.save(postEntity).getId();
    }
}
