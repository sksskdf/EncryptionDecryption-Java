import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);

        List<String> strings = Arrays.asList(sc.nextLine().split("\\s"));

        System.out.println(strings);
    }
}