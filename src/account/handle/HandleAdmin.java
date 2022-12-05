package account.handle;

import account.entity.User;
import school.entity.Subject;
import shop.entity.Customer;

import javax.jws.soap.SOAPBinding;
import java.util.List;
import java.util.Scanner;

public class HandleAdmin {
    public void showUser(List<? extends User> list) throws NullPointerException {
        if (list == null) {
            System.out.println("Không có dữ liệu!");
            return;
        }
        for (User user : list) {
            user.showInfo();
        }
    }


    public void editUser(Scanner scanner, List<? extends User> list, List<User> users) throws NullPointerException {
        System.out.print("Nhập username:");
        String username = scanner.nextLine();
        for (User user : list) {
            if (user.getUsername().equals(username)) {
                user.editInfo(users, user, scanner);
                return;
            }
        }

        System.out.println("Không tìm thấy tài khoản!");

    }

    public void removeAccount(Scanner scanner, List<? extends User> list) throws NullPointerException {
        System.out.print("Nhập username:");
        String username = scanner.nextLine();
        for (User user : list) {
            if (user.getUsername().equals(username)) {
                list.remove(user);
                System.out.println("Đã xóa tài khoản!");
                return;
            }
        }

        System.out.println("Không tìm thấy tài khoản!");

    }

    public void showSubject(List<Subject> subjects) {
        if (subjects == null) {
            System.out.println("Không có dữ liệu!");
            return;
        }
        System.out.printf("%10s\t\t\t%10s\t\t\t%10s\t\t\t%10s\n", "Mã Môn học", "Môn học", "Số tính chỉ", "Chuyên ngành");
        for (Subject s : subjects) {
            s.showInfo();
        }
    }
}
