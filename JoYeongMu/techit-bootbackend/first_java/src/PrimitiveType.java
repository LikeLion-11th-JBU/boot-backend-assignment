public class PrimitiveType {
    public static void main(String[] args) {
//        정수형
//        1. byte(1 byte = 8bit) 1111 0000 2^8개 를 가질 수 있는 경우의 수이다
//        = -2^7 ~ - 2^7-1 (-128~127)
//        2. sort(2 bytes = 16bit): -2^15 ~ 2^15-1(-32768 ~ 32767)
//        3. int (4byte = 32bit): -2^31 ~ 2^31-1 개의 정수를 표현 할 수 있다.
//        4. long(8 bytes ):-2^63 ~ 2^63-1
//    byte a = 128; 127을 넘어서 안됨
//
//        실수형
//        1. double(8 bytes) 소수점 -15자리 까지
//        2. float(4 bytes) -7자리
//        float b = 9.45; 만 하면 오류 9.45f; 로 표기 할 것
        double a = 1.23;
        float b = 9.45f;
        System.out.println(a);
        System.out.println(b);

//        문자형
//        char(2 bytes) 문자를 '' 로 감아야함
        char char_1 = 'a';
        char char_2 = 97;
        char char_3 = 0x61;
//        unit 코드 16비트로 나타내는것도 가능 전세계 언어표현 가능
//        ASCII코드 로 인해서 a a 로 출력

        System.out.println(char_1);
        System.out.println(char_2);
        System.out.println(char_3);

//        논리형 참거짓형
//        boolean(1byte)
//
        boolean bool_1 = true;
        boolean bool_2 = false;
        boolean bool_3 = (100 < 0);
//        boolean bool_4 = 1; 이거는 안되니까 참고

        System.out.println(bool_1);
        System.out.println(bool_2);
        System.out.println(bool_3);


    }
}
