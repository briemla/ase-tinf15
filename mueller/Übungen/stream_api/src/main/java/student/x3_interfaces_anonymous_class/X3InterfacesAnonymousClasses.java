package student.x3_interfaces_anonymous_class;


import student.lib.Person;

/*
    //TODO use an anonymous class for achieving the tasks
 */
public class X3InterfacesAnonymousClasses {

    interface CheckPerson {
        boolean test(Person person);
    }

    public static void main(String[] args) {
        System.out.println("All persons above 20:");
//        printPersonsWith();

        System.out.println("All persons above 20 and female:");
//        printPersonsWith();
    }

    private static void printPersonsWith(CheckPerson tester) {
        for(Person person : Person.personList) {
            if(tester.test(person))
                person.printPerson();
        }
    }
}
