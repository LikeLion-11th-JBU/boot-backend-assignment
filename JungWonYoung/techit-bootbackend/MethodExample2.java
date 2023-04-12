import java.util.ArrayList;

public class MethodExample2 {

    public static void main(String[] args) {

        ArrayList list_1 = new ArrayList<>();
        list_1.add(10);
        list_1.add(100);
        printListElement(list_1);

    }

    static  void printListElement(ArrayList list) {

        for(int i =0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}
