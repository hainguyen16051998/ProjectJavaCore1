package school.view;

import account.entity.IChooseFunction;
import account.entity.User;
import school.entity.Clazz;
import school.entity.Subject;
import school.entity.Teacher;
import school.handle.HandleStudent;
import school.handle.HandleTeacher;
import shop.entity.Customer;
import shop.handle.HandleCustomer;

import java.util.List;
import java.util.Scanner;

public class MenuTeacher implements IChooseFunction {
    public void showMenu(Scanner scanner, List<User> users, List<Subject> subjects, List<Clazz> clazzes, Teacher teacher) {
        HandleTeacher handleTeacher = new HandleTeacher();

        while (true) {
            System.out.println("Xin mời chọn chức năng: ");
            System.out.println("1. Xem thông tin các môn học ");
            System.out.println("2. Xem thông tin học viên");
            System.out.println("3. Chỉnh sửa điểm học viên ");
            System.out.println("4. Xem và chỉnh sửa thông tin cá nhân ");
            System.out.println("0. Đăng xuất ");
            System.out.print("Chọn chức năng: ");
            int choice = chooseFunction(scanner, 4, 0);
            try {
                switch (choice) {
                    case 1:
                        handleTeacher.showSubject(subjects);               // teacher và student đều có cái này, có nên gộp chung ko?
                        break;
                    case 2:
                        handleTeacher.showStudent(clazzes, teacher);
                        break;
                    case 3:
                        handleTeacher.updateAvgScore(scanner, clazzes, teacher);
                        break;
                    case 4:
                        handleTeacher.editTeacher(scanner, users, teacher);
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

