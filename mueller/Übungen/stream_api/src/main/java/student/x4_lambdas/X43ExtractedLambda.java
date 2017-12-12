package student.x4_lambdas;

import student.lib.Person;

/*
    for-each loop with extracted lambda

 */
public class X43ExtractedLambda {

    interface CheckPerson {
        boolean test(Person person);
    }

    public static void main(String[] args) {
        System.out.println("All persons above 20:");
        printPersonsWith(checkPersonEligibleForSelectiveService());
    }

    private static CheckPerson checkPersonEligibleForSelectiveService() {
        //TODO return a lambda instead of null; print all persons that are above age 20
        return null;
    }

    private static void printPersonsWith(CheckPerson tester) {
        for(Person person : Person.personList) {
            if(tester.test(person))
                person.printPerson();
        }
    }
}
