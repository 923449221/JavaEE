package collection.List;

import java.util.Objects;

/**
 * @author li
 * @create 2022--06
 * @description
 */
public class Person {
    String name;
    int age;
    char C;

    public char getC() {
        return C;
    }

    public void setC(char c) {
        C = c;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }
    public Person(){}
    public Person(String name, int age, char c) {
        this.name = name;
        this.age = age;
        C = c;
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("equals方法");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                C == person.C &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, C);
    }

    public void setAge(int age) {
        this.age = age;
    }
}
