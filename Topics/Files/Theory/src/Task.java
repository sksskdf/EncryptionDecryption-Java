// You can experiment here, it won’t be checked

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task {
    public static void main(String[] args) {
        // put your code here
        String str = "Humans are hardly the only interesting members of the animal kingdom. Research on the bodies and behaviors of our furry cousins can help scientists learn more about our own species’ evolution and cognition. And even when they don’t help unlock the ancient secrets of human ancestry, some animals are just too cute — or weird, or gross, or terrifying — not to get to know a little better.";

        Pattern.compile("and?").matcher(str).find();

        Arrays.stream(str.split(" "))
                .filter( l -> {

                })
                .forEach(w -> System.out.printf("\"%s\"\n", w));
    }
}
