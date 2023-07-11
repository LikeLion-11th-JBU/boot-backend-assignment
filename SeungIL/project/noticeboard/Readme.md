## 환경설정

SpringBoot version : 2.7.13
Packaging : Jar
Java version : 11
Gradle-groovy

default Dependency :
    Spring Web, Spring Data JPA, Thymeleaf, Lombok, Mysql Driver

## Clone 후 설정 사항
build.gradle 파일에서 dependency를 잘 확인,
```
implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
implementation 'org.springframework.boot:spring-boot-starter-thymeleaf'
implementation 'org.springframework.boot:spring-boot-starter-web'
implementation 'mysql:mysql-connector-java'
implementation 'io.springfox:springfox-boot-starter:3.0.0'
implementation 'io.springfox:springfox-swagger-ui:3.0.0'
compileOnly 'org.projectlombok:lombok'
runtimeOnly 'com.mysql:mysql-connector-j'
annotationProcessor 'org.projectlombok:lombok'
testImplementation 'org.springframework.boot:spring-boot-starter-test'
```

intellij의 가장 오른쪽상단에 창닫기 밑에보면 코끼리 모양의 Gradle이 있는데 이걸 클릭
그리고 새로고침같은 모양의 `모든 Gradle 프로젝트 다시 로드` 를 클릭 하면 
의존성이 알아서 다운로드 됨. 근데 `implementation 'mysql:mysql-connector-java'` 이부분에 에러가
생길 가능성이 있음(직접 해봄) 그럴 땐 `implementation mysql:mysql-connector-java:8.0.32`
버전을 명세하면 해결됨!

