public class Loops {
    public static void main(String[] args) {
    
        for (int i = 0; i < 10; i += 2){
            System.out.println(i);
        }

        int b = 10;

        while(b > 0){
            System.out.println(b);
            b--; 
        }

        do {
            System.out.println(b);  
            b--;
        }while(b > 0);

    }

}
