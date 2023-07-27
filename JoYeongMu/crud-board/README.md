# Crud 게시판 만들기

`게시판` 웹 애플리케이션 프로젝트 입니다. <br/><br/>
`2023.07.09 ~ 2022.07.11` 동안 `Spring Boot`를 사용해 구현했습니다.<br>
`Swagger`를 배우는 것이 목적 입니다.<br>

# 📚 목차

- [사용 기술](#-사용-기술-및-환경)
- [구현 기능](#-구현-기능)
- [API 명세서](#-API-명세서)

# ⚒️ 사용 기술 및 환경

### ⚙️ Backend

| 기술 & 환경   | 버전    |
| ------------- | ------- |
| Spring Boot   | 2.7.11  |
| Gradle        | 8.1.1   |
| MairaDB       | 11.0.2  |
| Java          | 11.0.18 |
| IntelliJ IDEA | 17.0.6  |
| springdoc     | 1.6.14  |
| Swagger       | 3.0.0   |

# ✨ 구현 기능

- 게시판 기능
  - 게시글 작성
  - 게시글 수정
  - 게시글 삭제
- 페이징 기능
  - 처음 페이지로 돌아가기
  - 이전 페이지로 돌아가기
  - 다음 페이지로 넘어가기
  - 마지막 페이지로 넘어가기
  - 최대 `10개 페이지` 모아서 보기

# ✏️ API 명세서

- Swagger V3 (Springdoc)
- http://localhost:8080/swagger-ui/index.html

# 📀 DB

- 저는 MysqlWorkbench에서 mariaDB를 사용하였습니다.
- mariaDB 서버를 열어줍니다.
- 새로 board라는 이름으로 데이터베이스를 생성합니다.
- 자신의 mariaDB 서버에 맞는 설정을 스프링 부트 프로젝트 파일 내에서 바꿔야합니다.
- /src/main/resoures/application.properties 에서 mariaDB 설정을 바꾸시면 됩니다.

```
spring.datasource.driver-class-name=org.mariadb.jdbc.Driver
spring.datasource.url=jdbc:mariadb://localhost:<할당 포트 번호>/board
spring.datasource.username=<root(mariaDB 유저 이름)>
spring.datasource.password=<mariaDB 비밀번호>
```

- IntelliJ에서 CrudBoardApplication.java 를 실행 시키면 JPA(ORM)을 통해서 board라는 데이터 베이스에 필요한 테이블 들이 생성된 것을 확인 할 수 있습니다.
- localhost:8080/spring-ui/index.html 에서 엔드포인트들을 확인 하시고 게시물 작성 시 테이블에 데이터들이 잘 들어가는지 확인해 주시면 됩니다.
