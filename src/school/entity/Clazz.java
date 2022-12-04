package school.entity;

import java.util.List;

public class Clazz {

    private String id;
    private Teacher teacher;
    private List<Student> students;
    private Subject subject;

    public Clazz() {

    }

    public Clazz(String id, Teacher teacher, List<Student> students, Subject subject) {
        this.id = id;
        this.teacher = teacher;
        this.students = students;
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "id='" + id + '\'' +
                ", teacher=" + teacher +
                ", students=" + students +
                ", subject=" + subject +
                '}';
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
