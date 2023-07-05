# Chapter 3

Spring Boot Basic 2

컴퓨터 통신과 HTTP

![Untitled](Chapter%203%20e61f7e9a2d124e64872fff2e379c0d5b/Untitled.png)

OSI 7계층에서 응용계층을 잘 사용하게 도와주는 Spring boot

![Untitled](Chapter%203%20e61f7e9a2d124e64872fff2e379c0d5b/Untitled%201.png)

![Untitled](Chapter%203%20e61f7e9a2d124e64872fff2e379c0d5b/Untitled%202.png)

하이퍼텍스트 통신 규약으로써 정보를 전달함이 중요한 내용

서버와 클라이언트 간에 메시지를 전달하는 것을 정의한 규약

![Untitled](Chapter%203%20e61f7e9a2d124e64872fff2e379c0d5b/Untitled%203.png)

REST와 HTTP는 다르다

HTTP를 활용한 API를 REST API라고 말하는 경우가 많지만 엄연히 다른것

Back-End 작업을 할때 굉장히 많이 남용되는 말이다 ⇒ 조금 잘못된것

![Untitled](Chapter%203%20e61f7e9a2d124e64872fff2e379c0d5b/Untitled%204.png)

각각의 요소가 무엇을 의미하는지 알아둘것

Back-End 개발을 할때 실제로 요청과 응답을 작업하기 때문에 알아두자

과거 Burpsuite를 이용해 공부했을 때 저것 말고도 많은 내용들이 있었기에 자세히 알아보자

![Untitled](Chapter%203%20e61f7e9a2d124e64872fff2e379c0d5b/Untitled%205.png)

![Untitled](Chapter%203%20e61f7e9a2d124e64872fff2e379c0d5b/Untitled%206.png)

---

| 인터넷 상의 컴퓨터를 나타내는 부분 | 컴퓨터 안의 위치(경로) |
| --- | --- |
| scheme - 어떤 규약을 사용하는지 (HTTP, HTTPS) | path - 요청을 보내기 위한 주소 |
| userinfo - 어떤 유저가 사용하는지 | query - 조회를 하기 위해 필요한 부분 |
| host - ip, domain 등 어디로 보낼건지 | fragment - 하나의 문서의 어떠한 부분 |
| port - 포트 |  |

컴퓨터에 어떠한 요청을 보내느냐가 아니라 무엇을 요청했느냐가 알아야 하는 부분

Spring boot를 실습할때 컴퓨터 안의 위치(경로)를 신경쓸부분

앞 부분은 크게 신경쓸필요 X

![Untitled](Chapter%203%20e61f7e9a2d124e64872fff2e379c0d5b/Untitled%207.png)

실제로 크롬 네트워크 탭에서 content-type을 통해 확인가능

![Untitled](Chapter%203%20e61f7e9a2d124e64872fff2e379c0d5b/Untitled%208.png)

![Untitled](Chapter%203%20e61f7e9a2d124e64872fff2e379c0d5b/Untitled%209.png)

지금은 JSON만 알아도 된다

![Untitled](Chapter%203%20e61f7e9a2d124e64872fff2e379c0d5b/Untitled%2010.png)

JSON의 정보

![Untitled](Chapter%203%20e61f7e9a2d124e64872fff2e379c0d5b/Untitled%2011.png)

왼쪽은 Java 객체를 선언한건데 이것들은 우측의 JSON처럼 작성이 된다

key와 value값으로 값이 정해진다 ⇒ 파이썬의 딕셔너리와 매우 유사함

Controller와 RestController

Spring MVC

Controller와 RequestMapping

Controller와 RestController

![Untitled](Chapter%203%20e61f7e9a2d124e64872fff2e379c0d5b/Untitled%2012.png)

MVC - Model View Controller, 패턴의 한 종류

코드를 이용해 각각의 역할을 “구현”한다

![Untitled](Chapter%203%20e61f7e9a2d124e64872fff2e379c0d5b/Untitled%2013.png)

주황색 네모가 우리가 실제로 Spring boot를 하면서 해볼것

![Untitled](Chapter%203%20e61f7e9a2d124e64872fff2e379c0d5b/Untitled%2014.png)

![Untitled](Chapter%203%20e61f7e9a2d124e64872fff2e379c0d5b/Untitled%2015.png)

![Untitled](Chapter%203%20e61f7e9a2d124e64872fff2e379c0d5b/Untitled%2016.png)

@RespnseBody가 붙으면 앞쪽 Front Controller Pattern 프로세스에서 View Resolver를 거치지 않고 바로 데이터를 클라이언트에게 돌려준다

![Untitled](Chapter%203%20e61f7e9a2d124e64872fff2e379c0d5b/Untitled%2017.png)

@RestController - 어떤 경로에 이 함수를 붙일지 정한다고 생각하면 된다

![Untitled](Chapter%203%20e61f7e9a2d124e64872fff2e379c0d5b/Untitled%2018.png)

Spring boot는 이미지나 영상이든 뭐든 어떤 형태로든 body를 채워서 전달할 수 있다.

직접적으로 작성하면 알아들을 수 있게 전달가능함 - ?무슨말이지

HTML Template

동적 HTML

JSP와 Thymeleaf

React, Vue, Node와 Spring Boot

Example Domain

www.example.domain ⇒ 예시로 자주 사용되는 HTML 페이지

이 HTML 문서는 달라지는게 없다

![Untitled](Chapter%203%20e61f7e9a2d124e64872fff2e379c0d5b/Untitled%2019.png)

Static(정적) Contents : 이미 작성이 완료되어 변하지 않는 파일들, HTML, CSS, JS, Image 등

- 변하지 않는 자료(Contents)들

![Untitled](Chapter%203%20e61f7e9a2d124e64872fff2e379c0d5b/Untitled%2020.png)

Dynamic(동적) Web Page : 서버에서 HTML 문서의 내용을 데이터에 따라 다르게 작성하여 제공되는 페이지

JSP랑 Thymeleaf랑 같이 쓰기 껄끄럽다?

JSP에서 원하는 포맷이 있다

![Untitled](Chapter%203%20e61f7e9a2d124e64872fff2e379c0d5b/Untitled%2021.png)

![Untitled](Chapter%203%20e61f7e9a2d124e64872fff2e379c0d5b/Untitled%2022.png)

프레임워크를 선정하는 것 또한 중요하다

대표적으로 React, Vue, Node

Thymeleaf 권장

![Untitled](Chapter%203%20e61f7e9a2d124e64872fff2e379c0d5b/Untitled%2023.png)

이런 의미로 인해 Node.js는 백엔드 프레임워크라고 말하는 경우가 많다 ⇒ 맞는말

![Untitled](Chapter%203%20e61f7e9a2d124e64872fff2e379c0d5b/Untitled%2024.png)

무엇을 배울지 어떻게 공부할지 로드맵을 잡고 공부하는게 좋다

Postman

API 테스트 Tool

HTTP 테스트 웹 도구

![Untitled](Chapter%203%20e61f7e9a2d124e64872fff2e379c0d5b/Untitled%2025.png)

보낸 요청 확인 (GET)

![Untitled](Chapter%203%20e61f7e9a2d124e64872fff2e379c0d5b/Untitled%2026.png)

요청 보내기 (POST)

405 확인, 보내지지않음

![Untitled](Chapter%203%20e61f7e9a2d124e64872fff2e379c0d5b/Untitled%2027.png)

![Untitled](Chapter%203%20e61f7e9a2d124e64872fff2e379c0d5b/Untitled%2028.png)

코드 수정 후 요청을 보내면 로그에 뜬다!!

@PostMapping, @ResponseStatus