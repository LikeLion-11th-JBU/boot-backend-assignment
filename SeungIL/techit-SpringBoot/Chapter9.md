# RabbitMQ

* HTTP는 단방향 단일성 통신
* 클라이언트와 서버가 완벽히 분리
* 어느 한쪽이 요청을 보내면 다른 쪽이 요청을 보낼 수는 없음.

* Message Broker : 메시지 기반의 통신을 위해 활용하는 부수적 소프트웨어(Middleware)의 일종

* 서버에 발생하는 과부하를 분산 => 서버의 개수를 늘리면 됨.
* 기능을 여러 서비스에 걸쳐서 제공하는 MSA에서 필요로하는 기법들

* Job Queue : 서버 중간에 Message queue를 둠으로써 job을 queue에 쌓아두고 그걸 처리할 수 있는 서버들을 따로 둠으로써 처리의 양을 늘림.

* Publish Subscribe Message Pattern(pubsubMessagePattern) : 어떤 데이터 변동사항을 많은 서버에 걸쳐서 돌려주는 형태

* 대표적인 Message Broker는 `RabbitMQ`

-----
## Messsage Broker 사용

* queue에 연결되어있는 두 서버에서 message를 생성하는 주체를 producer / 소모하는 주체를 consumer
* 어떤 서비스에서 이런일이 있었다는걸 알리기위해서 exchange로 message를 작성하게 된다면 그것과 연관되어있는
서버들이 전부 그걸 확인 할 수 있다.

-----
## redis (REmote Dictionary Server)

* Dictionary : Key - Value 형식으로 데이터를 저장하는 Collection
* 결국 key - value 형식으로 된 database

* In-Memory : 휘발성 데이터를 저장하기 위함
* NoSQL : SQL을 이용한 조회를 하지 않음.
* 외부 캐시 또는 MEssage Broker로 활용.

* 부하를 분산할 때 필요한 기술.

* 단점 : 명백하게 상호에대해 알아야 하는게 많아서 결합력 상승하는 경향..

-----
## WebSocket
* http와 마찬가지로 애플리케이션 레이어 상에 정의된 통신 규약

* WebSocket이란?
    * Http는 단방향 단일성 통신임.
    * 클라이언트에서 요청을 보내면 그 요청을 해석하고 응답을 보낸다.
    * 웹소켓은 양방향 통신을 구현하기 위해 사용하는 통신규약임.
    * 한쪽이 연결을 종료하기 전까진 통신을 주고받을 수 있음.
    * 채팅어플리케이션을 만드는데 많이 사용.
* 클라이언트가 HandShake 요청(http요청의 일종)을 보냄
* 서버쪽에서 HandShake 응답을 보냄
* 요청과 응답을 정상적으로 주고받은 클라이언트와 서버는 연결 종료 까지 양방향 통신이 이루어 짐.

* 1. 연결을 하는 것 2. 연결 종료 3. 양방향 통신을 통해 메세지를 주고 받는다 4. 에러가 발생
* OnOpen() , onClose(), onMessage(), onError() => Event Driven Programming(특정한 이벤트의 발생과 이벤트 핸들링을 통해 프로그램을 만들어낼때 구현을하는 형태의 프로그래밍)
* 주고받는 데이터의 해석이 어렵다(어떤 형태의 데이터인지)

* STOMP(Simple/streaming/ Text Oriented Messageing Protocol)
=> Http의 형태와 유사한 형태의 데이터 규약을 정의해놓은 프로토콜들(커멘드, 해더, 바디) 이를 프레임이라 부르고 서로 주고받는 메세지의 형태로 정의해놓은 서브 프로토콜

* HTTP : 다양한 경로를 기준으로 기능 분리
* WebSocket : 하나의 경로로 많은 클라이언트 접속 메세지 기반
* STOMP : Destination으로 메세지를 받을 클라이언트 결정

-----
## WebClient 
* Spring에 HTTP요청을 보내기위한 Interface
* 기존의 RestTemplate과 달리 Reactive Programming을 하는데 사용할 수 있다.
    * Reactive Programming : 데이터 변경에 대한 반응을 기반으로 하는 프로그래밍 패러다임.

* WebClient는 Spring Boot 서버에서 HTTP 요청을 보낼때 활용하게 되는 인터페이스이며, 
  본래 사용되어 오던 RestTemplate 을 대체합니다. Spring Reactive의 일부로, 리엑티브 프로그래밍을 하기 위한 모듈이지만, 지금은 일단 단순한 HTTP 요청을 위한 용도로 활용합니다. 후에 리엑티브 프로그래밍에 대한 관심이 생기신다면, 지금 소개드리는 것보다 WebClient를 좀더 잘 활용하실 수 있을 겁니다.
