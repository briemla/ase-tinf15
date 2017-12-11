package student.x4_lambdas;


import student.lib.Person;

/*
    for-each loop with LAMBDA!

    A functional interface is any interface that contains only one abstract method - although it can contain one
    or more default methods or static methods). Using a lambda you can implement the method with almost none
    boilerplate code.

    LAMBDAs in generell:
    - consist of a comma-separated list of formal parameters enclosed in parentheses
    - the arrow token: ->
    - body
      -- if only one expression nothing more is needed and this expression gets evaluated to the return type of the
         abstract functional interface method
      -- if you have more than one expression (i.e. multiple lines of code each ending with ;) you have to use
         curly parenthesis {}

    - they have the same access to local variables like anonymous classes
       -- members of enclosing class
       -- local variables if defined as final or if effectively final (i.e. a variable whose value is never changed
                                                                       after it is initialized -- since Java 8)
            -> also called capturing
       -- shadowing is the same as well (i.e. hiding variables with same name)

        //TODO use lambdas to achieve the goal!

        An example lambda:
        person -> person.printPerson()

        An example lambda with more than one command:
        person -> {
           person.printPerson();
           System.out.println("Second command");
        }

 */
public class X41Lambdas {

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
