import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {
    public static void main(String[] args) {
        // put your code here
        String s = new Scanner(System.in).nextLine();

        Pattern p = Pattern.compile("(.)\\1*");
        Matcher m = p.matcher(s);

        while (m.find()) {
            System.out.print(m.group(1) + m.group(0).length());
        }
    }
}