package school.view;

import account.entity.IHandleGeneral;
import account.entity.User;
import school.entity.Clazz;
import school.entity.School;
import school.entity.Student;
import school.entity.Subject;
import school.handle.HandleStudent;

import java.util.List;
import java.util.Scanner;

public class MenuStudent implements IHandleGeneral {
    private School school;

    public MenuStudent(School school) {
        this.school = school;
    }

    public void showMenu(Scanner scanner, List<User> users, Student student) {
        HandleStudent handleStudent = new HandleStudent();

        while (true) {
            System.out.println("\n========= Xin mời chọn chức năng ========== ");
            System.out.println("1. Xem thông tin các môn học ");
            System.out.println("2. Xem thông tin giảng viên");
            System.out.println("3. Xem và chỉnh sửa thông tin cá nhân ");
            System.out.println("0. Đăng xuất ");
            System.out.print("Chọn chức năng: ");
            int choice = chooseFunction(scanner, 3, 0);
            try {
                switch (choice) {
                    case 1:
                        handleStudent.showSubject(this.school.getSubjects());
                        break;
                    case 2:
                        handleStudent.showTeacher(this.school.getClazzes(),student);
                        break;
                    case 3:
//                        handleStudent.editStudent(scanner, users, student);
                        student.editInfo(users,student,scanner);
                        break;
                    case 0:
                        return;
                }
            } catch (Exception e) {
                System.out.println("Chưa có dữ liệu!");
            }

        }
    }
}
