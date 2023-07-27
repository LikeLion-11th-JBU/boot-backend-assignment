#Spring Boot 기능 활용
* Spring Boot Properties
* 개발 환경 : 자신의 컴퓨터
* 자신의 컴퓨터 내부의 소프트웨어(사용하는 도구들)를 사용함

* 서버 컴퓨터
* 컨테이너(docker같은)
* 클라우드 서비스(aws) 요즘은 대부분 클라우드 서비스
* 실제 서비스를 실행하는 데는 여러가지 다양한 환경을 구성할 수 있다.
* 어디에서 어떤 식으로 애플리케이션을 실행하느냐에 따라서 설정을 바꿔야한다.

* 대표적인 변경 사항(application.yml 에서) : url, username, password
* 상용환경 : ddl-auto 설정(create, none, update 등), show-sql 도 변경 할 수 있다.
* mysql을 사용하지 않는다면 거의 다바뀜 

* 2.4.0 이전 : spring.profiles.inculde 사용
* 2.4.0 이후 : spring.config.active.on-profile 사용

* multiDocument yml : 한 yml파일에 여러개 파일을 넣는 방법
* yml 파일에 `---`로 분리
* url: jdbc:mysql://aws-host.ap.north-2.com.rds:3306/demo_jpa_schema 데이터베이스 접근 경로
* 분리도 됨
* 분리할 때 yml파일 이름 만들 때 뭔지 `-`를 써서 표기해줌.

* 상용환경에서만 실행하게 하고 싶을 때 jar파일을 만들어라
* gradle build에 bootjar실행을 돌리면 주황색 build 파일에 스냅샷이 생김
* `java -jar build/libs/jpa-0.0.1-SNAPSHOT.jar` 이런식으로 터미널에 입력하면 됨.

* implementation 'com.google.code.gson:2.8.5'
* gson 이란건 실제로 존재하는 클래스
* @Configuration // 자신의 bean을 제공하고 설정을 담기위해 만들어진 어노테이션 , 자기가 만들지않은 클래스들을 빈으로 제공함으로써 설정에 필요한 클래스들을 객체화 해서 IoC 에 전달하기 위해 존재한다.

```
spring:
    profiles:
        active: test
custom:
    property:
        single: custom-property
        comlist: comma,sparated,list,to,value
        ncp:
            id: api-id
            key: api-key
            url: https://ncp.com/
```
* 스프링 부트와 연관성이 없음, 하지만 상황에 따라 바뀐다는걸 보여주는거임
-----
# Logging
* Logger에는 5개의 함수가 있음. (함수 = 단계)
* 로거는 요청이 들어왔다 예를들어 아이디가 들어와서 deletepost라는 함수에 전달한다. deletepost에서 dao로 전달하면 dao에서 엔티티를 받아와서 삭제를 하거나 이런 순서로 갔을 때 무슨 일이 있었는지를 보는
* 사용 이력 서비스를 어떻게 사용했는지, 일반적으로 DB에 이력을 남기고 로그를 수합하고 통계를 냄.
* 프로그램의 진행을 위해 사용한다는 점.
* 가능하면 영문으로 남기는 것을 추천

* log level : logger를 통해 작성하고자하는 메세지의 중요도, 위험도의 대한 설명 / 즉 trace -> debug -> info -> warn -> error 에러로 갈 수록 위험한 메세지라고 볼 수 있음.
* 에러메세지는 이런 메세지가 발생함으로써 서비스가 잘 되지않았다는 것.
* 일상적으로는 logger.debug만 작성해도 나쁘지않음.

* 중요도가 5가지로 나눠진 이유 : log level 같은 경우 애플리케이션을 실행하면서 그 값을 설정해줄 수 있음. 디폴트 값은 info로 들어감.
* info보다 더 높은 level 만 출력이 됨. 그래서 예시 출력 시 info, warn error로 작성된 메세지만 출력 됨.
* 어플리케이션에 설정된 레벨보다 중요한 메세지만 출력됨.

* 개별 패키지별 레벨 설정 가능.
* JVM 실행시 인자 전달 가능.

* springboot에서 logging을 하기위한 설정은 logback
* log는 서비스를 지켜보고있지 않더라도 로그가 남아야함.
* 일단 따라안해도 된다고 함.

* boot에서 loggerfactroy를 불러오면 logback이라는 라이브러리를 사용하고 있다고 보면 됨.

* Appender라는 interface를 통해 logger의 동작을 정의한다.
    * 출력 위치, 파일 위치
    * 파일 생성 주기 등
* XML을 통해 Log level 및 appender 등을 정의할 수 있다.

* 로깅을 남기는 데 핵심 : 너무 완벽하게 x, 사람이 읽을 수 있을 정도의 상태 표시, 서버 상에 문제가 생겼을 때 해결을 하기위해 어디까지 알아야 하는지. 그런 상황에 따른 공부가 중요함.
-----
# Spring AOP(Aspect Oriented Programming : 관점 지향 프로그래밍)

* 어느 한 함수 처리에 걸리는 시간을 측정하고 싶다.

* 실제 서비스의 프름과는 별개 
    * 로그를 남기는 기능
    * 서비스를 제공하기 위한 기능
* 서로 직접적인 연관은 없기 때문에 기능과는 별개로 작성하는 것이 이상적.

* 서로 다른 비즈니스 로직이 공통적으로 가지는 관심에 대하여 고민하는 개발 지향.
* AOP를 제대로 할려면 AspectJ에 대한 지식이 필요함
* 그래서 deep하게 안함.

* 일반적인 프로그램의 흐름에서, 객체의 함수를 활용하여 프로그램의 목적을 전달하게 됩니다. 그 함수들과 객체들의 사용의 관점에서, 실행부터 종료 사이에 여러 지점들을 생각할 수 있습니다. 이 지점들에 필요한 기능들을 구현하는 것이 목표임

- 프로그램 사이사이에서 필요한 횡단 관심사를 나타내는 단위를 `Aspect`
- 실행과 종료 사이, 함수의 시작 전후, 예외의 전후 등 특정 기능이 실행되어야 하는 후보지점을 `Joinpoint` 
- 특정 `Joinpoint` 에서 실행되는 `Aspect` 의 기능을 `Advice` 라고 부릅니다.
- `Joinpoint` 를 특정 짓는 표현을 `PointCut` 이라 하며, 해당 표현을 만족시키는 `Joinpoint` 마다 `Advice` 가 실행

기본적으로 위의 개념들을 가지고 AOP를 진행하게 됩니다. 저희가 AOP를 통해 횡단 관심사를 해소한다는 것은, `Aspect` 를 판단하여 해당 `Aspect` 에서 실행할 기능을 `Advice` 의 형태로 구현하며, 해당 `Advice` 가 실행되어야 하는 `Joinpoint` 를 `Pointcut` 으로 지정하는 것

* @Target(ElementType.METHOD)
* @Retention(RetentionPolicy.RUNTIME)
* 어느시점에서 어디서 붙일 수 있고 어느 시점에 적용이 되는 것인지 정의해 주는 것.
* 포인트 컷 할때 쓰이는 어노테이션 : @Around
* 정확하게 쓰기 위해선 알아야 되는게 많지만 log 설정 시점에서 간단하게 쓸 수 있는 것도 있음.
* 영 이해안된다 싶으면 몰라도 된다 하지만 알면 좋은 기능을 만들 수 있다.

-----
# validation

* 제약조건은 개발자가 마음대로 정할 수 있다.
* 하지만 사용자의 입력은 어떻게 들어올지 예측하기 어렵다.
* 사용자의 입력에서 사용자가 end유저 뿐아니라 프론트엔드 개발자들 역시 어떤식으로 데이터를 넣어야 될지에 대한 정보가 정확히 없다면
문제가 발생할 수 있음.
* 그래서 사용자입력을 검증하는 것은 중요함.
* 소스 상에서 사용자 입력 검증을 일일이 하는 것은 매우 고됨.

* Jakarta Bean Validation(Java Bean Validation) : 객체 상의 제약사항의 명세를 제공하기 위한 프로젝트
* 이거 자체로는 그 기능을 하지않음.
* jpa 할때 기본적으로 엔티티가 DB상의 구분을 의미를 하는지 표현하는 일련의 명세
그과정에서 jpa 명세를 잘 활용하면 orm 기술을 활용하는데 있어서 잘 사용할 수 있다.

* validation 도 똑같다. 이걸 활용한 구성체는 HIBERNATE
* JPA 와 Hibernate ORM과의 관계가 비슷하다.
* 검증을 할 데이터가 있으면 검증을 하는 대상이 있다 라고 생각하면 됨.

 


