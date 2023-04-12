import java.util.HashMap;

public class MapsExample {
    public static void main(String[] args) {
        //map
        //키-값 쌍을 요소로 가지는 데이터의 모음, 순서 구분 없음
        //키는 중복불가, 값은 중복 허용
        //hashMap(객체 타입)

        HashMap<String,String> map = new HashMap(); //파라미터 자리에 인자를 넘기지 않고 처리해도 무방
        map.put("age","30"); //map이라는 변수에 put 메소드 실행
        map.put("mbti", "INFP");

        System.out.println(map.get("age")); // 키값을 넣어야 실행 된다

    }
}
