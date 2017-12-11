package student.x5_std_functional_interfaces;


import student.lib.Person;

import java.util.function.Consumer;
import java.util.function.Predicate;

/*
    Standard functional interfaces with lambda expressions.

    Suppose, you want to have another action than printing on the found persons.

    interface Consumer<T> {
        void accept(T t);
    }
 */
public class X53Consumer {

    public static void main(String[] args) {
        System.out.println("All ages above 20:");
        processPersons(person -> person.getAge() > 20, person -> System.out.println(person.getAge()));

        System.out.println("All email addresses of persons above 20 and male:");
        processPersons(person ->  person.getAge() > 20 && person.getGender() == Person.Sex.MALE,
                      person ->  System.out.println(person.getEmailAddress()));
    }

    private static void processPersons(Predicate<Person> predicate, Consumer<Person> consumer) {
        for(Person person : Person.personList) {
            //TODO implement this method
            //check the person against the test method of predicate and if true the consumer should print the person
        }
    }


}
