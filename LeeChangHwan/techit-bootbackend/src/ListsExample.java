import java.util.ArrayList;

public class ListsExample {

    public static void main(String[] args) {

        // Lists
        // 순서 구분, 중복 허용
        // Vector, **ArrayList, LinkedList

        ArrayList<Integer> list = new ArrayList(10);
        //DataType을 제한하려면? <>넣고 제한하려는 것을 넣기!
        list.add(100);
        //list.add("ENTJ");   // <Integer>을 넣어서 error가 나옴

        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}
