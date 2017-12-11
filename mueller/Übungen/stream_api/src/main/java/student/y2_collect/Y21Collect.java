package student.y2_collect;

/*
    In contrast to .reduce() the method .collect() will not generate a new object on each return. It adds up all the
    returns in a collection by itself.

    <R> R collect(Supplier<R> supplier, BiConsumer<R,? super T> accumulator, BiConsumer<R,R> combiner)

    Supplier: a function, that will return an object, that can accept and combine values
    Accumlator: a function, that defines how the supplier will accept the values
    Combiner: if the stream is running in parallel, this function decides how to add up all the results

    Note: Collect is a reduce method as well.

    // TODO write your own supplier that collects all ages and email addresses in two different lists. Implement and
    //        use the class CustomCollector. Use the collect() method on the Person.personList.stream(). Print out both
    //        lists at the end.
    // TODO collect all email addresses from Person.personList into an ArrayList. Use the collect() method.
 */
public class Y21Collect {

    public static void main(String[] args) {
        collectToSupplier();
        collectToArrayList();
    }

    private static void collectToSupplier() {
    }

    private static void collectToArrayList() {
    }


}
