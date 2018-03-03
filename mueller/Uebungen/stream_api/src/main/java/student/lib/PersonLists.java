package student.lib;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class PersonLists {

    public static List<Person> esentriList = new ArrayList<>();
    static {
        esentriList.add(new Person("Peter", LocalDate.of(2000, Month.APRIL, 12), Person.Sex.MALE, "peter@esentri.com"));
        esentriList.add(new Person("Petra", LocalDate.of(1986, Month.DECEMBER, 22), Person.Sex.FEMALE, "petra@esentri.com"));
        esentriList.add(new Person("Mirko", LocalDate.of(1989, Month.MARCH, 9), Person.Sex.MALE, "mirko@esentri.com"));
        esentriList.add(new Person("Ender", LocalDate.of(1130, Month.JULY, 1), Person.Sex.MALE, "ender@esentri.com"));
        esentriList.add(new Person("Baby", LocalDate.of(2016, Month.OCTOBER, 11), Person.Sex.MALE, "male-baby@esentri.com"));
        esentriList.add(new Person("Child", LocalDate.of(2010, Month.JANUARY, 30), Person.Sex.FEMALE, "female-child@esentri.com"));
        esentriList.add(new Person("Teenager", LocalDate.of(2002, Month.AUGUST, 13), Person.Sex.MALE, "male-teenager@esentri.com"));
        esentriList.add(new Person("Adult", LocalDate.of(1990, Month.JANUARY, 30), Person.Sex.FEMALE, "female-adult@esentri.com"));
    }

    public static List<Person> dhbwList = new ArrayList<>();
    static {
        dhbwList.add(new Person("Lars", LocalDate.of(2001, Month.APRIL, 12), Person.Sex.MALE, "lars@dhbw.com"));
        dhbwList.add(new Person("Harald", LocalDate.of(1999, Month.DECEMBER, 22), Person.Sex.FEMALE, "harald@dhbw.com"));
        dhbwList.add(new Person("Tim", LocalDate.of(1998, Month.MARCH, 9), Person.Sex.MALE, "tim@dhbw.com"));
        dhbwList.add(new Person("Java", LocalDate.of(2000, Month.JULY, 1), Person.Sex.MALE, "java@dhbw.com"));
        dhbwList.add(new Person("Whoever", LocalDate.of(2000, Month.OCTOBER, 11), Person.Sex.MALE, "whoever@dhbw.com"));
        dhbwList.add(new Person("Lala", LocalDate.of(2001, Month.JANUARY, 30), Person.Sex.FEMALE, "lala@dhbw.com"));
        dhbwList.add(new Person("Teenager", LocalDate.of(2002, Month.AUGUST, 13), Person.Sex.MALE, "teenager@dhbw.com"));
        dhbwList.add(new Person("Hi", LocalDate.of(1998, Month.JANUARY, 30), Person.Sex.FEMALE, "hi@dhbw.com"));
    }

    public static List<List<Person>> instance = new ArrayList<>();
    static {
        instance.add(esentriList);
        instance.add(dhbwList);
    }

    public static List<Person> emptyList = new ArrayList<>();
}
