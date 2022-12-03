package school.view;

import account.entity.IChooseFunction;
import account.entity.User;
import school.entity.Clazz;
import school.entity.Student;
import school.entity.Subject;
import school.handle.HandleStudent;

import java.util.List;
import java.util.Scanner;

public class MenuStudent implements IChooseFunction {
    public void showMenu(Scanner scanner, List<User> users, List<Clazz> clazzes, List<Subject> subjects, Student student) {
        HandleStudent handleStudent = new HandleStudent();

        while (true) {
            System.out.println("Xin mời chọn chức năng: ");
            System.out.println("1. Xem thông tin các môn học ");
            System.out.println("2. Xem thông tin giảng viên");
            System.out.println("3. Xem và chỉnh sửa thông tin cá nhân ");
            System.out.println("0. Đăng xuất ");
            System.out.print("Chọn chức năng: ");
            int choice = chooseFunction(scanner, 3, 0);
            try {
                switch (choice) {
                    case 1:
                        handleStudent.showSubject(subjects);
                        break;
                    case 2:
                        handleStudent.showTeacher(clazzes,student);
                        break;
                    case 3:
                        handleStudent.editStudent(scanner, users, student);
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
