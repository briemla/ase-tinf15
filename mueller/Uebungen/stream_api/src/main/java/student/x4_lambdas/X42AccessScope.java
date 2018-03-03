package student.x4_lambdas;


import student.lib.Person;

import java.time.LocalDate;
import java.time.Month;

/*
   A simple example of the access scope.
 */
public class X42AccessScope {

    interface CheckPerson {
        boolean test(Person person);
    }

    private static int myAge = 30;
    private static Person myPerson = new Person("MY-PERSON", LocalDate.of(200, Month.APRIL, 1), Person.Sex.MALE, "my-person@esentri.com");

    public static void main(String[] args) {
        printPersonsWith(person -> person.getAge() >= myAge);
        myAge = 20;
        int anotherAge = 20;
        printPersonsWith(person -> person.getAge() == anotherAge);
//        anotherAge = 9;  // compilation error in the lambda above because the variable is not effectivly final anymore

        System.out.println("SHADOWING");
        printPersonsWith(myPerson -> {
           myPerson.printPerson();
            X42AccessScope.myPerson.printPerson();
            return false;
        });
    }


    private static void printPersonsWith(CheckPerson tester) {
        for(Person person : Person.personList) {
            if(tester.test(person))
                person.printPerson();
        }
    }
}
