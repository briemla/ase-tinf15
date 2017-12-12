package student.x9_reduction;

import student.lib.PersonLists;
import java.util.List;

/*
    There are several operations to reduce a stream. E.g.:
        - average
        - sum
        - min
        - max
        - count

     // TODO get the sum of the ages of the people each in PersonLists.dhbwList and PersonLists.esentriList and print
     // the numbers
 */
public class X91Reduction {

    public static void main(String[] args) {
        example();
    }

    private static void example() {
        long totalNumber = PersonLists.instance.stream().flatMap(List::stream).count();
        System.out.println("All the people got counted: " + totalNumber);
    }

}
