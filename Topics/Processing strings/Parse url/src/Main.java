import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {
        // put your code here
        String str = new Scanner(System.in).nextLine();
        str = str.substring(str.indexOf("?")+1);
        str = str.replace("=&","=not found&");
        str = str.replace("=", " : ");
        String password = "";

        for (String data : str.split("&")) {
            System.out.println(data);

            if (data.contains("pass")) {
                password = data.replace("pass", "password");
            }
        }

        System.out.println(password);
    }
}