package school.entity;

import account.entity.IHandleGeneral;
import account.entity.User;
import account.handle.HandleAccount;
import school.constant.SubjectType;

import java.util.List;
import java.util.Scanner;

public class Teacher extends User implements IHandleGeneral {
    private String major;

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Teacher() {
        super();
        this.role = "teacher";
    }


    @Override
    public void inputInfo(Scanner scanner, List<User> users) {
        // nó bị null ở đoạn phone r
        super.inputInfo(scanner, users);
        inputMajor(scanner);
    }

    public void inputMajor(Scanner scanner) {
        System.out.println("Chọn chuyên môn: \n\t1.Tech \n\t2.Bussiness \n\t3.Language ");
        System.out.print("\nChọn: ");
        int majorChoice = chooseFunction(scanner, 3, 1);
        switch (majorChoice) {
            case 1:
                this.major = SubjectType.TECH.value;
                break;
            case 2:
                this.major = SubjectType.BUSINESS.value;
                break;
            case 3:
                this.major = SubjectType.LANGUAGE.value;
                break;
        }
    }

    @Override
    public void editInfo(List<User> users, User user, Scanner scanner) {
        HandleAccount handleAccount = new HandleAccount();
        user.showInfo();
        System.out.println("\nLựa chọn thay đổi thông tin: ");
        while (true) {
            System.out.println("1. Thay đổi họ tên ");
            System.out.println("2. Thay đổi địa chỉ ");
            System.out.println("3. Thay đổi SĐT");
            System.out.println("4. Thay đổi email");
            System.out.println("5. Thay đổi username ");
            System.out.println("6. Thay đổi password");
            System.out.println("7. Thay đổi chuyên môn");
            System.out.println("0. Thoát ");
            System.out.print("Chọn chức năng: ");
            int changeInfoChoice = chooseFunction(scanner, 7, 0);
            switch (changeInfoChoice) {
                case 1:
                    System.out.println("============ Thay đổi họ tên ================");
                    System.out.print("Họ tên mới: ");
                    user.setName(scanner.nextLine());
                    break;
                case 2:
                    System.out.println("============ Thay đổi địa chỉ ================");
                    System.out.print("Địa chỉ mới: ");
                    user.setAddress(scanner.nextLine());
                    break;
                case 3:
                    System.out.println("============ Thay đổi SĐT ================");
                    System.out.print("SĐT mới: ");
                    handleAccount.changePhone(scanner, users, user);
                    break;
                case 4:
                    handleAccount.changeEmail(scanner, users, user);
                    break;
                case 5:
                    handleAccount.changeUsername(scanner, users, user);
                    break;
                case 6:
                    handleAccount.changePassword(scanner, user);
                    break;
                case 7:
                    inputMajor(scanner);
                    break;
                case 0:
                    return;
            }
        }
    }

    public void showInfo() {
        super.showInfo();
        System.out.println("Môn phụ trách " + this.major);
    }

    public Teacher(String username, String name, String email, String password, String major) {
        super(username, name, email, password);
        this.major = major;
    }
}
