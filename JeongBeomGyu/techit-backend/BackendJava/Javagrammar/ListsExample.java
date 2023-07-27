import java.util.ArrayList;

public class ListsExample {
    public static void main(String[] args) {

        // Lists
        // 순서 구분, 중복 허용
        // Vector, ArrayList, LinkedList가 있다.

        ArrayList list = new ArrayList(10); //ArrayList 파라미터에 들어가는 정보는 ArrayList의 길이이다. 10이라고하면 10개의 요소를 담을 수 있다.
        list.add(100);  //list에 데이터를 추가하고 싶으면 .add라는 메서드 통해서 추가한다.
        list.add("INFP");  //특정한 자료형을 정하지 않았으므로 어떤 자료형이든 리스트에 들어갈 수 있다.

        for( int i = 0; i < list.size(); i++){  //ArrayList에서는 length대신에 .size()를 이용해서 list의 크기를 알 수 있다.
            System.out.println(list.get(i));    //ArrayList에서 배열처럼 인덱스를 넣어주는 위치가 get이라는 메서드를 열어준 다음 거기에다 할당을 해줘야한다.
        }

        //데이터 타입을 제한하고 싶다면 <>안에 제한하고 싶은 자료형을 쓰면된다 int는 Integer을 써야지 정수형 자료형으로 제한이 된다.
    }
}
