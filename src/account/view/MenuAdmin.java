package account.view;

import account.entity.IHandleGeneral;
import account.entity.User;
import school.entity.Clazz;
import school.entity.Student;
import school.entity.Subject;
import school.entity.Teacher;
import school.handle.HandleStudent;
import school.handle.HandleTeacher;
import shop.entity.Shop;
import shop.handle.HandleStaff;

import java.util.List;
import java.util.Scanner;

//import static account.handle.HandleAccount.removeAccount;

public class MenuAdmin implements IHandleGeneral {
    private Shop shop;
    private Menu menu;
    private User user;

    public MenuAdmin(Shop shop) {
        this.shop = shop;

    }

    public void showMenu(Scanner scanner, List<User> users, User user, Subject clazzes, Clazz subjects, Teacher teacher, Student student) {
        System.out.println("===== Xin chào quản trị viên ======");
        System.out.println("1.Truy cập mảng bán hàng");
        System.out.println("2.Truy cập mảng giáo dục");
        System.out.println("0.Thoát");
        int ch = chooseFunction(scanner, 2, 0);
        switch (ch) {
            case 1:
                showMenuManagerShop(scanner, users, user);
                break;
            case 2:
                showMenuManagerEducation(scanner, users, user, clazzes, subjects, teacher, student );
                break;
            case 3:
                return;
        }
    }

    private void showMenuManagerEducation(Scanner scanner, List<User> users, User user, Clazz clazzes, Subject subjects, Teacher teacher, Student student) {
        HandleStudent student1 = new HandleStudent();
        HandleTeacher teacher1 = new HandleTeacher();
        System.out.println("===== Xin chào quản trị viên ======");
        System.out.println("1. Chỉnh sửa tài khoản Teacher");
        System.out.println("2. Chỉnh sửa tài khoản Student");
        System.out.println("3. Xóa tài khoản ");
        System.out.println("0. Thoát");
        int ch = chooseFunction(scanner, 3, 0);
        switch (ch) {
            case 1:
                teacher1.editTeacher(scanner, users, teacher);
                break;
            case 2:
                student1.editStudent(scanner, users, student);
                break;
            case 3:
                viewChangeInfoStaff(scanner, users, user);
                break;
            case 0:
                return;
        }

    }

    public void showMenuManagerShop(Scanner scanner, List<User> users, User user) {
        System.out.println("===== Xin chào quản trị viên ======");
        System.out.println("1. Chỉnh sửa tài khoản Admin");
        System.out.println("2. Thêm tài khoảng Staff");
        System.out.println("3. Chỉnh sửa tài khoản Staff");
        System.out.println("4. Chỉnh sửa tài khoản Cutstomer");
        System.out.println("5. Xóa tài khoản ");
        System.out.println("0. Thoát");
        int ch = chooseFunction(scanner, 5, 0);
        switch (ch) {
            case 1:
                viewChangeInfoAdmin(scanner, users, user);
                break;
            case 2:
                HandleStaff handleStaff = new HandleStaff();
                handleStaff.registerStaff(scanner, users);
                break;
            case 3:
                viewChangeInfoStaff(scanner, users, user);
                break;
            case 4:
                viewChangeInfoCustomer(scanner, users, user);
                break;
            case 5:
                removeAccount(scanner, users, user);
                break;
            case 0:
                return;
        }

    }

    //vẫn đang check
    private void removeAccount(Scanner scanner, List<User> users, User user) {
        System.out.print("Nhập Username muốn xóa: ");
        String username = scanner.nextLine();
        for (User user1 : users) {
            if (user1.getUsername().equals("hai")) {
                System.out.println("K thể xóa tk Admin");
                removeAccount(scanner, users, user);
            } else {
                break;
            }
            if (user1.getUsername().equals(username)) {
                users.remove(user1);
            } else {
                System.out.println("Không tồn tại username này: ");
                removeAccount(scanner, users, user);
            }
        }
    }


    private void viewChangeInfoAdmin(Scanner scanner, List<User> users, User user) {
        while (true) {
            System.out.println("===================== Thay đổi thông tin Admin  =============================");
            System.out.println("1. Thay đổi username");
            System.out.println("2. Thay đổi mật khẩu");
            System.out.println("3. Thay đổi email");
            System.out.println("4. Thay đổi số điện thoại");
            System.out.println("0. Thoát");
            System.out.print("Mời chọn: ");
            int ch = chooseFunction(scanner, 4, 0);
            switch (ch) {
                case 1:
                    changeUsernameAdmin(scanner, users, user);
                    break;
                case 2:
                    changePasswordAdmin(scanner, users, user);
                    break;
                case 3:
                    changeEmailAdmin(scanner, users, user);
                    break;
                case 4:
                    changePhoneAdmin(scanner, users, user);
                case 5:
                    showMenuManagerShop(scanner, users, user);
            }
        }
    }


    public void viewChangeInfoCustomer(Scanner scanner, List<User> users, User user) {
        while (true) {
            System.out.println("===================== Thay đổi thông tin Customer =============================");
            System.out.println("1. Thay đổi username");
            System.out.println("2. Thay đổi mật khẩu");
            System.out.println("3. Thay đổi email");
            System.out.println("4. Thay đổi số điện thoại");
            System.out.println("0. Thoát");
            System.out.print("Mời chọn: ");
            int ch = chooseFunction(scanner, 4, 0);
            switch (ch) {
                case 1:
                    changeUsernameCustomer(scanner, users, user);
                    break;
                case 2:
                    changePasswordCustomer(scanner, users, user);
                    break;
                case 3:
                    changeEmailCustomer(scanner, users, user);
                    break;
                case 4:
                    changePhoneCustomer(scanner, users, user);
                case 0:
                    showMenuManagerShop(scanner, users, user);
            }
        }
    }

    public void viewChangeInfoStaff(Scanner scanner, List<User> users, User user) {
        while (true) {
            System.out.println("===================== Thay đổi thông tin Staff =============================");
            System.out.println("1. Thay đổi username");
            System.out.println("2. Thay đổi mật khẩu");
            System.out.println("3. Thay đổi email");
            System.out.println("4. Thay đổi số điện thoại");
            System.out.println("0. Thoát");
            System.out.print("Mời chọn: ");
            int ch = chooseFunction(scanner, 4, 0);
            switch (ch) {
                case 1:
                    changeUsernameStaff(scanner, users, user);
                    break;
                case 2:
                    changePasswordStaff(scanner, users, user);
                    break;
                case 3:
                    changeEmailStaff(scanner, users, user);
                    break;
                case 4:
                    changePhoneStaff(scanner, users, user);
                case 0:
                    showMenuManagerShop(scanner, users, user);
            }
        }
    }

    public void changeUsernameAdmin(Scanner scanner, List<User> users, User user) {
        System.out.print("Nhập tên username mới: ");
        String newUsername = scanner.nextLine();
        for (User user1 : users) {
            if (!user1.getUsername().equals(newUsername)) {
                if (user1.getRole().equals("admin")) {
                    user1.setUsername(newUsername);
                    System.out.println(user);
                    break;
                }
            }
        }
        System.out.println("Username mới phải khác Username cũ, nhập lại: ");

    }

    public void changePasswordAdmin(Scanner scanner, List<User> users, User user) {
        String regex = "^(?=.*[A-Z])(?=.*[\\.;\\,_-])\\S{7,15}$";
        String newPassword;
        do {
            System.out.print("Nhập password mới: ");
            newPassword = scanner.nextLine();
            if (newPassword.matches(regex)) {
                break;
            }
            System.out.println("Mật khẩu dài 7-15 ký tự, chứa ít nhất 1 ký tự in hoa, 1 ký tự đặc biệt (. , - _ ;)! ");
        } while (true);
        for (User user1 : users) {
            if (!user1.getPassword().equals(newPassword)) {
                if (user1.getRole().equals("admin")) {
                    user1.setPassword(newPassword);
                    System.out.println(user);
                    break;
                }
                System.out.println("Mật khẩu mới phải khác mật khẩu cũ, nhập lại: ");
            }
        }

    }

    public void changeEmailAdmin(Scanner scanner, List<User> users, User user) {
        String regex = "^(?=.*[A-Z])(?=.*[\\.;\\,_-])\\S{7,15}$";
        String newEmail;
        do {
            System.out.print("Nhập Email mới: ");
            newEmail = scanner.nextLine();
            if (newEmail.matches(regex)) {
                break;
            }
            System.out.println("Email dài 7-15 ký tự, chứa ít nhất 1 ký tự in hoa, 1 ký tự đặc biệt (. , - _ ;)! ");
        } while (true);
        for (User user1 : users) {
            if (!user1.getEmail().equals(newEmail)) {
                if (user1.getRole().equals("admin")) {
                    user1.setEmail(newEmail);
                    System.out.println(user);
                    break;
                }
                System.out.println("Email mới phải khác mật khẩu cũ, nhập lại: ");
            }
        }
    }

    public void changePhoneAdmin(Scanner scanner, List<User> users, User user) {
        System.out.print("Nhập SDT mới: ");
        String newPhone = scanner.nextLine();
        for (User user1 : users) {
            if (!user1.getPhone().equals(newPhone)) {
                if (user1.getRole().equals("admin")) {
                    user1.setPhone(newPhone);
                    System.out.println(user);
                    break;
                }
            }
            System.out.println("SĐT mới phải khác SĐT cũ, nhập lại: ");
        }

    }

    public void changeUsernameStaff(Scanner scanner, List<User> users, User user) {
        System.out.print("Nhập tên username mới: ");
        String newUsername = scanner.nextLine();
        for (User user1 : users) {
            if (!user1.getUsername().equals(newUsername)) {
                if (user1.getRole().equals("staff")) {
                    user1.setUsername(newUsername);
                    System.out.println(user1);
                    break;
                }
            }
        }
        System.out.println("Username mới phải khác Username cũ, nhập lại: ");

    }

    public void changePasswordStaff(Scanner scanner, List<User> users, User user) {
        String regex = "^(?=.*[A-Z])(?=.*[\\.;\\,_-])\\S{7,15}$";
        String newPassword;
        do {
            System.out.print("Nhập password mới: ");
            newPassword = scanner.nextLine();
            if (newPassword.matches(regex)) {
                break;
            }
            System.out.println("Mật khẩu dài 7-15 ký tự, chứa ít nhất 1 ký tự in hoa, 1 ký tự đặc biệt (. , - _ ;)! ");
        } while (true);
        for (User user1 : users) {
            if (!user1.getPassword().equals(newPassword)) {
                if (user1.getRole().equals("staff")) {
                    user1.setPassword(newPassword);
                    System.out.println(user1);
                    break;
                }
                System.out.println("Mật khẩu mới phải khác mật khẩu cũ, nhập lại: ");
            }
        }

    }

    public void changeEmailStaff(Scanner scanner, List<User> users, User user) {
        String regex = "^(?=.*[A-Z])(?=.*[\\.;\\,_-])\\S{7,15}$";
        String newEmail;
        do {
            System.out.print("Nhập Email mới: ");
            newEmail = scanner.nextLine();
            if (newEmail.matches(regex)) {
                break;
            }
            System.out.println("Email dài 7-15 ký tự, chứa ít nhất 1 ký tự in hoa, 1 ký tự đặc biệt (. , - _ ;)! ");
        } while (true);
        for (User user1 : users) {
            if (!user1.getEmail().equals(newEmail)) {
                if (user1.getRole().equals("staff")) {
                    user1.setEmail(newEmail);
                    System.out.println(user1);
                    break;
                }
                System.out.println("Email mới phải khác mật khẩu cũ, nhập lại: ");
            }
        }
    }

    public void changePhoneStaff(Scanner scanner, List<User> users, User user) {
        System.out.print("Nhập SDT mới: ");
        String newPhone = scanner.nextLine();
        for (User user1 : users) {
            if (!user1.getPhone().equals(newPhone)) {
                if (user1.getRole().equals("staff")) {
                    user1.setPhone(newPhone);
                    System.out.println(user1);
                    break;
                }
            }
            System.out.println("SĐT mới phải khác SĐT cũ, nhập lại: ");
        }

    }

    public void changeUsernameCustomer(Scanner scanner, List<User> users, User user) {
        System.out.print("Nhập tên username mới: ");
        String newUsername = scanner.nextLine();
        for (User user1 : users) {
            if (!user1.getUsername().equals(newUsername)) {
                if (user1.getRole().equals("customer")) {
                    user1.setUsername(newUsername);
                    System.out.println(user1);
                    break;
                }
            }
        }
        System.out.println("Username mới phải khác Username cũ, nhập lại: ");

    }

    public void changePasswordCustomer(Scanner scanner, List<User> users, User user) {
        String regex = "^(?=.*[A-Z])(?=.*[\\.;\\,_-])\\S{7,15}$";
        String newPassword;
        do {
            System.out.print("Nhập password mới: ");
            newPassword = scanner.nextLine();
            if (newPassword.matches(regex)) {
                break;
            }
            System.out.println("Mật khẩu dài 7-15 ký tự, chứa ít nhất 1 ký tự in hoa, 1 ký tự đặc biệt (. , - _ ;)! ");
        } while (true);
        for (User user1 : users) {
            if (!user1.getPassword().equals(newPassword)) {
                if (user1.getRole().equals("customer")) {
                    user1.setPassword(newPassword);
                    System.out.println(user1);
                    break;
                }
                System.out.println("Mật khẩu mới phải khác mật khẩu cũ, nhập lại: ");
            }
        }

    }

    public void changeEmailCustomer(Scanner scanner, List<User> users, User user) {
        String regex = "^(?=.*[A-Z])(?=.*[\\.;\\,_-])\\S{7,15}$";
        String newEmail;
        do {
            System.out.print("Nhập Email mới: ");
            newEmail = scanner.nextLine();
            if (newEmail.matches(regex)) {
                break;
            }
            System.out.println("Email dài 7-15 ký tự, chứa ít nhất 1 ký tự in hoa, 1 ký tự đặc biệt (. , - _ ;)! ");
        } while (true);
        for (User user1 : users) {
            if (!user1.getEmail().equals(newEmail)) {
                if (user1.getRole().equals("customer")) {
                    user1.setEmail(newEmail);
                    System.out.println(user1);
                    break;
                }
                System.out.println("Email mới phải khác mật khẩu cũ, nhập lại: ");
            }
        }
    }

    public void changePhoneCustomer(Scanner scanner, List<User> users, User user) {
        System.out.print("Nhập SDT mới: ");
        String newPhone = scanner.nextLine();
        for (User user1 : users) {
            if (!user1.getPhone().equals(newPhone)) {
                if (user1.getRole().equals("customer")) {
                    user1.setPhone(newPhone);
                    System.out.println(user1);
                    break;
                }
            }
            System.out.println("SĐT mới phải khác SĐT cũ, nhập lại: ");
        }

    }
}




