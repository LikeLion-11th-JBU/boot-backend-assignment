public class ReferenceType {
    public static void main(String[] args) {

        //참조형
        //참조형 데이터의 값 => 힙 메모리 영역
        //변수에 대입되는 값 => 힙 메모리 영역의 주소값
        String a = new String("Hello"); //String이라는 참조형 데이터는 new 연산자를 통해서 객체를 만들어줘야한다. 힙에 동일한 데이터가 있던지 않던지 새로운 데이터를 만든 후 새로운 주소값을 준다.
        System.out.println(a);

        String b ="Hello"; //리터럴을 이용한 값자체에 대입 => 이 방식은 기존에 힙 메모리에 동일한 값이 있는지 확인 후 동일한 값이 있으면 동일한 주소값을 준다.
        String c ="Hello";
        //a와 b는 다른 주소값을 가진다
        if (a==b){ //a와b가 같은 주소값을 가리킬 때
            System.out.println("a==b");
        }

        if(b==c){
            System.out.println("b==c");
        }
    }
}
