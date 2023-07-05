package jym.yeongmu.jpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@WebMvcTest(PostController.class)
public class PostControllerTest {
    @Autowired
    private PostService postService;

    @Test
    public void readPost() {
        //give 어떤 데이터가 준비가 되어있다.
        //PostEntity 가 존재 할 때

        //when 어떤 행위가 일어났을 때 (함수 호출 등)
        // 경로에 GET요청이 오면

        //then 어떤 결과가 올 것 인지
        //PostDto 가 반환된다.
    }

    @Test
    public void readPostAll() {
    }
}