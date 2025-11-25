import DataBase.Db;
import DataBase.GenId;
import enums.Gender;
import models.Group;
import models.Lesson;
import models.Student;
import service.GroupService;
import service.LessonService;
import service.Start;
import service.StudentService;
import serviceImpl.GroupServiceImpl;
import serviceImpl.LessonServiceImpl;
import serviceImpl.StartImpl;
import serviceImpl.StudentServiceImpl;

import java.net.PasswordAuthentication;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        StudentService studentService = new StudentServiceImpl();
        GroupService groupService = new GroupServiceImpl();
        LessonService lessonService=new LessonServiceImpl();
        Start start=new StartImpl();
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println(start.times());
            System.out.println("Если уже есть акаунт тогда 1 если забыли пороль 2");
            int san= sc.nextInt();
            String o= sc.nextLine();
           switch (san){
               case 1-> {
                   System.out.println("ведите email:");
                   String email= sc.nextLine();
                   System.out.println("ведите пороль:");
                   String password= sc.nextLine();
                   if (start.login(email,password)){
                       int choice=0;
                       do {
                           System.out.println("\n Бир команда тандаңыз! ");
                           System.out.println("1 -> Add new group");
                           System.out.println("2 -> Get group by name");
                           System.out.println("3 -> Update group name");
                           System.out.println("4 -> Get all groups");
                           System.out.println("5 -> Add new student to group");
                           System.out.println("6 -> Update student");
                           System.out.println("7 -> Find student by first name");
                           System.out.println("8 -> Get all students by group name");
                           System.out.println("9 -> Get all student's lessons");
                           System.out.println("10 -> Delete student");
                           System.out.println("11 -> Add new lesson to group");
                           System.out.println("12 -> Get lesson by name");
                           System.out.println("13 -> Get all lessons by group name");
                           System.out.println("14 -> Delete lesson");
                           System.out.println("15 -> Delete group");
                           System.out.println("0 -> Exit");
                           System.out.print("Enter your choice: ");

                           if (sc.hasNextInt()) {
                               choice = sc.nextInt();
                               sc.nextLine();
                           } else {
                               System.out.println("Неверный ввод — пожалуйста, введите число.");
                               sc.nextLine();
                               continue;
                           }

                           switch (choice) {
                               case 1:

                                   System.out.println("Введите название группы");
                                   String name = sc.nextLine();
                                   System.out.println("Введите описание группы");
                                   String description= sc.nextLine();
                                   groupService.addGroup(new Group(GenId.genGroupId(),name,description,new ArrayList<>(),new ArrayList<>()));
                                   break;
                               case 2:

                                   System.out.println("введите название группы;");
                                   String nameg=sc.nextLine();
                                   System.out.println(groupService.getGroupByName(nameg));
                                   break;
                               case 3:

                                   System.out.println("введите название группы;");
                                   String nameg1=sc.nextLine();
                                   System.out.println("Введите новое название группы");
                                   String newName = sc.nextLine();


                                   groupService.updateGroupByName(nameg1,newName);
                                   break;
                               case 4:

                                   System.out.println("все группы");
                                   System.out.println(groupService.getAllGroups());
                                   break;
                               case 5:

                                   System.out.println("введите название группы");
                                   String nameg2=sc.nextLine();
                                   System.out.println("введите имя ученика");
                                   String names=sc.nextLine();
                                   System.out.println("введите фамилию ученика");
                                   String namesl=sc.nextLine();
                                   System.out.println("введите  email ученика");
                                   String emails=sc.nextLine();
                                   System.out.println("введите пороль");
                                   String passwords=sc.nextLine();
                                   System.out.println("введите пол(Female/Male)");
                                   String gender=sc.nextLine().toUpperCase();
                                   studentService.addStudent(nameg2,new Student(GenId.genStudentId(),names,namesl,emails,passwords,Gender.valueOf(gender)));
                                   break;
                               case 6:

                                   System.out.println("Email: ");
                                   String emailS= sc.nextLine();
                                   System.out.println("Password: ");
                                   String passwordS= sc.nextLine();
                                   System.out.println("firstName: ");
                                   String first= sc.nextLine();
                                   System.out.println("LastName: ");
                                   String last= sc.nextLine();
                                   studentService.updateStudent(emailS,passwordS,first,last);
                                   break;
                               case 7:

                                   System.out.println("firstname:");
                                   String firstname= sc.nextLine();
                                   System.out.println(studentService.findStudentByFirstName(firstname));

                                   break;
                               case 8:

                                   System.out.println("введите название группы");
                                   String groupname= sc.nextLine();
                                   System.out.println(studentService.getAllStudentByGroupName(groupname));
                                   break;
                               case 9:

                                   System.out.println("Email студента: ");
                                   String emailStu= sc.nextLine();
                                   System.out.println(studentService.getAllLessonByStudentEmail(emailStu));

                                   break;
                               case 10:
                                   System.out.println("Email студента: ");
                                   String emailStud= sc.nextLine();
                                   studentService.deleteStudentByEmail(emailStud);
                                   break;
                               case 11:
                                   System.out.println("введите название группы");
                                   String groupnameL= sc.nextLine();
                                   System.out.println("Название урока: ");
                                   String nameless= sc.nextLine();
                                   System.out.println("Описанние урока:");
                                   String descriptionL= sc.nextLine();
                                   lessonService.addNewLessonByGroupsName(groupnameL,new Lesson(GenId.genLessonId(),nameless,descriptionL));
                                   break;
                               case 12:

                                   System.out.println("Введите название урока: ");
                                   String lesson= sc.nextLine();
                                   System.out.println(lessonService.getByLessonName(lesson));
                                   break;
                               case 13:

                                   System.out.println("Введите название группы:");
                                   String groupLesson= sc.nextLine();
                                   System.out.println(lessonService.getAllLessonByGroupName(groupLesson));
                                   break;
                               case 14:

                                   System.out.println("Введите название уроке:");
                                   String lesson1= sc.nextLine();
                                   lessonService.deleteLessonName(lesson1);

                                   break;
                               case 15:

                                   System.out.println("Введите название группы:");
                                   String groupnames= sc.nextLine();
                                   groupService.deleteByName(groupnames);
                                   break;
                               case 0:
                                   System.out.println("Выход из программы. Пока!");
                                   break;
                               default:
                                   System.out.println("Неверный выбор — введите число от 0 до 15.");
                                   break;
                           }
                       } while (choice != 0);

                       sc.close();
                   }
               }
               case 2 ->{
                   System.out.println("введите Email:");
                   String email= sc.nextLine();
                   System.out.println("Новый пороль: ");
                   String newPassword= sc.nextLine();
                   start.updateLogin(email,newPassword);
               }
               }
           }

    }
}