import java.util.HashMap;

public class MapsExample {

    public static void main(String[] args) {
        //MAP은 맵핑된 정보를 가리킨다.
        //키-값 쌍을 요소로 가지는 데이터의 모음, 순서 구분 없음
        //키는 중복 불가, 값은 중복 가능 (열쇠가 동일할 수 없지만 거기에 대응되는 값은 동일할 경우가 있다)
        //HashMap

        HashMap map = new HashMap();   //HashMap이라는 객체타입을 만들어준다. 인자를 넘기지 않아도 된다.
        map.put("age",30);  //age는 키 30은 값으로 할당된다. HashMap에 값을 할당하기 .put을 이용
        map.put("mbti","INEP"); // mbti는 키 INFP는 값으로 할당된다.

        System.out.println(map.get("age"));  //각각의 데이터를 접근하는 방법은 list와 같이 get을 이용하지만 get에 들어가는 인자가 다르다. 여기에 넘어가는 인자는 인덱스가 아니라 키 값이 들어가야한다. 그러면 키와 대칭되는 값이 나온다.
        // 만약 데이터 형태를 제한하고 싶으면 HashMap <>에 제한하고 싶은 키와 값의 데이터형을 제한할 수 있다. EX) HashMap<Spring,Spring>을 하면 키와 값이 모두 Spring 데이터형으로 제한된다.


    }
}
