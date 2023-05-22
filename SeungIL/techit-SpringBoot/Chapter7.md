#Spring Boot 기능활용
-----
# Exception - 예외
* 특수한 처리를 필요로 하는 비상적 또는 예외적 상황.
* try 예외가 일어날 수 있는 구역
* catch 예외가 발생할 시 실행
* finally 예외의 발생과 무관하게 실행하는 코드

* 예외처리를 호출하는 대상에게 전가
* java에서는 method signature의 일부로, 처리되지 않은 예외는 complie Error를 발생시킨다.
* 단 RuntimeException은 제외.
* NullPointerException 또한 RuntimeException에 속함.

* 1. ResponseStatusException - 단발적 예외
* 2. @ExceptionHandler - Controller 내부 예외
* 3. HandlerExceptionResolver -어플리케이션 전체의 예외처리 Handler
* 4. @ControllerAdvice - ExceptionHandler 모음.
-----
# Filter & Interceptor
저희가 Spring Boot에서 코드를 통해 구현하는 부분은 전체 HTTP 서버를 구성하는 부분중에 일부분입니다. 일전에 언급하였듯, Spring 프레임워크는 Java Web Server Application에서 구동할 수 있는 WAR을 만들어서 실제 서버의 실행 및 요청 전달은 Apache Tomcat 등에 위임 하였습니다. 여기에 Tomcat을 프레임워크 내부에 임베드 함으로서 명령어로 Web Application을 바로 실행할 수 있도록 만든게 Spring Boot입니다. 이중에서 저희가 직접 구현하는 부분은 Controller 부터 입니다. 

한편 일반적인 웹 서비스를 구성하면, 보안, 인증 같은 부분은, 대다수의 Controller에서 활용하게 됩니다. 이런것은 Controller에 들어가기 이전에 구현되는 것이 좋습니다.

여태까지 배운 것을 기준으로는, 다양한 함수등에 앞서서 동일한 기능을 구현하기 위해서는 AOP를 통해 Pointcut과 Advice를 잘 구성하는 방법 뿐입니다. 반면 이런 기능들 자체는 대부분의 Web Application에 구성될 수 있는것이 좋습니다. 그래서 Spring에서는 HandlerMapping과 Controller 사이에의 기능 구현을 위한 Interceptor와, 사용자와 DispatcherServlet 사이에의 기능 구현을 위한 Filter 라는 것을 구성할 수 있습니다.

## Interceptor와 Filter의 차이

우선 Interceptor는, 정확히는 HandlerInterceptor라고 하는 부분은 Spring Framework 내부에서 구현하는 기능입니다. 반면 Filter는 Jakarta Servlet API의 일부로 정의되어 있습니다. 다른말로 Interceptor는 Spring Framework의 일부이고, Filter는 그렇지 않다고 보시면 됩니다. 그래서 Filter는 Spring Application에 도달하기 전에 하는 작업에 적합하고, Interceptor는 Spring Application에 필요한 작업에 적합합니다.

### Filter에서 구현하기 좋은 기능

Filter는 Spring Application에 도달하기 전에 처리됩니다. 그래서 일반적인 Buisness Logic에서 벗어난 기능들을 구현하는데 사용합니다. Filter 인터페이스를 이용해 구현하게 되는데, 이 인터페이스의 `doFilter()` 함수를 구현하고 Spring Bean으로 등록하게 되면 자동으로 적용되게 됩니다. `doFilter()` 함수는 인자로 `ServletRequest`, `ServletResponse`, `FilterChain` 을 받게되는데, `ServletRequest` 와 `ServletResponse` 를, 다른말로 요청과 응답을 조작하여 전달 할 수 있습니다. 이는 `HttpServletRequest` 와 `HttpServletResponse` 를 조작할 수 없는 Interceptor에서는 구현할 수 없는 부분입니다.

Interceptor와 비교했을때 기능적으로는 더 범위가 넓지만, 그만큼 세밀한 기능을 제공하기는 어렵습니다.

- 보안 관련 작업 (CSRF, XSS 등)
- 요청, 응답에 대한 기록 (`ServletRequest`, `ServletResponse` 등을 조작할 수 있다)
- 문자열 인코딩

참고로 다음 주제인 Spring Security에서 제공하는 기능도 이 Filter를 제공하는 라이브러리입니다.

### Interceptor에서 구현하기 좋은 기능

HandlerInterceptor는 Spring Framework의 일부이며, 일반적인 Service Logic 자체에 필요한 기능을 구현하는데 사용합니다. `HandlerInterceptor` ****인터페이스를 이용해 `preHandle()`, `postHandle()`, `afterCompletion()` 함수를 구현하게 됩니다. Spring 내부에서 처리되기 때문에 Model에 접근하기 용이하기에, Filter에서 구현하기 복잡한 인증 (Authorization & Authentication) 기능과 같은 세밀한 작업을 구현하는데 주로 사용됩니다. 다만 위에서 언급한데로, `HandlerInterceptor` 의 `HttpServletRequest` 와 `HttpServletResponse` 는 조작하기 힘듭니다.

- 인증 관련 작업 (사용자 검증, 세션 관리)
- API 처리와 관련된 기록

## Filter 구현하기

먼저 Filter를 구현해 봅시다. Filter를 이용해서 서버에 오간 요청과 응답의 내용을 로그로 남기는 기능입니다.

```java
@Component
public class TransactionLogFilter implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(TransactionLogFilter.class);

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String requestUUID = UUID.randomUUID().toString().split("-")[0];
        logger.info("[{}] start request: {} {}",
                requestUUID,
                httpServletRequest.getMethod(),
                httpServletRequest.getRequestURI()
        );

        chain.doFilter(request, response);

        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        logger.info("[{}], send response: {}",
                requestUUID,
                httpServletResponse.getStatus()
        );
    }
}
```

`javax.servlet.Filter` 인터페이스의 `doFilter()` 함수를 구현하는 모습입니다. 기본적으로 `chain.doFilter()` 가 호출이된 줄 이전에는 요청이 Spring Application에 도달하기 전의 작업을, 이후에는 도달한 후의 작업을 구현하면됩니다.

여기서 짚고 넘어갈 부분은, `doFilter()` 의 인자들의 타입이 `ServletRequest`, `ServletResponse` 인 점인데, 이는 `HttpServletRequest` 와 `HttpServletResponse` 보다 상위의 인터페이스 입니다. 이는 Filter를 통해서 주고받는 것이 반드시 동일한 인터페이스가 아니라, 특정한 목적을 위해 Customizing된 `ServletRequest` 등을 사용할 수 있다는 점입니다.

세번제 인자인 `chain` 같은 경우 Filter가 등록된 FilterChain, 즉 실행할 Filter들이 연결된 객체입니다. `chain.doFilter()` 함수를 호출하게 되면, 구성된 나머지 Filter들이 실행되고, `response` 객체에 응답 `ServletResponse`가 등록됩니다. 그래서 `chain.doFilter` 호출 전후의 `((HttpServletResponse) response).getStatus()` 의 값을 확인해보면 서로 다른것을 확인할 수 있습니다.

## Interceptor 구현하기

이번엔 Spring Interceptor를 구현해 봅시다.

```java
@Component
public class RequestLogInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(RequestLogInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String headerName = headerNames.nextElement();
            logger.info("{}: {}", headerName, request.getHeader(headerName));
        }
        return true;
    }

		@Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
```

Spring의 `HandlerInterceptor` 인터페이스의 경우 3가지 함수를 구현할 수 있습니다. 이름에서 쉽게 알 수 있듯이, 요청과 응답이 Spring Application 기준으로 어느 시점에 실행되느냐를 기준으로 함수를 작성하게 됩니다.

- `preHandle()` : HandlerMapping에서 Controller로 요청이 넘어가기 전 실행
- `postHandler()` : Controller에서 DispatcherServlet으로 응답이 넘어가기 전 실행
- `afterCompletion()` : DispatcherServlet이 응답을 클라이언트한테 보내고 나서 실행

`HandlerInterceptor` 의 경우, Spring Bean으로 등록한다고 바로 적용되지는 않습니다. `Configuration` 을 사용해서 `HandlerInterceptor` 를 적용하는 조건에 대하여 상세히 설정할 수 있습니다.

```
java
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    private final RequestLogInterceptor requestLogInterceptor;

    public InterceptorConfig(
            @Autowired RequestLogInterceptor requestLogInterceptor
    ) {
        this.requestLogInterceptor = requestLogInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(requestLogInterceptor)
								.addPathPatterns("/post/**")
                .excludePathPatterns("/temp/**");
    }
}
```

설정을 위해 `@Configuration` Bean을 만들어 등록하고, `WebMvcConfigurer` 를 구현하도록 작성합시다. 이렇게 하면 Spring Boot가 실행되면서 이 Bean의 내용을 가지고 Interceptor 구성을 하게 됩니다.

* 왜 필터가 있는데 인터셉터를 만들었냐

* 커플링 때문 필터만 갖고 뭔갈 하려다보니 스프링 애플리케이션이 필터를 조작하는데 있어 기대하는게 많아 졌기 때문으로 예상이됨

※ 스프링 밖에서 할 수 있는 일, 안에서 할 수 있는 일/ 반대로 못하는일을 생각 해봐야한다고 함.

-----
# Spring Boot Tests


