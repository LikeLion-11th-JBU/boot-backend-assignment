public class StringExample {

    public static void main(String[] args) {

        String str = "안녕하세요!"; 
        String str_2 = new String("안녕하세요!"); 
        String str_3 = "안녕하세요!";

        if (str == str_2){
            System.out.println("str==str_2");
        }
        if(str == str_3){
            System.out.println("str ==str_3");
        }
        if(str_2 == str_3){
            System.out.println("str_2 == str_3");
        }

        if (str.equals(str_2)) {
            System.out.println("str.equals(str_2)");
        }
        if (str.equals(str_3)){
            System.out.println("str.equals(str_3)");
        }
        if(str_2.equals(str_3)){
            System.out.println("str_2.equals(str_3)");
        }

        String str_4 = "Hello,";
        String str_5 = "World!";
        System.out.println(str_4 + " " + str_2);

        StringBuilder strBdr_1 = new StringBuilder("Hello,"); 

        strBdr_1.append(" ");
        strBdr_1.append("World!"); 

        String str_new = strBdr_1.toString();
        System.out.println(str_new); 

        String str_6 = "이름: 김자바"; 
        System.out.println(str_6.indexOf("이"));
        System.out.println(str_6.indexOf("름"));

        String str_name = str_6.substring(4,7); 
        System.out.println(str_name);

        String str_7 = "abc";
        String str_8 = "ABC";

        str_7 = str_7.toUpperCase();
        str_8 = str_8.toLowerCase();

        System.out.println(str_7);
        System.out.println(str_8);

        if(str_7.equals(str_8)){
            System.out.println("str_7.equals(str_8)");
        }

        if(str_7.equalsIgnoreCase(str_8)){
            System.out.println("str_7.equalsIgnoreCase(str_8)"); 
        }

        String str_9 = "          Hello    ";
        str_9 = str_9.trim(); 
        System.out.println(str_9);

        String str_10 = "   Hel    lo    ";
        str_10 = str_10.trim();
        str_10 = str_10.replace(" ","");
        System.out.println(str_10);


    }
}
