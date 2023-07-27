public class Conditional {

    public static void main(String[] args) {

        int a = 1;
        int b = 100;

        //if를 사용한 조건문
        //다중 조건문이라면 조건을 만족하는 최초의 분기만 실행
        if (a ==b){
            System.out.println("a == b");
        }else if(a<b){
            System.out.println("a <b");
        }else if(a<=b){
            System.out.println("a<=b");   //위에 else if문이 실행되었으므로 실행되지 않는다.
        }
        else{
            System.out.println("else");
        }

        if (a == b){
            System.out.println("a == b");
        }else{
            System.out.println("else");  //a와 b가 같지 않다면 else블록의 코드를 출력해라
        }

        if(a != b){
            System.out.println("a != b");
        }


        //switch를 이용한 조건문 ()조건식에 활용되는 변수는 외부에서 선언한다.

        int c = 10;

        switch(c+1){   //case가 전부 실행되는데, case는 조건문이 실행되었다고 해서 멈추지 않는다. 그렇기 때문에 조건문을 빠져나갈 수 있는 break;키워드를 추가로 작성해줘야한다.
            case 11:
                System.out.println("c+1==11");
                break;
            case 9:
                System.out.println("c+1==9");
                break;
            case 10:
                System.out.println("c+1==10");
                break;
            default:
                System.out.println("default"); //case에 아무 조건도 맞는게 없으면 default값이 실행된다.


        }
    }
}
