import java.util.HashMap;

public class MapsExample {

    public static void main(String[] args) {

        // Map
        // 키-값 쌍을 요소로 가지는 데이터의 모음, 순서를 구분하지 않음
        // 주의! -> 키는 중복 불가능, 값은 중복 가능
        // HashMap 에 대해서 Araboza

        // 여기도 <String, String> 와 같이 키, 값 등을 제한할 수 잇따. 우효 ~ wwww

        HashMap map = new HashMap();
        map.put("age", 30); // age 는 키, 30은 값
        map.put("mbti", "ENFJ");

        System.out.println(map.get("age")); // 키 값을 get 에 넘겨줘야함 (키에 대응하는 값을 출력하므로)

    }
}
