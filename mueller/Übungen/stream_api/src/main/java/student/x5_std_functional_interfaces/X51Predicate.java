package student.x5_std_functional_interfaces;


import student.lib.Person;

import java.util.function.Predicate;

/*
    Standard functional interfaces with lambda expressions:

    // Eigenschaft
    interface Predicate<T> {
        boolean test(T t);
    }
 */
public class X51Predicate {

    public static void main(String[] args) {
        System.out.println("All persons above 20:");
        printPersonsWith(person -> person.getAge() > 20);

        System.out.println("All persons above 20 and female:");
        printPersonsWith(person ->  person.getAge() > 20 &&
            person.getGender() == Person.Sex.FEMALE);

    }

    private static void printPersonsWith(Predicate<Person> predicate) {
        //TODO implement this method
    }


}
