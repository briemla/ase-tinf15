package student.y1_optional;

/*
    To avoid NullPointerExceptions there is the concept of 'Optional'.

    An optional holds a value or null. If it holds null, it is possible to return a default value with .orElse() or .orElseGet().
    .orElseGet() will be lazy evaluated.

    Other methods are:
       - ifPresent
       - ifNotPresent
       - ifPresentOrElse

     // TODO get the average of the ages of the people each in PersonLists.dhbwList, PersonLists.esentriList and PersonLists.emptyList and print
     // the numbers. If no average is found, it should print '0'. Use both .orElse() and .orElseGet().
     // TODO if the average is present, print it. Otherwise don't print it. Use .ifPresent()
     // TODO if the average is present, print it. Otherwise print 'no ages found'. Use .ifPresentOrElse()
 */
public class Y1Optional {

    public static void main(String[] args) {
        printAverageOrElse();
        printAverageOrElseGet();
        printAverageIfPresent();
        printAverageIfPresentOrElse();
    }

    private static void printAverageOrElse() {
    }

    private static void printAverageOrElseGet() {
    }

    private static void printAverageIfPresent() {
    }

    private static void printAverageIfPresentOrElse() {
    }

}
