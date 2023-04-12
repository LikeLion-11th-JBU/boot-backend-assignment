public class Conditional {

    public static void main(String[] args) {

        int a = 1;
        int b = 100;

        if (a ==b){
            System.out.println("a == b");
        }else if(a<b){
            System.out.println("a < b");
        }else if(a<=b){
            System.out.println("a <= b");  
        }
        else{
            System.out.println("else");
        }

        if (a == b){
            System.out.println("a == b");
        }else{
            System.out.println("else"); 
        }

        if(a != b){
            System.out.println("a != b");
        }

        int c = 10;

        switch(c+1){ 
            case 11:
                System.out.println("c1 == 11");
                break;
            case 9:
                System.out.println("c + 1 == 9");
                break;
            case 10:
                System.out.println("c + 1 == 10");
                break;
            default:
                System.out.println("default"); 
        }
    }
}
