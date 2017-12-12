package student.x5_std_functional_interfaces;


import student.lib.Person;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/*
    Standard functional interfaces with lambda expressions.

    Suppose, you want to have a return value instead of void.

    interface Function<T,R> {
        R apply(T t);
    }
 */
public class X52Function {

    public static void main(String[] args) {
        System.out.println("Send email to all persons above 20 and female:");
        processPersons(person ->  person.getAge() > 20 && person.getGender() == Person.Sex.FEMALE,
                       person ->  person.getEmailAddress(),
                       emailAddress -> System.out.println("Sending email to " + emailAddress + "..."));
    }

    private static void processPersons(Predicate<Person> predicate, Function<Person, String> function, Consumer<String> consumer) {
        for(Person person : Person.personList) {
            //TODO implement this method
            // the person should be tested against the predicate and if true, the function should return the
            // email address which will be printed by the consumer
        }
    }


}
