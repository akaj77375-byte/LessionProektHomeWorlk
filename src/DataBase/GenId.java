package DataBase;

public class GenId {
    public static Long lessonId = 0L;
    public static Long groupId = 0L;
    public static Long studentId = 0L;

    public static Long genLessonId() {
        return ++lessonId;
    }
    public static long genGroupId(){
        return ++groupId;
    }
    public static long genStudentId(){
        return ++studentId;
    }
}
