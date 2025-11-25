package service;

import models.Group;
import models.Lesson;
import models.Student;

import java.util.List;

public interface StudentService {
    void addStudent(String groupName, Student student);
    void updateStudent(String email,String password,String newFirstName,String newLast);
Student findStudentByFirstName(String firstName);
List<Student> getAllStudentByGroupName(String groupName);
List<Lesson>getAllLessonByStudentEmail(String studentEmail);
void deleteStudentByEmail(String studentEmail);
}
