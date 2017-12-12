package student.y2_collect;

import student.lib.Person;

import java.util.ArrayList;
import java.util.List;

public class CustomCollector {
    private List<Integer> ages = new ArrayList<>();
    private List<String> emailAddresses = new ArrayList<>();

    public static CustomCollector supply() {
        return new CustomCollector();
    }

    public static void accept(CustomCollector collector, Person person) {
        collector.ages.add(person.getAge());
        collector.emailAddresses.add(person.getEmailAddress());
    }

    public void print() {
        System.out.println("E-Mails: " + emailAddresses);
        System.out.println("Ages: " + ages);
    }

    public static void combine(CustomCollector c1, CustomCollector c2) {
        c1.emailAddresses.addAll(c2.emailAddresses);
        c1.ages.addAll(c2.ages);
    }
}
