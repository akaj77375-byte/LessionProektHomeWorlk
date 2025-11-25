package service;

import models.Lesson;

import java.util.List;

public interface LessonService {
    void addNewLessonByGroupsName(String groupsName, Lesson lesson);
    Lesson getByLessonName(String lessonName);
    List<Lesson> getAllLessonByGroupName(String groupName);
    void deleteLessonName(String lessonName);
}
