package school.entity;

import java.util.List;

public class Clazz {
    private Teacher teacher;
    private List<Student> students;
    private Subject subject;

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

    public Clazz(Teacher teacher, List<Student> students, Subject subject) {
        this.teacher = teacher;
        this.students = students;
        this.subject = subject;
    }
}
