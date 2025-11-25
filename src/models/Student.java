package models;

import enums.Gender;

import java.util.List;
import java.util.Objects;

public class Student {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Gender gender;
    private List<Lesson>lessons;

    public Student() {
    }

    public Student(long id, String firstName, String lastName, String email, String password, Gender gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        if (email.contains("@gmail.com")){
            this.email = email;

        }else {
            System.out.println("email должен содержать @gmail.com");

        }
       if (password.length()>=7){
           this.password = password;
       }else {
           System.out.println("Ваш пороль должен содержать 7 символов");
           return;
       }

        this.gender = gender;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && Objects.equals(firstName, student.firstName) && Objects.equals(lastName, student.lastName) && Objects.equals(email, student.email) && Objects.equals(password, student.password) && gender == student.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, password, gender);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", gender=" + gender +
                '}';
    }
}
