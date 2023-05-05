# CRUD & DATA

* 서비스의 자원 
* EX) 뉴스 기사
* 신문사 , 기자, 분류(IT, 연예 등) -> 모두 서로 자원들 간의 관계를 갖고 이뤄짐.

* EX) 식당
* 메뉴, 요리사 등

* 웹 서비스를 개발 : 사용자가 원하는 자원의 관리
* 자원 제공, 제작, 갱신 등
* 부수적인 기능은 서비스 별로 다르게 만들어진다.

* CRUD : Create - 생성 / Read - 조회 / Update - 갱신 / Delete - 삭제
* 이 4가지의 행동을 할 수 있어야 한다.
* CRUDL, BREAD, DAVE 등의 용어들이 있다. CRUD가 기본적.

-----
* RESTful 이란
* REpresentational State Transfer
* 서버의 형태에 따라서 클라이언트의 형태가 고정돼 있을 경우 어느 한쪽이 변화하는것이 상대방에게 큰 변화를 미치게 될때 커플링이 높다. 서로 좋은 구조로 만들어져 있지않다.
* RESTful : 클라이언트와 서버간의 결합성을 줄이기 위한 가이드
* 결합성이 줄면 성능, 확장성 등이 좋아지고, 사용도 더 간편해 진다.
* 얘가 http만을 꼭 사용하는게 아니다.

* RESTful 제약 조건 6가지
* 1. Client Server Architecture : 클라이언트와 서버의 분리 / 서로의 변화가 서로에게 영향을 주지 않는 형태가 되어야 한다.
* 2. Statelessness : 서버를 사용하는 대상, 서버가 요청을 받을 때 마다 사용자가 누구였는지 매번 확인한다. 서버안에 사용자 정보를 기록하지 않는다. / 상태를 저장하지 않음. / 원하는 기능을 위한 상태는 Client가 가지고 있어야 한다.
* 3. Cacheability : 재사용 가능한 결과인지에 대한 표현 / 캐시 가능성 / 자원의 캐싱이 가능한지의 여부를 항상 표기해줘야 한다.
* 4. Layered System : 실제 서버까지 도달하는데 사용자가 알 필요가 없다. / 계층 구조 
* 5. Uniformed Interface : 일관된 인터페이스 / 요청에서 어떤 자원에 대한 요청에 보내는지 명백히 들어나야한다. / 서버에서 응답을 돌려줄 때 자원 자체가아닌 그자원의 형태, 데이터를 돌려주는 것(json을 사용함.)
* 6. Code on Demand(Optional) : 애플리케이션이 실행되는 도중에도 기능이 변할 수 있다. / 일시적 기능의 확장 / 사용 가능한 코드를 응답으로 보내 사용자의 기능을 일시적으로 확작시킬 수 있다.(선택사항이다.)

* 위의 6가지를 지켜야 RESTful 하다라고 할 수 있다.
* 서비스가 커지면 100% REST의 조건을 만족하기 어렵다.

* 1. 경로(path)를 통해 도다라고자 하는 자원을 지정
* 2. Method를 통해 자원에 실행할 기능을 지정
 
* 나중에 돌아온 결과를 봤을 땐 내용물을 확인하기 위해선 자바스크립트 오브젝트 노테이션이다.
* 자바 내부에서 사용하는 어떤 바이트쪼가리가 아니라
* 특정한 자원에 조건을 주고 싶을 땐 query를 사용하는게 일반성있는 인터페이스를 말한다.

-----
* Spring Stereotypes
* 클래스 단위의 패키지로 구성되어있는 것.

* Component란?
* 가장 기본적인 어노테이션
* GRPC service 라는 인터페이스가 정의 되어있음 깃허브에 component를 커스텀 할 수 있음
* 클래스들을 검색해서 spring container에 등록 해준다.
* controller가 requestmapping 하기 위해 쓰던 어노테이션 얘가 어플리케이션에 코드로써 작성기준으론 어플리케이션 가장 바깥부분, 얘가 다른 클래스를 사용함, 눈으로 봤을 땐

* spring IoC Container에서는 ComponentScan을 이용해 사용할 Bean의 범위를 정해줄 수 있다.
* 함수단위 : @Bean
* 클래스 단위 : @Component

* @Component - @Controller : RequestMapping 과 함께 MVC의 'Controller' 역할을 함을 알림
*           - @Repository : Data Access Object와 같이 실제 데이터 근원과 소통하는 부분임을 알림.
*           - @service : 비즈니스 로직이 구현된 부분임을 알림.
* @Component에서 파생됨 위의 3개

* 모든 Bean에 Component를 사용해도 작동하기는 한다.

* 데이터 주고받는 파트를 만들때는 Repository
* 사용 및 검증, 비즈니스로직, 여러가지 실행 결과 조합은 service
* 이 둘은 관리적인 일을 함
-----
* Database 다뤄보기
* 가능한한 기초적인 부분까지하고 우리가 사용할 mysql설치까지 하고 docker를 잘 설치했다면 mysql설치하는덴 1분도 안걸림 ㅋㅋ
* workbench는 다운 받아야 할거임
* 관계형 데이터베이스(RDB) : Codd의 12규칙을 따르고자 하는 Database
* 전부다 따르지는 않음ㅋㅋ
* table(relation)의 형태로 데이터를 저장.
* 관계형 연산자로 테이블 형태로 데이터를 반환

* entity - relationship Diagram (개체 관계 다이어그램 ERD)

* docker로 설치한건 관계형 데이터베이스 서버임 (서버 SW + 물리 서버)

* 지금 설치한 서버 뿐만아니라 다른 MySql 관계형 DB서버를 위해서라면 workbench통해 접근할 수 있다.

* truncate는 mysql의 테이블을 최초의 상태로 돌림.

*  insert, update, delete , truncate 정도 알아두기 select from where은 기본.
