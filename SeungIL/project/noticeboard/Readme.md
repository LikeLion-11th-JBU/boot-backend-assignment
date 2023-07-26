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

swagger 진입점 : http://localhost:8080/swagger-ui/

DataBase 연동 방법
```
1. mysqlworkbench 접속
2. 본인 root 계정으로 들어간 후
3. User and Privileges 클릭
4. 새로운 계정 생성 username 은 board_user
5. password는 qwer1234!@
6. 그리고 새로운 스키마 생성 스키마명은 board_schema
7. 그리고 다시 home으로 돌아와 connection을 새로 생성
8. 생성시 username과 스키마명을 동일하게 명세하여 connect
9. apllication.yml 파일에 `ddl-auto : update` 상태이므로 따로 테이블을 작성할 필요 없음
10. 이외 궁금한 사항이있다면 문의 바랍니다.
```

