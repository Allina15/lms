package LMS.Models;

import LMS.Enums.Gender;

public class Student {
    private String firstName;
    private String lastName;
    private int age;
    private Gender gender;
    private String email;

    public Student(String firstName, String lastName, int age, Gender gender, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student " +
                "firstName = " + firstName +
                ", lastName = "+ lastName+
                ", age = " + age +
                ", gender = " + gender +
                ", email = " + email;
    }
}
