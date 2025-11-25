package models;

import java.util.Objects;

public class Lesson {
    private long id;
    private String lessonName;
    private String lessonDescription;

    public Lesson() {
    }

    public Lesson(long id, String lessonName, String lessonDescription) {
        this.id = id;
        this.lessonName = lessonName;
        this.lessonDescription = lessonDescription;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public String getLessonDescription() {
        return lessonDescription;
    }

    public void setLessonDescription(String lessonDescription) {
        this.lessonDescription = lessonDescription;
    }

    @Override
    public boolean equals(Object o) {

        if (o == null || getClass() != o.getClass()) return false;
        Lesson lesson = (Lesson) o;
        return id == lesson.id && Objects.equals(lessonName, lesson.lessonName) && Objects.equals(lessonDescription, lesson.lessonDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lessonName, lessonDescription);
    }

    @Override
    public String toString() {
        return "\nLesson:" +
                "\nid =" + id +
                ", \nlessonName ='" + lessonName + '\'' +
                ", \nlessonDescription ='" + lessonDescription + '\'' +
                '}';
    }
}
