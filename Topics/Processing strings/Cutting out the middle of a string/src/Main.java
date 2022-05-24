import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        String s = new java.util.Scanner(System.in).nextLine();
        int n = s.length() / 2 + s.length() % 2 - 1;
        System.out.println(s.substring(0, n) + s.substring(s.length() - n));
    }
}