public class PrimitiveType {
    public static void main(String[] args) {

        //정수형

        //1. byte(1byte = 8bit) : 1111.1000 => 범위 : -2^8 ~ 2^8-1
        //2. short(2bytes) : -2^15 ~ 2^15-1
        //3. int (4bytes) : -2^31 ~ 2^31-1
        //4. long(8bytes) : -2^63 ~ -2^63-1


        //범위에 맞지 않는 데이터 타입을 넣었을 때
        //byte a =128; 오류가 나온다

        // 실수현
        //1. double(8bytes) - 소수점 아래 15자리까지 나타냄
        //2. float(4byte) - 소수점 아래 7자리까지 나타냄

        double a = 1.23;
        float b = 2.34f;   //float자료형이라고 명시해줘야한다.

        System.out.println(a);
        System.out.println(b);

        //문자형 데이터 - 문자하나만을 다룰 수 있는 데이터
        // char(2bytes)
        //아스키, 유니코드
        char char_1 = 'a'; //' '로 문자를 입력해준다. " "로 문자를 입력할 시 오류가 나온다.
        char char_2 = 97;
        char char_3 = 43;
        char char_4 = 0x61; //유니코드
        System.out.println(char_1);
        System.out.println(char_2); //문자로 나오는 이유는 97을 아스키코드로 인식하기 때문이다.
        System.out.println(char_3);
        System.out.println(char_4);

        // 논리형 데이터
        // boolean(1byte)

        boolean bool_1 = true;
        boolean bool_2 = false;
        boolean boot_3 = (100<0);
        // boolean boot_4 = 1; 자바에서는 boolean에서 1,0을 사용하지 못한다.

        System.out.println(bool_1);
        System.out.println(bool_2);
        System.out.println(boot_3);

    }
}
