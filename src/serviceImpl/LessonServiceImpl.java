package serviceImpl;

import DataBase.Db;
import models.Group;
import models.Lesson;
import models.Student;
import service.LessonService;

import java.util.List;

public class LessonServiceImpl implements LessonService {
    @Override
    public void addNewLessonByGroupsName(String groupsName, Lesson lesson) {
        try {
            if (groupsName == null||groupsName.isBlank()) {
                throw new NullPointerException("Название группы не должен быть null!");
            }
            for (Group g:Db.groups){
                for (Student s:g.getStudents()){
                    if (g.getGroupName().equalsIgnoreCase(groupsName)){
                        g.getLessons().add(lesson);
                        s.getLessons().add(lesson);
                    }
                }
            }
            System.out.println("Нету такой группы с таким названием");
            }catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Lesson getByLessonName(String lessonName) {
        try {
            if (lessonName == null||lessonName.isBlank()) {
                throw new NullPointerException("Название  урока не должен быть null!");
            }
            for (Lesson l:Db.lessons){
                if (l.getLessonName().equalsIgnoreCase(lessonName)){
                    return l;
                }
            }
            System.out.println("Нету такой группы с таким названием ");
        }catch (NullPointerException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("(T_T)<(^-^<)");
        }
        return null;
    }

    @Override
    public List<Lesson> getAllLessonByGroupName(String groupName) {
        try {
            if (groupName == null||groupName.isBlank()) {
                throw new NullPointerException("Название группы не должен быть null!");
            }
            for (Group g:Db.groups){
                if (g.getGroupName().equalsIgnoreCase(groupName)){
                    return g.getLessons();
                }
            }
            System.out.println("Нету такой группы с таким названием");
        }catch (NullPointerException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("(T_T)<(^-^<)");
        }
        return List.of();
    }

    @Override
    public void deleteLessonName(String lessonName) {
        try {
            if (lessonName == null||lessonName.isBlank()) {
                throw new NullPointerException("Название  урока не должен быть null!");
            }
           boolean isTrue= Db.lessons.removeIf(lesson -> lesson.getLessonName().equalsIgnoreCase(lessonName));
            for (Group g:Db.groups){
                g.getLessons().removeIf(lesson -> lessonName.equalsIgnoreCase(lesson.getLessonName()));
            }
            if (isTrue){
                System.out.println("Вы успешно удалили урок "+lessonName);
                return;
            }else {
                System.out.println("Нету такого урока");
            }
            }catch (NullPointerException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("(T_T)<(^-^<)");
        }

    }
}
