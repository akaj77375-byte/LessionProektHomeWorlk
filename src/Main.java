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
        LessonService lessonService = new LessonServiceImpl();
        Start start = new StartImpl();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println(start.times());
            System.out.println("Если уже есть акаунт тогда 1, если забыли пароль 2");
            int san = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (san) {
                case 1 -> {
                    System.out.println("Введите email:");
                    String email = sc.nextLine();
                    System.out.println("Введите пароль:");
                    String password = sc.nextLine();

                    if (start.login(email, password)) {
                        int choice = 0;
                        do {
                            System.out.println("\nВыберите команду:");
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
                                sc.nextLine(); // consume newline
                            } else {
                                System.out.println("Неверный ввод — введите число.");
                                sc.nextLine();
                                continue;
                            }

                            switch (choice) {
                                case 1 -> { // Add new group
                                    System.out.println("Введите название группы:");
                                    String name = sc.nextLine().trim();
                                    if (name.isEmpty()) {
                                        System.out.println("Название группы не может быть пустым!");
                                        break;
                                    }
                                    System.out.println("Введите описание группы:");
                                    String description = sc.nextLine().trim();
                                    groupService.addGroup(new Group(GenId.genGroupId(), name, description, new ArrayList<>(), new ArrayList<>()));
                                }
                                case 2 -> { // Get group by name
                                    while (true) {
                                        System.out.println("Введите название группы:");
                                        String nameg = sc.nextLine().trim();
                                        if (nameg.isEmpty()) {
                                            System.out.println("Название группы не может быть пустым!");
                                            continue;
                                        }
                                        Group groupByName = groupService.getGroupByName(nameg);
                                        if (groupByName == null) {
                                            System.out.println("Группа с таким названием не найдена!");
                                            continue;
                                        }
                                        System.out.println(groupByName);
                                        break;
                                    }
                                }
                                case 3 -> { // Update group name
                                    while (true) {
                                        System.out.println("Введите название группы:");
                                        String nameg1 = sc.nextLine().trim();
                                        if (nameg1.isEmpty()) {
                                            System.out.println("Название группы не может быть пустым!");
                                            continue;
                                        }
                                        Group groupByName = groupService.getGroupByName(nameg1);
                                        if (groupByName == null) {
                                            System.out.println("Группа с таким названием не найдена!");
                                            continue;
                                        }
                                        System.out.println("Введите новое название группы:");
                                        String newName = sc.nextLine().trim();
                                        if (newName.isEmpty()) {
                                            System.out.println("Новое название группы не может быть пустым!");
                                            continue;
                                        }
                                        groupService.updateGroupByName(nameg1, newName);
                                        System.out.println("Группа обновлена!");
                                        break;
                                    }
                                }
                                case 4 -> System.out.println("Все группы:\n" + groupService.getAllGroups());

                                case 5 -> { // Add new student to group
                                    while (true) {
                                        System.out.println("Введите название группы:");
                                        String nameg2 = sc.nextLine().trim();
                                        if (nameg2.isEmpty()) {
                                            System.out.println("Название группы не может быть пустым!");
                                            continue;
                                        }
                                        Group groupByName = groupService.getGroupByName(nameg2);
                                        if (groupByName == null) {
                                            System.out.println("Группа с таким названием не найдена!");
                                            continue;
                                        }
                                        System.out.println("Введите имя ученика:");
                                        String names = sc.nextLine().trim();
                                        System.out.println("Введите фамилию ученика:");
                                        String namesl = sc.nextLine().trim();
                                        System.out.println("Введите email ученика:");
                                        String emails = sc.nextLine().trim();
                                        System.out.println("Введите пароль:");
                                        String passwords = sc.nextLine().trim();
                                        System.out.println("Введите пол (Female/Male):");
                                        String gender = sc.nextLine().trim().toUpperCase();

                                        studentService.addStudent(nameg2,
                                                new Student(GenId.genStudentId(), names, namesl, emails, passwords, Gender.valueOf(gender)));
                                        break;
                                    }
                                }
                                case 6 -> { // Update student
                                    System.out.println("Email:");
                                    String emailS = sc.nextLine();
                                    System.out.println("Password:");
                                    String passwordS = sc.nextLine();
                                    System.out.println("FirstName:");
                                    String first = sc.nextLine();
                                    System.out.println("LastName:");
                                    String last = sc.nextLine();
                                    studentService.updateStudent(emailS, passwordS, first, last);
                                }
                                case 7 -> { // Find student by first name
                                    System.out.println("FirstName:");
                                    String firstname = sc.nextLine();
                                    System.out.println(studentService.findStudentByFirstName(firstname));
                                }
                                case 8 -> { // Get all students by group name
                                    while (true) {
                                        System.out.println("Введите название группы:");
                                        String groupname = sc.nextLine().trim();
                                        if (groupname.isEmpty()) {
                                            System.out.println("Название группы не может быть пустым!");
                                            continue;
                                        }
                                        Group groupByName = groupService.getGroupByName(groupname);
                                        if (groupByName == null) {
                                            System.out.println("Группа с таким названием не найдена!");
                                            continue;
                                        }
                                        System.out.println(studentService.getAllStudentByGroupName(groupname));
                                        break;
                                    }
                                }
                                case 9 -> { // Get all lessons by student email
                                    System.out.println("Email студента:");
                                    String emailStu = sc.nextLine();
                                    System.out.println(studentService.getAllLessonByStudentEmail(emailStu));
                                }
                                case 10 -> { // Delete student
                                    System.out.println("Email студента:");
                                    String emailStud = sc.nextLine();
                                    studentService.deleteStudentByEmail(emailStud);
                                }
                                case 11 -> { // Add new lesson to group
                                    while (true) {
                                        System.out.println("Введите название группы:");
                                        String groupnameL = sc.nextLine().trim();
                                        if (groupnameL.isEmpty()) {
                                            System.out.println("Название группы не может быть пустым!");
                                            continue;
                                        }
                                        Group groupByName = groupService.getGroupByName(groupnameL);
                                        if (groupByName == null) {
                                            System.out.println("Группа с таким названием не найдена!");
                                            continue;
                                        }
                                        System.out.println("Название урока:");
                                        String nameless = sc.nextLine().trim();
                                        System.out.println("Описание урока:");
                                        String descriptionL = sc.nextLine().trim();
                                        lessonService.addNewLessonByGroupsName(groupnameL,
                                                new Lesson(GenId.genLessonId(), nameless, descriptionL));
                                        break;
                                    }
                                }
                                case 12 -> { // Get lesson by name
                                    System.out.println("Введите название урока:");
                                    String lesson = sc.nextLine();
                                    System.out.println(lessonService.getByLessonName(lesson));
                                }
                                case 13 -> { // Get all lessons by group name
                                    while (true) {
                                        System.out.println("Введите название группы:");
                                        String groupLesson = sc.nextLine().trim();
                                        if (groupLesson.isEmpty()) {
                                            System.out.println("Название группы не может быть пустым!");
                                            continue;
                                        }
                                        Group groupByName = groupService.getGroupByName(groupLesson);
                                        if (groupByName == null) {
                                            System.out.println("Группа с таким названием не найдена!");
                                            continue;
                                        }
                                        System.out.println(lessonService.getAllLessonByGroupName(groupLesson));
                                        break;
                                    }
                                }
                                case 14 -> { // Delete lesson
                                    System.out.println("Введите название урока:");
                                    String lesson1 = sc.nextLine();
                                    lessonService.deleteLessonName(lesson1);
                                }
                                case 15 -> { // Delete group
                                    while (true) {
                                        System.out.println("Введите название группы:");
                                        String groupnames = sc.nextLine().trim();
                                        if (groupnames.isEmpty()) {
                                            System.out.println("Название группы не может быть пустым!");
                                            continue;
                                        }
                                        Group groupByName = groupService.getGroupByName(groupnames);
                                        if (groupByName == null) {
                                            System.out.println("Группа с таким названием не найдена!");
                                            continue;
                                        }
                                        groupService.deleteByName(groupnames);
                                        System.out.println("Группа удалена!");
                                        break;
                                    }
                                }
                                case 0 -> System.out.println("Выход из программы. Пока!");
                                default -> System.out.println("Неверный выбор — введите число от 0 до 15.");
                            }

                        } while (choice != 0);
                        sc.close();
                    }
                }
                case 2 -> { // Update login password
                    System.out.println("Введите Email:");
                    String email = sc.nextLine();
                    System.out.println("Новый пароль:");
                    String newPassword = sc.nextLine();
                    start.updateLogin(email, newPassword);
                }
                default -> System.out.println("Неверный выбор — введите 1 или 2.");
            }
        }
    }
}