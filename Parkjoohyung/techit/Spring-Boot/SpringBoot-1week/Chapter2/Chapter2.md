# Chapter 2

Spring Boot Basic 1

Build Automation Tool

Java와 Build Automation Tool

Maven 알아보기

Gradle 알아보기

Java 언어로 작성된 코드 ⇒ 기계어  -  JVM과 JRE

Java로 이뤄진 프로젝트는 ‘*.java’파일에 정의된 Java Source 코드로 구성된다

javac는 jdk의 일부분

javac - Java Compiler

Compiler : 소스코드를 기계어로 바꾸는 과정

javac 명령어만 가지고 전체 프로젝트를 다루는건 매우 복잡한 일이다

$javac 동작구조 한번 알아보면 도움이 될듯

대중적인 자바 도구 Maven, Gradle

막상 프로그램으로 처리할때 자동화하여 처리

일일이 javac로 바꾸지 않고 대신해줌

Maven

![Untitled](Chapter%202%20a4733c5dc4354ba9aec0f699c4a9fe3b/Untitled.png)

일반적으로 java에서 많이 사용

HTML과 다르게 POM 사용

pom.xml부터 천천히 빌드업하여 시작       $xml에 대한 지식도 다시 알아보자

Lifecycle

clean

validate

compile

test

package

verify

install

site

deploy

각각 용어(기능) 알아보기

![Untitled](Chapter%202%20a4733c5dc4354ba9aec0f699c4a9fe3b/Untitled%201.png)

.m2 dir에 실제로 maven 프로젝트를 할때 사용하는 여러 라이브러리 들이 들어있으니 한번 확인해보자

>> pom.xml 파일에 모두 정리되어있음.

Gradle

![Untitled](Chapter%202%20a4733c5dc4354ba9aec0f699c4a9fe3b/Untitled%202.png)

요즘 추세는 Gradle로 넘어가는 추세

Maven이나 Gradledependency(ies) 부분에 커스텀해서 넣을 수 있음

Spring Boot 실행하기

일반적인 웹 서비스의 배포 구조

Java와 Jar

Web Application의 구조

![Untitled](Chapter%202%20a4733c5dc4354ba9aec0f699c4a9fe3b/Untitled%203.png)

일반적인 웹 서비스의 배포 프로세스

![Untitled](Chapter%202%20a4733c5dc4354ba9aec0f699c4a9fe3b/Untitled%204.png)

통상적으로 쓰는 port은 80, 443 (유동적일 수 있음)

![Untitled](Chapter%202%20a4733c5dc4354ba9aec0f699c4a9fe3b/Untitled%205.png)

웹서버를 통해 서버의 파일시스템에 있는 자료를 시각화

각각 보유한 HDD와 SSD의 내용을 보여준다고 생각하면 편한다

![Untitled](Chapter%202%20a4733c5dc4354ba9aec0f699c4a9fe3b/Untitled%206.png)

![Untitled](Chapter%202%20a4733c5dc4354ba9aec0f699c4a9fe3b/Untitled%207.png)

서비스를 하기 위해 물리적인 서버가 필요

그 앞에 웹서버를 붙이는게 대다수

![Untitled](Chapter%202%20a4733c5dc4354ba9aec0f699c4a9fe3b/Untitled%208.png)

![Untitled](Chapter%202%20a4733c5dc4354ba9aec0f699c4a9fe3b/Untitled%209.png)

장고랑 스프링과 크게 다른점은 없다

공통적인건 NGINX(웹서버)

![Untitled](Chapter%202%20a4733c5dc4354ba9aec0f699c4a9fe3b/Untitled%2010.png)

Spring을 빌드하면 jar 파일이 생성된다(결과물)

![Untitled](Chapter%202%20a4733c5dc4354ba9aec0f699c4a9fe3b/Untitled%2011.png)

![Untitled](Chapter%202%20a4733c5dc4354ba9aec0f699c4a9fe3b/Untitled%2012.png)

MANIFEST.MF 파일에서 실행되는 구조 확인 가능

메인으로 실행되는 부분 등등

jar는 빌드가 된 파일로써 최종 결과물로 인지

![Untitled](Chapter%202%20a4733c5dc4354ba9aec0f699c4a9fe3b/Untitled%2013.png)

Spring을 서비스한다고 하면 docker에서 실행한다 or jar파일을 실행한다 라고도 함

![Untitled](Chapter%202%20a4733c5dc4354ba9aec0f699c4a9fe3b/Untitled%2014.png)

데이터를 실제로 보여준다라는 관점에서 Data Layer와 Presentation Layer는 다르기 때문에 구분하자

![Untitled](Chapter%202%20a4733c5dc4354ba9aec0f699c4a9fe3b/Untitled%2015.png)

Dispatcher Servlet : 실제로 HTTPS 서버의 요청과 보냄 역할을 하는 부분

Controller Service Repository - 실제로 요청을 처리하는 부분으로 클래스로 만들어 관리

Service - Controller의 요청을 받아 실제로 동작을 하게 되는 부분

Repository - Data Layer의 부분으로 데이터 표현의 부분으로 실제로 데이터를 저장하고 처리하는 부분

![Untitled](Chapter%202%20a4733c5dc4354ba9aec0f699c4a9fe3b/Untitled%2016.png)

실제로 웹서비스가 동작하는 프로세스 정리

![Untitled](Chapter%202%20a4733c5dc4354ba9aec0f699c4a9fe3b/Untitled%2017.png)

Spring Boot로 웹 서비스를 만들게 되면 위와 같은 프로세스로 동작

Spring IoC

Java의 Interface

Spring IoC Container와 DI

Spring과 Spring Boot의 차이

![Untitled](Chapter%202%20a4733c5dc4354ba9aec0f699c4a9fe3b/Untitled%2018.png)

Java 는 Interface를 어떻게 활용하는지에 따라 숙련도가 나뉜다

Spring Boot도 이와 같이 구현

인터페이스와 추상클래스를 잘 사용하자 (마스터리, 숙련도의 척도)

![Untitled](Chapter%202%20a4733c5dc4354ba9aec0f699c4a9fe3b/Untitled%2019.png)

외부에서 사용하게 될 함수에서 인자는 인터페이스(Interface) 형태로 작성하기

내부에서 구현체로 사용할때는 리스트(List) 형태로 작성하기

InputStream에 대해 알아보기

들어오는 파일의 타입에 따라 다르게 여러 포맷으로 구성되어 있음

자바언어는 기본적으로 만들어져 있을때 구현체, 추상객체 같은 것들을 항상 잘 알아두자

![Untitled](Chapter%202%20a4733c5dc4354ba9aec0f699c4a9fe3b/Untitled%2020.png)

![Untitled](Chapter%202%20a4733c5dc4354ba9aec0f699c4a9fe3b/Untitled%2021.png)

다양하니 한번 다시 알아보자

![Untitled](Chapter%202%20a4733c5dc4354ba9aec0f699c4a9fe3b/Untitled%2022.png)

프레임워크가 개발자의 코드를 이용하는게 아니라 개발자가 프레임워크의 기능을 이용하는것

Spring 개발자다 하면 무조건적으로 받는 대표적인 질문 IoC에 대하여 설명

⇒ Spring IoC Container가 이 역할을 해준다

이해할때까지 공부해볼것

![Untitled](Chapter%202%20a4733c5dc4354ba9aec0f699c4a9fe3b/Untitled%2023.png)

![Untitled](Chapter%202%20a4733c5dc4354ba9aec0f699c4a9fe3b/Untitled%2024.png)

개발자의 코드와 설정이 합쳐진 것을 Beans 라고 말한다

스프링 IoC 컨테이너가 관리를 하는 객체

스프링을 실행하게 되면 만들어진 여러 객체들이 스프링 IoC 컨테이너에서 Beans의 형태로 배치된다

비즈니스 로직을 하면서 다른 객체를 사용해야하는 시점에서 IoC 컨테이너에서 Bean 객체들을 받는다

개발자가 new로 선언되어 있던 객체를 정리한다던지 어느 시점에 만들어진 객체를 어디에서 관리를 하고 있는지 신경을 덜 쓸 수 있음

필요한 시점에 Beans(객체)들을 다시 주입을 시켜서 사용할 수 있게 한다

⇒ Dependency Injection(DI) - 의존성 주입

⇒ 가장 많이 면접질문에서 듣게 될것 확실히 알아두자

![Untitled](Chapter%202%20a4733c5dc4354ba9aec0f699c4a9fe3b/Untitled%2025.png)

![Untitled](Chapter%202%20a4733c5dc4354ba9aec0f699c4a9fe3b/Untitled%2026.png)

Spring Framework는 XML형태로 이루어져 있어 도입 난이도가 높았다

제대로된 config가 힘들었기 때문에

![Untitled](Chapter%202%20a4733c5dc4354ba9aec0f699c4a9fe3b/Untitled%2027.png)

Spring boot는 자바 선에서도 가능하고 Starter에 포함되어 있기 때문에 편하고 쉽다

![Untitled](Chapter%202%20a4733c5dc4354ba9aec0f699c4a9fe3b/Untitled%2028.png)