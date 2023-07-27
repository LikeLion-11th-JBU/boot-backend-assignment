# Chapter 1

JDK란?

![Untitled](Chapter%201%205e22981199af4c64896a50c0fc8691e5/Untitled.png)

Java 언어를 컴퓨터가 이해하는 언어로 바꿔줘야 한다.

![Untitled](Chapter%201%205e22981199af4c64896a50c0fc8691e5/Untitled%201.png)

JVM - Java Virtual Machine

Java Bytecode - Java 명령어가 하나하나 기계어 포맷으로 되어있음

JRE - Java Runtime Environment

JRE에는 JVM과 JVM이 사용하는 라이브러리 등을 포함

결과적으로 JDK는 무엇이냐? 저 모든 것을 포함한 포괄적인 내용

JDK - Java Development Kit 

Java 코드를 Java Bytecode로 만드는 과정 - 컴파일  + JRE

![Untitled](Chapter%201%205e22981199af4c64896a50c0fc8691e5/Untitled%202.png)

![Untitled](Chapter%201%205e22981199af4c64896a50c0fc8691e5/Untitled%203.png)

Code Editor와 IDE

![Untitled](Chapter%201%205e22981199af4c64896a50c0fc8691e5/Untitled%204.png)

![Untitled](Chapter%201%205e22981199af4c64896a50c0fc8691e5/Untitled%205.png)

![Untitled](Chapter%201%205e22981199af4c64896a50c0fc8691e5/Untitled%206.png)

단순한 코드 에디터, 실행이나 디버깅 등 테스트 불가

![Untitled](Chapter%201%205e22981199af4c64896a50c0fc8691e5/Untitled%207.png)

단순히 문법과 언어에 대한 체크가 아닌 디버깅 등 실행까지 가능한 범용적인 도구

IDE는 다양한 기능이 있는 만큼 더 무거운 프로그램

Docker Setting

Docker - container 개념을 화용한 가상화 기술의 일종

OS 위에 컨테이너를 올려 어플리케이션을 활용

![Untitled](Chapter%201%205e22981199af4c64896a50c0fc8691e5/Untitled%208.png)

*Hypervisor?

t6

![Untitled](Chapter%201%205e22981199af4c64896a50c0fc8691e5/Untitled%209.png)

Spring Boot는 웹 서비스를 만들기 위함이다

단순히 Spring만 있어서 동작하는 것이 아닌 위의 예시같은 DB나 다른 소프트웨어들의 합작?으로 동작한다.

Docker는 그것을 쉽고 편하게 도와준다

![Untitled](Chapter%201%205e22981199af4c64896a50c0fc8691e5/Untitled%2010.png)

간단한 도커 테스트

Client-Server Model

Spring (Boot)은 웹 어플리케이션 개발말고도 다른 분야에도 쓰인다

(Spring Boot는 Spring의 하위 분야)

![Untitled](Chapter%201%205e22981199af4c64896a50c0fc8691e5/Untitled%2011.png)

![Untitled](Chapter%201%205e22981199af4c64896a50c0fc8691e5/Untitled%2012.png)

Internet(Web)은 HTML CSS JS로 이루어져 있으며 3개를 Internet의 Cornerstone으로 부른다

![Untitled](Chapter%201%205e22981199af4c64896a50c0fc8691e5/Untitled%2013.png)

![Untitled](Chapter%201%205e22981199af4c64896a50c0fc8691e5/Untitled%2014.png)

![Untitled](Chapter%201%205e22981199af4c64896a50c0fc8691e5/Untitled%2015.png)

Full-Stack 개발자는 Front-End와 Back-End를 모두 하는 개발자를 의미

Full-Stack 개발자 한명만 있으면 웹서비스가 뚝딱하고 나온다

하지만 이상적인 의미이기 때문에 실제로는 적다

![Untitled](Chapter%201%205e22981199af4c64896a50c0fc8691e5/Untitled%2016.png)

인터넷(Internet) - 원격으로 연결된 수많은 네트워크를 이르는 말

인터넷 브라우저는 서버에 요청을 보내고 받는다

프로세스의 요청과 응답의 형태를 Client - Server Model 이라고 칭한다

Spring Boot는 어떠한 프로세스 요청에 대한 응답의 부분을 칭한다

Spring Boot로 만드는 서버 프로세스, 서버 컴퓨터 혼동하지 않기

Spring Boot를 공부한다는 것이 어떤 의미인가?

1. Spring Boot는 웹 어플리케이션 프레임워크이다
2. HTTP 요청 등을받으면 요청(등)에 따른 응답을 돌려주는 Web Application을 만드는 Framework이다
    
    Framework : 특정한 목적을 위한 도구 또는 라이브러리의 모음
    

Spring Boot를 기초로 웹 서비스에 필요한 요소들을 알아보자.

Spring Boot 프로젝트 시작하기