package student.x7_stream_api;


import student.lib.Person;

/*
    Use the Stream API  :)

    Stream<E> stream();  //obtain a source of objects
    Stream<T> filter(Predicate<? super T> predicate);  //filter objects with a Predicate<T>
    <R> Stream<R> map(Function<? super T,? extends R> mapper);  //map objects to another value with a Function<T,R>
    void forEach(Consumer<? super T> action);   //perform an action with a Consumer<T>

    //TODO implement the functional interfaces as lambdas
    // check for all persons that are over age 20 and female
    // get their email address
    // print each email address to the screen
 */
public class X7StreamApi {

    public static void main(String[] args) {
        Person.personList.stream()                      //obtain a source of objects
                         .filter(/*TODO implement the Predicate*/ null)     //filter objects with a Predicate<T>
                         .map(/*TODO implement the Function*/ null)    //map objects to another value with a Function<T,R>
                         .forEach(/*TODO implement the Consumer*/ null); //perform an action with a Consumer<T>
    }
}
