import java.util.ArrayList;

public class MethodExample2 {

    public static void main(String[] args) {

        ArrayList list_1 = new ArrayList<>();
        list_1.add(10);
        list_1.add(100);
        printListElement(list_1);

    }

    //List형태의 함수

    static  void printListElement(ArrayList list) {//리스트에 있는 요소들을 출력하는 함수를 만듬, 매개변수 즉 파라미터에 받아야할 데이터의 형태는 ArrayList()이다

        for(int i =0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}
