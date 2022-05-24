import java.util.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        String word = new Scanner(System.in).next();
        int count = 0;

        for (int i = 0; i < word.length() - 2; i++) {
            if (word.substring(i, i + 3).matches("[aeiouy]{3}") ||
                    word.substring(i, i + 3).matches("[bcdfghjklmnpqrstvxzw]{3}")) {
                count++;
                i++;
            }
        }
        System.out.println(count);
    }
}