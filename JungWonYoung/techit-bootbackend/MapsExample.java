import java.util.HashMap;

public class MapsExample {

    public static void main(String[] args) {

        HashMap map = new HashMap();
        map.put("age",10);
        map.put("mbti","infj");

        System.out.println(map.get("age")); 
    }
}
