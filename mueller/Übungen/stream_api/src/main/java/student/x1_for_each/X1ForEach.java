package student.x1_for_each;

import student.lib.Person;

/*
    Traditional approach: for-each loop

 */
public class X1ForEach {

    public static void main(String[] args) {
        System.out.println("All persons above 20:");
        printAllAboveAge(20);
        System.out.println("All persons above 20 and male:");
        printAllAboveAgeWithGender(20, Person.Sex.MALE);
    }

    private static void printAllAboveAge(int age) {
        //TODO implement with a simple for-each loop
    }

    private static void printAllAboveAgeWithGender(int age, Person.Sex gender) {
        //TODO implement with a simple for-each loop
    }
}
