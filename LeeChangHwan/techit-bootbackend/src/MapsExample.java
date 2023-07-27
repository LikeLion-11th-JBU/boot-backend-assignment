import java.util.HashMap;

public class MapsExample {

    public static void main(String[] args) {

        //Map
        // 키-값 쌍을 요소로 가지는 데이터의 모음, 순서 구분 없음
        // 키는 중복 불가, 값은 중복 허용
        // HashMap

        HashMap<String, String> map = new HashMap();        //리스트와 동일하게 <> 넣어서 제한해주면됨.
        // map.put("age", 25); -> 정수형이기에 error가 뜨므로, "25" 처럼 " " 넣어서 실행!
        map.put("mbti", "ENTJ");

        System.out.println(map.get("age"));

    }
}
