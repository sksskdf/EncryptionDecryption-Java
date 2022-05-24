import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        int index = sc.nextInt();

        if(index > str.length()) {
            System.out.println(str);
        } else {
            String strF = str.substring(0,index);
            String strE = str.substring(index,str.length());

            System.out.println(strE + strF);
        }
    }
}