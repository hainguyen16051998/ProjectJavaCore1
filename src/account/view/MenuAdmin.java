package account.view;

import account.entity.IHandleGeneral;
import account.entity.User;
import account.handle.HandleAdmin;
import school.entity.*;
import shop.entity.Shop;
import shop.entity.Staff;

import java.util.List;
import java.util.Scanner;

//import static account.handle.HandleAccount.removeAccount;

public class MenuAdmin implements IHandleGeneral {
    private Shop shop;
    private School school;
    private HandleAdmin handleAdmin;


    //HandleAdmin đã được khởi tạo đâu =]]
    public MenuAdmin(Shop shop, School school) {
        this.shop = shop;
        this.school = school;
        this.handleAdmin = new HandleAdmin();
    }

    public void showMenuManager(Scanner scanner, List<User> users, User user) {

        while (true) {
            System.out.println("===== Xin chào amdin ======");
            System.out.println("1. Thay đổi thông tin tài khoản");
            System.out.println("2. Quản lý bán hàng");
            System.out.println("3. Quản lý giáo dục");
            System.out.println("0. Thoát");
            System.out.print("Mời chọn: ");
            int ch = chooseFunction(scanner, 3, 0);
            switch (ch) {
                case 1:
                    user.editInfo(users, user, scanner);
                    break;
                case 2:
                    viewShopManerger(scanner, users);
                    break;
                case 3:
                    viewSchoolManerger(scanner, users);
                    break;
                case 0:
                    return;

            }
        }
    }

    ///quản lý giáo dục
    private void viewSchoolManerger(Scanner scanner, List<User> users) {

        while (true) {
            // đoạn này phải cho vào menu sau gọi thôi
            System.out.println("===== Quản lý giáo dục ======");
            System.out.println("1. Xem danh sách giảng viên");
            System.out.println("2. Xem sanh sách sinh viên");
            System.out.println("3. Tạo giảng viên mới");
            System.out.println("4. Tạo sinh viên mới");
            System.out.println("5. Chỉnh sửa thông tin giảng viên");
            System.out.println("6. Chỉnh sửa thông tin sinh viên");
            System.out.println("7. Xóa tài khoản giảng viên");
            System.out.println("8. Xóa tài khoản sinh viên");
            System.out.println("9. Thêm môn học");
            System.out.println("10. xem danh sách môn học");
            System.out.println("11. Thêm lớp học");
            System.out.println("0. Thoát");
            System.out.print("Mời chọn: ");
            int ch = chooseFunction(scanner, 11, 0);
            try {
                switch (ch) {
                    case 1:
                        handleAdmin.showUser(this.school.getTeachers());
                        break;
                    case 2:
                        handleAdmin.showUser(this.school.getStudents());
                        break;
                    case 3:
                        Teacher teacher = new Teacher();
                        teacher.inputInfo(scanner, users);
                        this.school.getTeachers().add(teacher);
                        users.add(teacher);
                        break;
                    case 4:
                        Student student = new Student();
                        student.inputInfo(scanner, users);
                        this.school.getStudents().add(student);
                        users.add(student);
                        break;
                    case 5:
                        handleAdmin.editUser(scanner, this.school.getTeachers(), users);
                        break;
                    case 6:
                        handleAdmin.editUser(scanner, this.school.getStudents(), users);
                        break;
                    case 7:
                        handleAdmin.removeAccount(scanner, this.school.getTeachers());
                        break;
                    case 8:
                        handleAdmin.removeAccount(scanner, this.school.getStudents());
                        break;
                    case 9:
                        Subject subject = new Subject();
                        subject.inputInfo(scanner, this.school.getSubjects());
                        this.school.getSubjects().add(subject);
                        break;
                    case 10:
                        handleAdmin.showSubject(this.school.getSubjects());
                        break;
                    case 11:
                        Clazz clazz = new Clazz();
                        clazz.inputInfo(scanner,this.school);
                        this.school.getClazzes().add(clazz);
                        break;
                    case 0:
                        return;

                }
            } catch (Exception e) {
                System.out.println("Chưa có dữ liệu");
            }

        }
    }

    // Quảng lý bán hàng
    private void viewShopManerger(Scanner scanner, List<User> users) {
        while (true) {
            System.out.println("===== Quản lý bán hàng ======");
            System.out.println("1. Xem danh sách nhân viên bán hàng");
            System.out.println("2. Xem sanh sách khách hàng");
            System.out.println("3. Tạo nhân viên mới");
            System.out.println("4. Chỉnh sửa thông tin nhân viên bán hàng");
            System.out.println("5. Chỉnh sửa thông tin khách hàng");
            System.out.println("6. Xóa tài khoản nhân viên");
            System.out.println("7. Xóa tài khoản khách hàng");
            System.out.println("0. Thoát");
            System.out.print("Mời chọn: ");
            try {
                int ch = chooseFunction(scanner, 7, 0);
                switch (ch) {
                    case 1:
                        handleAdmin.showUser(this.shop.getStaffs());
                        break;
                    case 2:
                        handleAdmin.showUser(this.shop.getCustomers());
                        break;
                    case 3:
                        Staff staff = new Staff();
                        staff.inputInfo(scanner, users);
                        this.shop.getStaffs().add(staff);
                        users.add(staff);
                        break;
                    case 4:
                        handleAdmin.editUser(scanner, this.shop.getStaffs(), users);
                        break;
                    case 5:
                        handleAdmin.editUser(scanner, this.shop.getCustomers(), users);
                        break;
                    case 6:
                        handleAdmin.removeAccount(scanner, this.shop.getStaffs());
                        break;
                    case 7:
                        handleAdmin.removeAccount(scanner, this.shop.getCustomers());
                        break;
                    case 0:
                        return;

                }

            } catch (Exception e) {
                System.out.println("Chưa có dữ liệu");
            }

        }

    }
}



