import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    static void changeList(List<String> list) {
        // write your code here
        int asInt = list.stream().mapToInt(String::length).max().getAsInt();
        String collect = list.stream().filter(f -> f.length() == asInt).collect(Collectors.joining());

        Collections.fill(list, collect);
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        List<String> lst = Arrays.asList(s.split(" "));
        changeList(lst);
        lst.forEach(e -> System.out.print(e + " "));
    }
}