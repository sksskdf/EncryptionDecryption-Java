import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        List<Integer> collect = Arrays
                .stream(sc.nextLine().split(""))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

        int a = 0;
        int b = 0;
        for (int i = 0; i < collect.size(); i++) {
            if(i <= 2) {
                a += collect.get(i);
            } else {
                b += collect.get(i);
            }
        }

        System.out.println(a == b ? "Lucky" : "Regular");
    }
}