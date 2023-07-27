import java.util.ArrayList;

public class ListsExample {

    public static void main(String[] args) {

        // Lists
        // 특징 -> 순서 구분, 중복 허용
        // Vector, ArrayList, LinkedList

        // 데이터 타입을 제한하고 싶을 땐, ArrayList<Integer> -> 자료형을 정수형만 사용가능.

        ArrayList list = new ArrayList(10);
        list.add(100);
        list.add("ENFJ");

        for (int i = 0; i < list.size(); i++) { // 전체 길이를 변환해주는 size 메소드
            System.out.println(list.get(i)); // .get(i)를 통해 인덱스를 할당해줘야 함
        }






    }
}
