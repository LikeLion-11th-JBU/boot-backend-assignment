import java.util.ArrayList;
        // 불필요한 반복작업 반복이 조건이 길어지면 함수로 걸어놓으면 곳곳에서 활용가능.
public class MethodExample2 {

    public static void main(String[] args) {

        ArrayList list_1 = new ArrayList<>();
        list_1.add(10);
        list_1.add(100);

        printListElements(list_1);
    }

    static void printListElements(ArrayList list) {

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
