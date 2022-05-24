// You can experiment here, it won’t be checked

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Task {
  public static void main(String[] args) {
    // put your code here
    List<Integer> list = new LinkedList<>();

    list.add(1);
    list.add(2);
    list.add(3);
    list.add(2);

    for (Integer number : list) {
      System.out.println(number);
    }
  }
}
