package student.x2_interfaces_classes;


import student.lib.Person;

/*
    for-each loop with interface and implementing class

    //TODO implement the interface in a class that will check if the person is between 18 and 25 years old and male (use the commented class for this task)
    //TODO uncomment the method in the main method and check your program
 */
public class X2InterfacesClasses {

    interface CheckPerson {
        boolean test(Person person);
    }

    public static void main(String[] args) {
        System.out.println("Check, if person is eligible for selective service.");
        //printPersonsWith(new CheckPersonEligibleForSelectiveService());
    }

    //private static class CheckPersonEligibleForSelectiveService implements CheckPerson {
    //}

    private static void printPersonsWith(CheckPerson tester) {
        for(Person person : Person.personList) {
            if(tester.test(person))
                person.printPerson();
        }
    }
}
