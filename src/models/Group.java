package models;

import java.util.List;
import java.util.Objects;

public class Group {
   private long id;
   private String groupName;
   private String description;
   private List<Lesson>lessons;
   private List<Student>students;

    public Group() {
    }

    public Group(long id, String groupName, String description, List<Lesson> lessons, List<Student> students) {
        this.id = id;
        this.groupName = groupName;
        this.description = description;
        this.lessons = lessons;
        this.students = students;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return id == group.id && Objects.equals(groupName, group.groupName) && Objects.equals(description, group.description) && Objects.equals(lessons, group.lessons) && Objects.equals(students, group.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, groupName, description, lessons, students);
    }

    @Override
    public String toString() {
        System.out.println();
        return "\nGroup{" +
                "\nid=" + id +
                ", \ngroupName='" + groupName + '\'' +
                ", \ndescription='" + description + '\'' +
                ", \nlessons=" + lessons +
                ", \nstudents=" + students +
                '}';
    }
}
