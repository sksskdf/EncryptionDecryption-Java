// You can experiment here, it won’t be checked

import java.util.ArrayList;
import java.util.List;

public class Task {
  public static void main(String[] args) {
    // put your code here
    List<String> list = new ArrayList<>();

    list.add("first");
    list.add("second");
    list.add("third");
    list.add("fourth");

    System.out.println(list.contains("FIRST"));
  }
}
