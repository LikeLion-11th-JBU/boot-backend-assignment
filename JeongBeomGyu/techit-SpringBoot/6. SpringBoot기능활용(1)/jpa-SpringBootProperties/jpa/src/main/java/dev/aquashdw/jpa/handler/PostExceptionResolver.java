package dev.aquashdw.jpa.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.aquashdw.jpa.exception.BaseException;
import dev.aquashdw.jpa.exception.ErrorResponseDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;

import java.io.IOException;

@Component
public class PostExceptionResolver extends AbstractHandlerExceptionResolver {
    @Override
    protected ModelAndView doResolveException(HttpServletRequest request,
                                              HttpServletResponse response,
                                              Object handler,
                                              Exception ex) {
        logger.debug(ex.getClass());    // debug로 Exception의 getClass를 찍어보려고 하고 있다.
        if (ex instanceof BaseException){
            response.setStatus(HttpStatus.BAD_REQUEST.value());// 지금 ServletResponse를 받아온 상태이기 때문에 ServletResponse를 조작을 해줘야한다.
            try {// 또한 반환값으로 ModelAndView 를 돌려주고 있고, 이말은 lander을 할 view를 돌려줬으면 한다라는 뜻이고, API서버에서 view를 돌려주지는 않기 때문에, 그것을 구현하는데 try를 사용한다.
                response.getOutputStream().print(
                        new ObjectMapper().writeValueAsString(
                                new ErrorResponseDto("in resolver, message: " + ex.getMessage())
                        )  // 이 안에다가 글(json 형식의 String)을 실제로 작성을 해줘야한다. ObjectMapper같은 경우 Spring 내부적으로 dataserial라이즈, 즉 모델을 json으로 바꾸는 과정을 도와주기 위한라이브러리중 하나이다.
                );
                response.setHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE);// 여기까지가 이 Object까지 작성을 한 것이다. 그리고 이 Object가 어떤 형식으로 작성이 된 것인지를 알려줘야한다.
                return new ModelAndView(); // content-type의 header를 추가하고, new ModelAndView를 돌려준다.
            }catch (IOException e){
                logger.warn("Handling exception caused exception: {}", e);
            }
        }
        return null;
    }
}
