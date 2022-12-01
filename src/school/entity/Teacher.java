package school.entity;

import account.entity.User;
import school.constant.RoleConstant;
import school.constant.SubjectType;

import java.util.Scanner;

public class Teacher extends User {
    private String major;

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Teacher() {
        this.role = RoleConstant.TEACHER.value;
    }

    @Override
    public void inputInfo(Scanner scanner) {
        System.out.print("Chọn phụ trách: 1.Tech 2.Bussiness 3. Language ");
        int majorChoice = Integer.parseInt(scanner.nextLine());

        while (majorChoice < 1 | majorChoice > 3) {
            System.out.print("Chọn lại môn hợp lệ");                             //bổ sung try catch sau
            majorChoice = Integer.parseInt(scanner.nextLine());
        }
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

    public void showInfo(Scanner scanner) {
        System.out.println("Mã tài khoản: " + this.id + ", Email: " + this.email);
        System.out.println("Họ tên: " + this.name + ", địa chỉ" + this.address + ", SĐT: " + this.phone);
        System.out.println("Môn phụ trách " + this.major);
    }
}
