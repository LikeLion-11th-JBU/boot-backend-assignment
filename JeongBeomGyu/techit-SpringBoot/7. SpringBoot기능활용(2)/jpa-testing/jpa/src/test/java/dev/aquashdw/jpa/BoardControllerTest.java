package dev.aquashdw.jpa;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.io.IOException;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(BoardControllerTest.class)
public class BoardControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void createdBoard() throws Exception {
        // given
        BoardDto boardDto = new BoardDto();
        // Board의 요구 조건에 대해서 생각을 해보자
        boardDto.setName("notice");     //BoardDto는 이름을 정의할 수 있다.   -> BoardDto 에 setName이 없으므로 생성 -> 이때 파라미터에 notice를 name으로 바꿔준다.

        //when
        final ResultActions actions = mockMvc.perform(post("/board")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(toJson(boardDto)))
                .andDo(print());

        //then
        actions.andExpectAll(
                status().is2xxSuccessful(),
                content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON),
                jsonPath("$.name", is("notice"))
        );


    }
    private byte[] toJson(Object object) throws IOException{
        ObjectMapper mapper = new ObjectMapper();            // Spring Boot에서 사용하는 jackson이라는 라이브러리에서 json을 만들 수 있는 기능들을 주고 있다.
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return mapper.writeValueAsBytes(object);
    }
}
