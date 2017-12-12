package student.lib;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Person {

    public enum Sex {
        MALE, FEMALE
    }

    public Person(String name, LocalDate birthday, Sex gender, String email) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.emailAddress = email;
    }

    private String name;
    private LocalDate birthday;
    private Sex gender;
    private String emailAddress;

    public int getAge() {
        return LocalDateTime.now()
            .minusDays(birthday.getDayOfMonth())
            .minusMonths(birthday.getMonth().getValue())
            .minusYears(birthday.getYear())
            .getYear();
    }

    public Sex getGender() {
        return gender;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void printPerson() {
        System.out.println("<Person>:  Name: " + name + "  Gender: " + gender.toString() + "  Age: " + getAge()
            + "  email: " + emailAddress);
    }

    public static List<Person> personList = new ArrayList<>();
    static {
        personList.add(new Person("Peter", LocalDate.of(2000, Month.APRIL, 12), Person.Sex.MALE, "peter@esentri.com"));
        personList.add(new Person("Petra", LocalDate.of(1986, Month.DECEMBER, 22), Person.Sex.FEMALE, "petra@esentri.com"));
        personList.add(new Person("Mirko", LocalDate.of(1989, Month.MARCH, 9), Person.Sex.MALE, "mirko@esentri.com"));
        personList.add(new Person("Ender", LocalDate.of(1130, Month.JULY, 1), Person.Sex.MALE, "ender@esentri.com"));
        personList.add(new Person("Baby", LocalDate.of(2016, Month.OCTOBER, 11), Person.Sex.MALE, "male-baby@esentri.com"));
        personList.add(new Person("Child", LocalDate.of(2010, Month.JANUARY, 30), Person.Sex.FEMALE, "female-child@esentri.com"));
        personList.add(new Person("Teenager", LocalDate.of(2002, Month.AUGUST, 13), Person.Sex.MALE, "male-teenager@esentri.com"));
        personList.add(new Person("Adult", LocalDate.of(1990, Month.JANUARY, 30), Person.Sex.FEMALE, "female-adult@esentri.com"));
    }
}
