import java.util.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        scanner.nextInt();
        int n = scanner.nextInt();
        String letters = "abcdefghijklmnopqrst";
        String digits = "0123456789";
        for (int i = 0; i < a; i++) {
            System.out.print(letters.toUpperCase().charAt(i % letters.length()));
        }
        for (int i = 0; i < b; i++) {
            System.out.print(letters.charAt(i % letters.length()));
        }
        for (int i = 0; i < n - a - b; i++) {
            System.out.print(digits.charAt(i % digits.length()));
        }
    }
}
