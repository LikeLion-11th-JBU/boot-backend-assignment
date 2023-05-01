# basic - java project

2. java는 프로그래밍 언어

```
public class HelloWorldApp{
	public static void main(String[] args){
		System.out.println("Hello World!")
	}
}
// 인간 친화적인 언어 (high level language, 고급언어)
```

컴퓨터가 이해할 수 있는 언어는 : 기계어

* 우리가 만든 자바언어를 컴퓨터에 줬다. 이걸 컴퓨터가 바로 인식 못하고 java언어를 컴퓨터가 이해하는 언어로 바꿔줘야 한다.
* JVM(Java Virtual Machine) * Java Bytecode (기계어와 동일한 의미를 가짐)만 있으면 어떠한 플랫폼(cpu, os 등)에도 구동이 됨.
* JRE(Java Runtime Envrionment) * 바이트 코드안에 바로바로 이해할 수 없는 예를 들어 라이브러리 등 실행을 하기 위한 환경 (JRE에는 JVM과 JVM이 사용하는 라이브러리 등을 포함)
* JDK(Java DEvelopment Kit) * 자바 언어를 자바 바이트 코드로 변환하는 과정(컴파일 과정)

* Java Bytecode를 만드는데 Java를 쓸 필요는 없다( ex : kotlin)



3. Code Editor와 IDE
    * Java 코드를 효율적으로 작성하기 위한 도구

Code Editor - vscode 같은거 프로그래밍 언어에 따라 문법 검증 및 편집 편의성 제공

IDE - visual studio, intellij 이런거 사용하는 언어 및 프레임워크에 따라 다양한 기능 제공



4. Docker Setting (Deep한 설명 x, 따로 강의같은걸 듣는걸 추천)
* Dockor 기초 개념
    * 컨테이너 기반의 가상화 기술이다.
    * OS 위에 컨테이너를 올려 어플리케이션을 활용
        
        
        
    * 웹 어플리케이션 개발에 필요한 다양한 소프트웨어의 설치를 간소화 해준다.
* Docker Desktop 설치
* Docker 테스트 해보기



[http://127.0.0.1/](http://127.0.0.1/)

docker rm -f “위에나온 애들(e850a534dd1a)”

ctrl + shift + r 하면 캐쉬를 없앰 



5. Client - Server Model
* Spring Boot - (Web) Application Framework (웹이랑 관련 없는 걸 만들 때도 사용 되기 때문에 Web에 괄호)
* internet 의 Conerstone(주춧돌) : HTML, CSS, JS
* HTML(Hyper Text Markup Language) - 브라우저에 표시 될 내용을 기술하는 언어
* CSS - 표현되는 형식을 정의하는 언어(HTML과 같이 사용하면, 폰트, 색 등등)
* JS - 브라우저에 동작은 제공하는 언어(브라우저에 사용되고 있는 html의 동작을 담당하는 어떤 버튼을 누르면 어떤 일이 발생하고 ~~~)
* 인터넷 브라우저가 사용하는 기술이다. 즉 인터넷 브라우저가 이 프로그래밍 언어로 만들어졌다.
* 크롬, 웨일, 엣지 등 약간 비슷하다는 느낌 받았을 것 크롬에 크로니움(뼈대)를 갖고 MS에서 만든게 엣지 naver에서 만든게 웨일
* 인터넷 브라우저는 HTML, CSS , JS를 해석하는 도구
* View JS, Rework JS 도 끝에는 HTML, CSS, JS로 번역됨 즉 프론트엔드 개발자 - 브라우저에 보이는걸 중점으로 공부하는 개발
* 프론트엔드 개발자는 페이지를 만든다.
* html 문서를 만들 때 일종의 템플릿 화 했다 라고 할 수 있음
* 백엔드 개발자 - 비즈니스 로직, 데이터를 관리하는
    

    
* Full-Stack - 개발자 프론트엔드와 백엔드를 동시에 다룰 수 있는 개발자
* 하지만 요즘 시대엔 ai, nft(비트코인),모바일 개발자 등은 일반적인 웹 개발의 범주 밖
* 인터넷 - 원격으로 연결된 수많은 컴퓨터들이 이루는 네트워크
* http - 어떠한 형식으로 파일을 요청, 응답할지 정해놓은



<Client - Server Model>

* spring boot 는 위 그림 우측에 서버 프로세스에 해당함.
* 스프링 부트로 만드는 서버 프로세스
* 인터넷에서 요청을 받고 그것에 대한 응답을 돌려주기 위한 목적인 컴퓨터인 서버 컴퓨터
* Spring boot - http 요청 등을 받으면 요청에 따른 응답을 돌려주는 Web Application을 만드는 Framework이다.
* Framework - 특정한 목적을 위한 도구 또는 라이브러리의 모음



6. Spring Boot 시작하기

<실습>

낮은 버전을 사용하는 이유 : 레퍼런스 등

group 누가 만들었는지 구분하는

artifact  가독성보다 코드이름

name  실제 프로젝트 이름

description  설명

package name 위에 내용 합친거