package dev.aquashdw.jpa;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(PostController.class)
class PostControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PostService postService;

    @Test
    public void readPost() throws Exception {
        final int id = 10;
        PostDto testDto = new PostDto();
        testDto.setId(id);
        testDto.setTitle("Unit Title");
        testDto.setContent("Unit Content");
        testDto.setWriter("unit");

        given(postService.readPost(id)).willReturn(testDto);
        final ResultActions actions = mockMvc.perform(get("/post/{id}",id))
                .andDo(print());
        actions.andExpectAll(
                status().isOk(),     // Http 요청을 보냈으니까 Http 응답이 올것인데, 그 status 코드가 ok 200인지를 확인하기 위한 조건이다.
                content().contentType(MediaType.APPLICATION_JSON),// content에 대한 것을 요청하는 부분이다. -> content 타입이 무엇인지 확인해달라는 요청
                jsonPath("$.title", is("Unit Title")),  // jsonPath를 사용해서 돌아온 값이 json인지 확인하는 용도, jsonPath는 json을 위한 정규 표현식이다. json 내용물이 어떤식으로 구성이 되어있는지 확인을 하기위한 정규표현식이다. 여기서 $표시는 json문서 자기 자신을 의미하는 것이고, .은 현재위치, title은 key값을 의미한다. 즉, 이 문장은 돌아온 json의 첫 key element인 Title은 Unit Title일 것이다를 의미하고 있다.
                jsonPath("$.content", is("UnitContent")),
                jsonPath("$.writer", is("unit"))
        );
    }

    @Test
    public void readPostAll() throws Exception {
        PostDto post1 = new PostDto();
        post1.setTitle("title 1");
        post1.setContent("test");
        post1.setWriter("test");
        PostDto post2 = new PostDto();
        post1.setTitle("title 2");
        post1.setContent("test2");
        post1.setWriter("test2");

        List<PostDto> readAllPost = Arrays.asList(post1, post2);
        given(postService.readPostAll()).willReturn(readAllPost);

        final ResultActions actions = mockMvc.perform(get("/post"))
                .andDo(print());            // andDo는 결과를 받으면 ()안의 것을 하라는 뜻이다. 이때 perform 역시 readPostAll 옆에 throws Exception을 써준다.

        actions.andExpectAll(
                status().isOk(),
                content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON),
                jsonPath("$", hasSize(readAllPost.size()))  // 전달 받은 json 객체 전체($)가 같은크기를 가지고 있다
                );

    }
}