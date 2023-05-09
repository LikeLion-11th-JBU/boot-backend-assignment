#Spring boot basics(2)
1. 컴퓨터 통신과 HTTP

* OSI(컴퓨터 통신 모델)
```
`응용계층` -> HTTP, SMTP, FTP 주고 받을 데이터를 어떤 규칙을 가지고 작성하느냐
`표현계층`
`세션계층`
`전송계층` - 인터넷이 어떻게 되어있는지
`네트워크 계층`- 인터넷이 어떻게 되어있는지
`데이터 링크 계층` - 집안에서 일어나는 
`물리 계층` - 집안에서 일어나는 
```
TCP/IP(컴퓨터  통신 모델)
```
`응용계층`
`전송계층`
`인터넷 계층`
`네트워크 접근 계층`
```

* HTTP : 일반적인 웹 애플리케이션에서 쓰임
* SMTP : 메일
* FTP : 파일

* 대부분의 웹애플리케이션을 만드는데 사용하는 건 HTTP(Hyper Text Transfer Protocol, 정보를 담고있는 문자(Hyper Text))
* 응용 계층에 정의된 통신 규약
* 서버와 클라이언트 간에 메세지를 전달하는 형식을 정의한 규약

* HTTP = REST ??? => no! 서로 다르다
* REST는 (REpresentational State Transfer) 상태에 대한 표현을 전송 몇가지 좋은 API를 만들기 위한 규칙들이 정의 되어있는 
* REST에 관련되어서 어디에도 HTTP를 사용한다는 말이 들어가있진 않다.
* HTTP를 활용한 API를 REST라 부르는 경우가 있음. 정확하게 말하자면 맞는말이 아니다.
* 백엔드 서버를 만들때 남용되는 말

* <응답 형식>
* Request Line : Method, Path, Version 이 들어감(Get, Post, Patch /Path Version 형식)
* Request Headers : HTTP 요청에 대한 부수적인 데이터
* Status Line : 요청 처리에 대한 상태 표시줄
* Response Headers : HTTP 응답에 대한 부수적인 데이터
* Response Body : 응답 데이터

* URL : Uniform Resource Location : internet 상에 자원의 위치를 나타내는 문자열
* 구성 : scheme : // userinfo @ host : port path ? query # fragment
* `Scheme` : 규약 HTTP가 들어감
* `://` 필수적
* `userinfo@` : 선택
* `host` : 어떤 곳으로 보낼지 (도메인 ip)
* `:port` : 선택사항, 스킴에 따라 기본 값을 가짐(http - 80)어떠한 컴퓨터에서 어떤 숫자를 보낼지 결정하는 것
// path 전까진 인터넷 상의 컴퓨터를 나타내는 부분
// 그 이후에는 컴퓨터 안의 위치(경로), 무엇을 요청을 했냐
* path : 경로
* query : 조회를 할때 필요한 부수적인 정보를 제공할 때 필요함
* fragment : 하나의 문서에 어떤 구분을 나타내는 것
* query와 fragment는 스프링부트에선 사용 안할것

* Media Type - 인터넷 상에서 주고 받는 데이터의 형식
* 이미지, 비디오, 자바스크립트 등

* JSON(JavaScript Object Notation) : 데이터를 주고 받을 때 흔히 사용하는 형태
* 속성(Attribute) - 값(Value) 의 형태와 배열(Array)을 활용한다.
* 값에 들어갈 수 있는 것은 문자열 , 숫자, 배열, JSON, boolean임 파이썬의 딕셔너리와 유사함.
* 일반적인 데이터를 표현한 객체(VO)는 JSON 형태로 주고받는다.

------
2. Controller와 RestController

* MVC(Model-View-Controleer // 구조적으로 정확히 나눠져있다기 보단 이러한 역할로 나눠서 구분해 놨다는 것을 표현하기 위한 아키텍처, 설계 패턴의 일종)
* View : 사용자가 확인하는 데이터의 표현, 브라우저로 따지면 모니터에 표시된 Html문서는 완벽하게 모습을 갖춘 채로 확인 할 수 있음
* Controller : 사용자의 입출력을 다루는 부분, 키보드 등으로 의사표시를 함, 어떠한 어플리케이션에도 적용할 수 있음
* Model : 서비스 데이터 자체
* 사용자가 view에서 작동하는걸 봄 -> 컨트롤러를 사용해서 사용자가 액션을 보냄 -> 컨트롤러는 모델 서비스 데이터를 조작 (상태, 데이터 추가, 로그인 등등) -> model은 지시받은 내용을 갖고 view를 갱신 -> view는 사용자에게 새로운 모습을 보여줌
* 코드들을 어떠한 형태로 구성할 것인지 생각하는 것.

* spring boot 에서 MVC
* Dispatcher Servlet : Front Controller Pattern , 구성을 하는 모델, 컨트롤러, 뷰를 직접적으로 관리하고 사용자와 직접적으로 대화하는 것.
* 1. 외부 요청 발생 ->2. 요청 경로 확인을 위해 전달 ->3. Controller로 전달 ->4. Model 조작 ->5. 갱신된 데이터 전달 ->6. 응답전달 -> 7. 응답을 Client로 전송 -> 7.1 데이터 전송 또는 -> 7.2 데이터를 포함한 View 제작 -> 8. 사용자에게 View 제공  

* 요청 경로를 설정하기 위해 `Controller Annotaion`을 사용하자
* `RequestMappng Annotation`을 이용해 경로에 따라 실행 될 함수를 지정할 수 있다.
* `GetMapping`, `PostMapping` 등의 Method 별 별도의 Annotation이 존재한다.
* HTML 외에 데이터 전송을 위해 Body와 MediaType을 설정할 수 있다.
* `RestController Annotation`은 간단하게, `Controller + ResponseBody Annotation`임.
* 기본적으로 어떤 형태의 응답이든 데이터의 일종이다 `public byte[] ~~~~`
-----
// 이 강의 코드 에러남 이유가 뭔지 모르겠음;;

3. HTML Template
* www.example.com에 가면 볼 수 있는 도메인 => 사용자 상황에 따른 내용 변화가 없다.
* 반대로 시각과 사용자의 상황에 따라 내용이 달라지는 페이지가 있다.
* static contents : 이미 작성이 완료되어 변하지 않는 파일들, HTML, CSS, Image 등
* Dynamic Web Page : 서버에서 HTML 문서의 내용을 데이터에 따라 다르게 작성하여 제공되는 페이지
* JSP, ThymeLeaf : JSP는 spring 표준에서 벗어나려고 하고있음, 그래서 현재는 기본으로 ThymeLeaf를 가져가는 추세임

* Framwork 선택의 기준
* React(JavaScript library)
* Vue.js
* 이 둘은 UI를 만들기 위한 라이브러리 / 프레임 워크- HTML을 효율적으로 작성하기 위한 기술 -> 프론트엔드
* Node.js : 자바스크립트를 브라우저 외부에서 사용하기 위한 기술 - 일반적으로 웹 어플리케이션을 만드는데 활용.
* node도 백엔드라고 할 수 있음.
-----
4. PostmanAPI (testing tool, http client application)

* 백엔드 개발자들이 API를 만들고 테스트하기 위해 사용하는 도구들 중 하나
* postman은 폴더를 만드는거 http 요청은 문서와 같다 그 문서를 모아놓는 곳을 만드는

-----
5. 예제 문제
* 추상클래스는 여러개의 하나의 인터페이스를 구현하는데 있어서 이 구현체들이 동일하게 가져가야하는 영역들에 대한 이야기를 하게 됨
* 즉 사람이라면 누구나 이름을 가질 수 있다.~~~ 이런거

* ArrayList a;
* LinkedList b;
* Vector c;
* HashSet d;
* 이 4개 클래스 모두 Collection인터페이스를 상속 받음. -> 공통점

* Set은 순서를 고려하지 않음.


