import java.util.ArrayList;

public class ListExample {
    public static void main(String[] args) {

        //Lists
        // 순서 구분 , 중복 허용
        // Vector, ArrayList, LinkedList

        //<int> X int의 객체팡일로 타입 지정 <Integer>
        ArrayList<Integer> list = new ArrayList(10);
        list.add(100);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
