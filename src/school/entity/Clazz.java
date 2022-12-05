package school.entity;

import account.entity.IHandleGeneral;

import javax.sound.midi.Soundbank;
import java.util.*;

public class Clazz implements IHandleGeneral {
    private static int autoId = 1;
    private String id;
    private Teacher teacher;
    private List<Student> students;
    private Subject subject;

    public Clazz() {
        this.id = "L" + autoId++;
        this.students = new ArrayList<>();
    }

    public Clazz(String id, Teacher teacher, List<Student> students, Subject subject) {
        this.id = id;
        this.teacher = teacher;
        this.students = students;
        this.subject = subject;
    }

    // tạo lớp
    public void inputInfo(Scanner scanner, School school) {
        if (school.getSubjects() == null || school.getTeachers() == null || school.getStudents() == null) {
            System.out.println("Không có dữ liệu!");
            return;
        }
        //tìm môn học
        while (true) {
            this.subject = findSubject(scanner, school.getSubjects());
            if (this.subject == null) {
                System.out.print("Bạn có muốn tìm môn học khác không (1.yes or 2.No): ");
                if (chooseFunction(scanner, 2, 1) == 2) {
                    return;
                }
                System.out.println("Vui lòng chọn lại môn học!");
            } else
                break;
        }
//tìm giáo viên
        while (true) {
            this.teacher = findTeacher(scanner, school.getTeachers(), school.getClazzes());
            if (this.teacher == null) {
                System.out.print("Bạn có muốn tìm giảng viên khác không (1.yes or 2.No): ");
                if (chooseFunction(scanner, 2, 1) == 2) {
                    return;
                }
                System.out.println("Vui lòng chọn lại giảng viên!");
            } else
                break;
        }
// tìm sinh viên
        while (true) {
            Student student = findStudent(scanner, school.getStudents(), school.getClazzes());
            if (student == null) {
                System.out.print("Bạn có muốn thêm tiếp sinh viên không (1.yes or 2.No): ");
                if (chooseFunction(scanner, 2, 1) == 2) {
                    break;
                }
                System.out.println("Vui lòng chọn lại sinh viên!");

            } else {
                this.students.add(student);
                System.out.print("Bạn có muốn thêm tiếp sinh viên không (1.yes or 2.No): ");
                if (chooseFunction(scanner, 2, 1) == 2) {
                    break;
                }
            }
        }

    }

    // tìm môn học
    public Subject findSubject(Scanner scanner, List<Subject> subjects) {

        System.out.print("Nhập mã môn học: ");
        int id = returnInt(scanner);
        for (Subject s : subjects) {
            if (s.getId() == id) {
                return s;
            }
        }
        System.out.println("Không tìm được môn học");
        return null;
    }

    // tìm giáo viên
    public Teacher findTeacher(Scanner scanner, List<Teacher> teachers, List<Clazz> clazzes) {

        Map<Integer, String> mapSubject = new HashMap<>();
        mapSubject.put(this.subject.getId(), this.subject.getName());
        System.out.print("Nhập mã giảng viên: ");
        int id = returnInt(scanner);
        for (Teacher teacher : teachers) {
            if (teacher.getId() == id) {
                //check chuyên môn
                if (!teacher.getMajor().equals(this.subject.getType())) {
                    System.out.println("Giảng viên không có chuyên môn dạy môn này!");
                    return null;
                }
                // tính số môn đã dạy
                for (Clazz c : clazzes) {
                    if (c.getTeacher().getId() == id) {
                        mapSubject.put(c.getSubject().getId(), c.getSubject().getName());
                    }
                }
                if (mapSubject.size() <= 2) {
                    return teacher;
                }
                System.out.println("Giảng viên chỉ được dạy tối đa 2 môn!");
            }
        }
        System.out.println("Không tìm được giáo viên");
        return null;
    }

    // tìm học sinh
    public Student findStudent(Scanner scanner, List<Student> students, List<Clazz> clazzes) {
        Map<Integer, String> mapSubject = new HashMap<>();
        mapSubject.put(this.subject.getId(), this.subject.getName());
        System.out.print("Nhập mã sinh viên: ");
        int id = returnInt(scanner);
        for (Student student : students) {
            if (student.getId() == id) {
                // đã tìm trong lớp hiện tại chưa
                for (Student t : this.students) {
                    if (t.getId() == id) {
                        System.out.println("Bạn đã thêm sinh viên này rồi");
                        return null;
                    }
                }
                // tính số môn đã học
                for (Clazz c : clazzes) {// check từng lớp
                    for (Student temp : c.getStudents()) {// check từng học sinh trong lớp
                        if (temp.getId() == id) {// học sinh có trong lớp
                            if (c.getSubject().getId() == this.subject.getId()) {// môn này đã học
                                System.out.println("Sinh viên đã học môn này!");
                                return null;
                            }
                            mapSubject.put(c.getSubject().getId(), c.getSubject().getName());
                        }
                    }
                }
                if (mapSubject.size() <= 5) {
                    return student;
                }
                System.out.println("Sinh viên chỉ được dạy tối đa 5 môn!");
            }
        }
        System.out.println("Không tìm được sinh viên");
        return null;
    }

    //    ====
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
