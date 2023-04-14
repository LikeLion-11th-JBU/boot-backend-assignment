public class PrimitiveType {
    // PrimitiveType : 원시형

    public static void main(String[] args){

    // 정수형

        // 1. byte(1 byte = 8 bits) 1111 1000 -> -2^7 ~ 2^7-1 = (-128 ~ 127)
        // 2. shrot(2 bytes) : -2^15 ~ 2^15-1(-32.768 ~ 32,767)
        // 3. int(4 bytes) : -2^31 ~ 2^31-1 **주로 int를 많이 사용.
        // 4. long(8 bytes) : -2^63 ~ 2^63-1 *주로 웹사이트 같은 곳에서 ID를 long으로 사용.

        // 범위에 맞지않는 숫자를 넣게 되면 어떤일이 발생하는지 살펴보자!
        // byte a = 128; -> 에러가 난다 Why? 128은 byte로 표현이 불가능하기에.
    // 실수형

        // 1. double(8 bytes) - 소수점 15자리까지 정밀도를 가짐.
        // 2. float(4 bytes) - 소수점 7자리까지 정밀도를 가짐. ~~ double이 float에 두 배라서 더블인가~?!

        double a = 1.23;
        float b = 9.45f; // 9.45뒤에 f를 넣지 않으면 error가 뜬다. f를 넣어야 float의 수로 인식함.
        //일반적으로 JAVA에서는 실수형 data는 float보다는 double을 많이 쓴다는 것 인지.

        System.out.println(a);
        System.out.println(b); //sout 입력하면 System.out.println(); 자동입력된다.

    //문자형
        // 1. char(2 bytes)
        // 2. 아스키코드, 유니코드 사용 가능
        char char_1 = 'a'; // " " 입력시 error 발생하므로 꼭 ' ' 로 하기
        char char_2 = 97;
        char char_3 = 43;
        char char_4 = 0x61;

        System.out.println(char_1);
        System.out.println(char_2);
        System.out.println(char_3);
        System.out.println(char_4);


    //논리형
        //1. boolean(1 bytes) : 참, 거짓
        //2.

        boolean bool_1 = true;  //참
        boolean bool_2 = false; //거짓
        boolean bool_3 = (100 < 0 ); // 참, 거짓을 JAVA에서 판명하게 하는 꼴.
      //boolean bool_4 = 1;     //기본적으로 JAVA에서 boolean에 0 or 1을 넣을 수 없다. (true or false 활용해야함.)

        System.out.println(bool_1);
        System.out.println(bool_2);
        System.out.println(bool_3);

    }
}
