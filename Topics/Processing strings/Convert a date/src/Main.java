import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);

        String[] split = sc.nextLine().split("-");

        System.out.println(split[1] + "/" + split[2] + "/" + split[0]);
    }
}