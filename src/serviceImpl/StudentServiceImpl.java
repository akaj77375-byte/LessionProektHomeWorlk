package serviceImpl;

import DataBase.Db;
import models.Group;
import models.Lesson;
import models.Student;
import service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    @Override
    public void addStudent(String groupName, Student student) {
        try {
            if (groupName == null||groupName.isBlank()) {
                throw new NullPointerException("Название группы не должно быть равно null!");
            }
            for (Student s : Db.students) {
                if (s.getEmail().equals(student.getEmail())) {
                    throw new RuntimeException("Такой  email уже есть попробуйте другой");

                }
            }
            for (Group g : Db.groups) {
                if (g.getGroupName().equalsIgnoreCase(groupName)) {
                    g.getStudents().add(student);
                    Db.students.add(student);
                    return ;
                }
            }
            System.out.println("Нету такого название группы!");
            return;
        }catch (NullPointerException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateStudent(String email, String password, String newFirstName, String newLast) {
try{
    if (email==null||password==null||email.isBlank()||password.isBlank()){
        throw new NullPointerException("email или пороль не должен бить равен null!");
    }
    for (Student s:Db.students){
        if (s.getEmail().equals(email)&&s.getPassword().equals(password)){
            s.setFirstName(newFirstName);
            s.setLastName(newLast);
            return;
        }
    }
    System.out.println("Не провильный пороль или email");
}catch (NullPointerException e){
    System.out.println(e.getMessage());
}
    }

    @Override
    public Student findStudentByFirstName(String firstName) {
        try {
            if (firstName == null||firstName.isBlank()) {
                throw new NullPointerException("Имя студента  не должно быть равно null!");
            }
            for (Student s : Db.students) {
                if (s.getFirstName().equalsIgnoreCase(firstName)) {
                    return s;
                }
            }
            System.out.println("Нету такого студента  с таким именим ");

        }catch (NullPointerException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Student> getAllStudentByGroupName(String groupName) {
        try {
            if (groupName == null||groupName.isBlank()) {
                throw new NullPointerException("Название группы не должно быть равно null!");
            }
            for (Group g : Db.groups) {
                if (g.getGroupName().equalsIgnoreCase(groupName)) {
                    return g.getStudents();
                }
            }
            System.out.println("Нету такой группы  с таким название ");
return List.of();
        }catch (NullPointerException e){
            System.out.println(e.getMessage());
        }
        return List.of();
    }

    @Override
    public List<Lesson> getAllLessonByStudentEmail(String studentEmail) {

            try {
                if (studentEmail == null||studentEmail.isBlank()) {
                    throw new NullPointerException("Email студента не должен быть null!");
                }


                Student foundStudent = null;
                for (Student s : Db.students) {
                    if (s.getEmail().equals(studentEmail)) {
                        foundStudent = s;
                        break;
                    }
                }

                if (foundStudent == null) {
                    throw new RuntimeException("Студент с таким email не найден!");
                }


                return foundStudent.getLessons();

            } catch (NullPointerException e) {
                System.out.println(e.getMessage());
            } finally {
                System.out.println("(T_T)<(^-^<)");
            }

            return List.of();
        }



    @Override
    public void deleteStudentByEmail(String studentEmail) {
        try {
            if (studentEmail == null||studentEmail.isBlank()) {
                throw new NullPointerException("Email студента не должен быть null!");
            }



                   boolean isTrue = Db.students.removeIf(student -> studentEmail.equalsIgnoreCase(student.getEmail()));
                for (Group g:Db.groups){
                    g.getStudents().removeIf(student -> studentEmail.equalsIgnoreCase(student.getEmail()));
                }
                if (isTrue){
                    System.out.println("Вы успешно удалили "+studentEmail);
                    return;
                }else {
                    System.out.println("Нету такого студента");
                }
        }catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
}
