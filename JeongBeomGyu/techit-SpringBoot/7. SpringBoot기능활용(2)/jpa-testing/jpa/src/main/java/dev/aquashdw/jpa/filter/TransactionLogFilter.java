package dev.aquashdw.jpa.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;
@Component
public class TransactionLogFilter implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(TransactionLogFilter.class);
    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        String requestUUID = UUID.randomUUID().toString().split("-")[0];
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        logger.debug("[{}] start request: {} {} ",
                requestUUID,
                httpServletRequest.getMethod(),
                httpServletRequest.getRequestURI()// 첫번째로 사용할 인자에 requestUUID를 넣는다. 두 번째 인자로는 일반적은 Http 요청을 작성하는 순서와 비슷하게 로그를 쓸 것이다.
                );
        logger.info(" * response status code: {}", ((HttpServletResponse) response).getStatus());
        chain.doFilter(request,response);
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        logger.info(" * response status code: {}", ((HttpServletResponse) response).getStatus());
        logger.debug("[{}], send response: {}",
                requestUUID, httpServletResponse.getStatus());
    }
}
