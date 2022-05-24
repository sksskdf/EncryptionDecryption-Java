import java.util.Collections;
import java.util.List;

class Counter {

    public static boolean checkTheSameNumberOfTimes(int elem, List<Integer> list1, List<Integer> list2) {
        // implement the method
        if (Collections.frequency(list1, elem) == Collections.frequency(list2, elem))
            return true;
        return false;
    }
}