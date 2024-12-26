package interview.dec2024;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class equals_hashcode {

    public static void main(String[] args) {
        System.out.println("Verifying default equals(object o)");
        Object o1 = new Object(); // this o1 has reference heap memory where the object is stored
        Object o2 = o1;

        System.out.println("Is o1 == o2?");
        System.out.println(o1.equals(o2));

        System.out.println("\nAffect of new key word");
        Object o3 = new Object(); // here the new keyword creats a new obj and it's sotrage
        // reference is assigned to o3
        System.out.println("Is o1 == o3?");
        System.out.println(o1.equals(o3));

        System.out.println("\nVerify Has Codes");
        System.out.println("o1" + o1.hashCode());
        System.out.println("o2" + o2.hashCode());
        System.out.println("o3" + o3.hashCode());

        System.out.println("\nStudent section with proper override and contract");
        Student s1 = new Student(1, "sandeep");
        Student s2 = new Student(1, "sandeep");

        System.out.println("Is s1 == s2?");
        System.out.println(s1.equals(s2));
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());

        System.out.println("\nReflective Check");
        System.out.println("Is s1 == s1?");
        System.out.println(s1.equals(s1));

        System.out.println("\nTest Consistency in a HashMap");
        Map<Student, String> map = new HashMap<>();
        Student c1 = new Student(1, "Sandeep RP");
        Student c2 = new Student(2, "Sandeep AB");

        System.out.println("Is c1 == c2?");
        System.out.println(c1.equals(c2));
        System.out.println("Is the Hash code?");
        System.out.println(c1.hashCode() == c2.hashCode());

        map.put(c1, "Student 1");
        map.put(c2, "Student 2");

        for(Map.Entry<Student, String> m : map.entrySet()) {
            System.out.println("Key: " + m.getKey() + "value: " + m.getValue());
        }

        System.out.println(map.get(c1));
        System.out.println(map.get(c2));

        System.out.println("\nAfter Mutation of c2");
        System.out.println("Is c1 == c2?");
        System.out.println(c1.equals(c2));
        System.out.println("Is the Hash code?");
        System.out.println(c1.hashCode() == c2.hashCode());

        for(Map.Entry<Student, String> m : map.entrySet()) {
            System.out.println("Key: " + m.getKey() + "value: " + m.getValue());
        }

        System.out.println(map.get(c1));
        System.out.println(map.get(c2));
    }
}

class Student {
    private int roll_num;
    private String name;

    public Student(int roll_num, String name) {
        this.name = name;
        this.roll_num = roll_num;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return roll_num == student.roll_num && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roll_num, name);
    }

    public int getRoll_num() {
        return roll_num;
    }

    public String getName() {
        return name;
    }
}
