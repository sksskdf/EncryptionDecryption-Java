import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> numbers = Arrays
                .stream(sc.nextLine().split("\\s"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));

        int n = sc.nextInt();

        ArrayList<Integer> result = new ArrayList<>();

        int delta = Integer.MAX_VALUE;

        for (int i : numbers) {
            if (Math.abs(i - n) < delta) {
                delta = Math.abs(i - n);
                result.clear();
                result.add(i);
            } else if (Math.abs(i - n) == delta) {
                result.add(i);
            }
        }

        Collections.sort(result);

        result.forEach(l -> System.out.print(l + " "));
    }
}