# Build Automaion Tool
JVM - JRE - JDK

* java로 이뤄진 프로젝트는 '.java' 파일에 정의된 소스코드로 구성된다.
* JDK에는 javac(자바 컴파일러)가 있다.

```
import hello.Hello;
publicc class TestMain{
    public static void  hello(){
            System.ou.println("hello from class");
    }
}
```
* 위의 소스코드를 cmd를 이용하여 (반드시 디렉토리에 들어가야함 ex. cd "디렉토리명")`javac TestMain.java` 란 명령어를 쓰면 컴파일이 이루어짐
* java TestMain 이란 명령어를 치면 위의 소스코드가 실행됨.

    * 컴파일은 소스코드를 기계어로 바꾸는 과정
    * 컴파일 다음단계는 빌드 기계어로 바꾸는 것 뿐만아니라 완성을 하는데 필요한 모든 과정

* 자바에서의 빌드
자바 바이트 코드로 변환 -> 바로 바이트코드를 실행 -> 문제가 없다면 실행 가능한 파일로 제작(패키징)
상황에 따라 과정이 변할 수 있다.( ex 테스트 생략 가능)
=> 일일히 직접 하기에는 과정이 복잡함.
=>> 그래서 등장하게 된 것이 maven, gradle.
* maven : java를 위한 build automation tool
    * c#, Ruby 등의 다른 언어를 위해서도 사용가능
    * Project Object Model(POM)
    * xml의 형태롤 프로젝트를 정의
    * pom.xml을 분석해 프로젝트 빌드
    * html이랑 구조가 비슷
    * 가장 대중적인건 jason, xml

* pom.xml 구조 이해하기
```
<?xml version="1.0" encoding="UTF-8"?> : 어떤 형식의 문서인지
```
```
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd"> : 키값을 어디서 가져오는지 / 어떤 키 값을 사용할지
```
```   
    <modelVersion>4.0.0</modelVersion> : 버전
```    
```
<parent>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-parent</artifactId>
<version>2.7.11</version>
<relativePath/> <!-- lookup parent from repository -->
</parent> : 부모 있어야 하는 이유 다음다음 영상에 있음
```

```
<groupId>dev.seungil</groupId> : 이 프로젝트를 만들 그룹의 도메인을 역순으로 만든다.
// 패키지 명임    
//예를들어 구글은 com.google 이 되겠음.
```
```
<artifactId>maven-demo</artifactId> : 상세한 프로젝트가 무엇인지
```
```
<version>0.0.1-SNAPSHOT</version> : 만들 프로젝트의 버전 major.miner.patch
//major가 변하면 이전에 사용하던 코드들을 다 바꿔야함/ 마이너 버전의 변경은 새로운 기능의 추가 / 패치 새로운 기능은 없고 일반적으로 버그 수정, 사소한 변경사항
//스냅샷은 매우 빠르게 변경사항들이 일어날 수 있다.
```
* properties의 내용을 밑에 dependencies에 넣어도 된다.

```
<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>
// 얘네만 있으면 원하는 형태로 빌드할 수 있음.
```

* gradle에서도 maven repository와 같은 걸 사용함
* gradle : java를 위한 Build Automation Tool
* c,c++,JS 등을 위해서도 사용할 수 있다.
* build.gradle
    * groovy라는 언어로 프로젝트 정의
    * Sub-project 등을 포함시키는 용도의 setting.gradle 도 있다.
    * Kotlin을 사용하여 정의할 수도 있다.(build.gradle.kts)
    * 초기 단계에서 maven보다 느림

----

# Spring Boot 실행하기

* 일반적인 웹 서비스의 배포 구조
    * 사용자 브라우저에다가 주소창에 주소를 넣으면 그 주소에 해당하는 컴퓨터에 요청이가고 그 컴퓨터에서 웹페이지를 돌려주게 됨. \n
    => 그 뒤의 내용은 어떻게 돌아가는지 모름 (컴퓨터 통신의 영역)

* 신호가 들어온 이후 : 도메인을 통해서 요청이 들어옴 -> 그 요청 자체는 컴퓨터 안에 있는 몇몇 프로그램에 들어가는데 대표적으로 APACHE, NGINX라는 web sever에 들어감
* 사실 ip(0~2^16-1 범위 : 포트번호)가 들어감 ip 주소는 컴퓨터의 이름 포트 번호 : 컴퓨터 내부에 있는 프로세스에 배분해주기 위한 숫자
* ex) 189.206.151.238:80 ip번호가 들어가면 물리적 컴퓨터(서버)에서 웹서버에 80,443 두갈래로 나눠서 번호를 줌

* web sever != web application sever (서비스를 제대로 제공하기 위한 기능을 갖춘 서버 톰캣 같은)

* 들어온 신호 -> 물리적 컴퓨터(서버) -> 웹서버 -> 파일 시슴템 / 웹 애플리케이션 서버 -> 자바 웹 애플리케이션(WAR[web application resource]파일) or spring boot

* 구조 : 물리적인 서버(hardware) -> webserver -> filesystem(정적파일들) / springboot
* 이런 구조도 가능하다 : hardware -> springboot
* 서버의 구성은 다양한 방법이 가능하다.
* 요즘엔 docker 많이 사용함.

* spring boot 프로젝트를 빌드하면 jar 파일이 나온다.
* jar = Java ARchive, java로 작성 후 컴파일 된 자바 바이트코드와 실행을 위해 필요한 다양한 자원을 배포를 위해 모아놓은 파일의 형태
* 쉽게 말해 다른 형태의 압축파일

* 프로젝트 구조와 jar 파일 구조는 유사함.

* Program의 Entry Point, 시작점 == main 함수

* 실제로 하는건 main 클래스

* 멀티피어 어플리케이션 아키텍처
    * Presentation Layer : 사용자와 직접적으로 맞닿는 부분(소스코드 상에서 사용자의 입력과 맞닿아있는 부분)
    * Logic Layer : 요청을 처리하는 결졍을 내리는 부분(비즈니스 로직 레이어, 비즈니스 로직 티어 사용자의 입력을 직접 받는 부분은 아니지만 입력을 확인하고 액션을 취하는 부분)
    * Data Layer : 데이터를 저장하고 불러오는 부분(데이터 레이어 자체가 사용자의 데이터 자체를 의미하지 않음, 데이터의 표현만 주고받음)


* Spring Boot의 작은 구조
* Dispatcher Servlet(요청) : 프레임워크 내부에 구현돼있는 부분, http서버의 역할을 하는 애들을 거쳐서 요청들을 받아내는 부분
* Contorller(그에 따른 검증 및 서비스로 전달) : Dispatcher의 요청을 직접적으로 받는 클래스의 형태로 정의
* Service(상황에 맞게 레포지토리에 요청) : 컨트롤러가 검증해낸 요청을 받아서 사용자의 입력에 따른 데이터의 조작을 결정해주는 부분 클래스 하나로 정의
* Repository(DB와 소통하여 data표현의 일부를 받아옴) : 데이터 레이어로써 데이터의 표현을 받아서 실제 데이터를 저장하고 데이터 표현을 불러와서 데이터를 돌려주는 역할
* View Resorver
* DB

* Dispatcher Servlet(요청) -> Contorller(그에 따른 검증 후 서비스로 전달) -> Service(상황에 맞게 레포지토리에 요청) -> Repository(DB와 소통하여 data표현의 일부를 받아옴) -> DB -> 다시 역순 진행 후 response
--------
# Spring ioC
* interface를 잘 만드냐 못만드느냐 -> 숙련도 판단가능
* 사용할 때는 무조건 외부에서 사용하게 될 함수에서 인자는 인터페이스의 형태로
* 내부에서 구현할 때는 인터페이스 list로 만드는걸 추천함.
* InputStream의 구현체는 많지만 다 InputStream의 기능을 가지고 있따. = InputStream을 필요로 하는 기능에는 구분없이 사용할 수 있다.

* Spring IoC Container 와 DI
* 스프링이 등장하기 이전엔 정의되어있는 라이브러리를 갖다 코드를 쓰는게 전통적인 개발
* Inversion of Control(제어 역전) : 개발자의 코드를 프레임워크가 가져가 쓰는 것.(스프링이 등장하고 스프링의 IoC가 등장하면서 등장) 
* 프레임워크가 자신이 해야하는 역할을 정확히 가지고 있다면 개발자의 코드를 프레임워크가 가져다가 사용을 하게 된다
* 스프링 프레임워크는 애플리케이션 프레임워크고 대표적으로 웹 애플리케이션 프레임워크로 사용되는데
* 웹 애플리케이션이 가질 수 있는 기능이 뭔지 생각해 보면 요청을 받고 통신을 통해서 신호를 받고 그 신호를 다시 보내는 형태
* 통신을 하는 부분은 항상 동일하게 작성이 됨. 비즈니스 로직에 대한 부분만 바뀌게됨
* 신호를 받는 부분은 개발하지않고 신호를 받고 데이터를 사용했을 때 어떠한 액션이 일어나야 하는지만 개발하게 된다.
* 그 부분의 코드만 작성하면 스프링 프레임워크가 알아서 작동하게 해주는 것.

*IoC Container : IoC를 담당하는 부분, 개발자가 작성한 코드 + 설정 정보 => 이 프레임워크를 기반으로 만든 애플리케이션이 작동할 때 이 두가지를 합쳐서 만들어져야 하는 객체들을 직접 만들어줌
* 프레임워크를 잘 쓴 코드는 new(자바 키워드)가 최소화 되어있음, arrayList같은걸 쓸 땐 new를 사용하겠지만 ㅋㅋ
* 이 객체가 이런 역할을 할 것이다 라는걸 정의해 놓으면 생성자에서 그 객체를 직접적으로 만들어서 배치를 해준다.
* 즉 개발자가 작성한 코드와 설정정보를 합쳐서 완전한 웹 서비스를 만드는 것이다. 
* 개발자가 작성한 코드에서 설정을 넣어줌으로써 하나의 객체가 완성이 되는데 개발자가 작성한 코드와 설정을 합친걸 스프링에선 Bean이라고 부름

* Spring IoC Container에 이 Bean(객체)들이 배치가됨
* 다른 객체를 사용해야할 시점에서 이미 만들어져 있던 Bean들을 전달 해주게 됨
* 개발자가 new로 선언 되어있던 객체를 정리를 한다던지, 어느 시점에 만들어진 객체를 어디에서 관리하고 있는지 같은 부분을 덜 신경 쓸 수 있음.
* 필요한 시점에 다시 주입 시켜서 사용 할 수 있게 해주는 부분은 Dependency Injection(DI : 의존성 주입)

* 결국 스프링 프레임워크를 잘 쓴다 == bean을 얼마나 잘 구현하냐

* 스프링 프레임워크는 기본적으로 xml의 형태로 설정을 만들어 주던 시절이 있었음.
* bean 설정 자체도 xml형태로 작성
* 그래서 입문하기 되게 힘들었다.
* 이 xml을 어케 작성해야하는지는 시간이 오래걸림
* 이젠 스프링 부트 스타터에 정의되어있음

* xml 파일은 실행을 간편하게 하기위한 목적 또한 있었음
* 스프링 프레임워크는 자바 명령어를 통해서 자기자신을 실행할 수 없었음
* 웹 애플리케이션 서버같은 제2의 프로그램을 통해서 war파일을 배포해주는 과정이 필요했음

* 한편 스프링 부트 프로젝트는 톰캣의 기능을 포함시키게 됨.
* 따라서 스프링 부트의 결과물은 jar파일의 형태이고 jar 파일은 java명령어를 통해 바로바로 실행시킬 수 있음.
* 즉 스프링 부트 프로젝트를 빌드하게 된다면 바로 실행해서 테스트를 할 수 있는데 의의가 있음.
* 근본적인 큰 차이는 없다.
