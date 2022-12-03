package school.entity;

import account.entity.IChooseFunction;
import account.entity.User;
import school.constant.RoleConstant;

import java.util.Scanner;

public class Student extends User implements IChooseFunction {
    private double avgScore;

    public double getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(double avgScore) {
        this.avgScore = avgScore;
    }

    public Student() {
        this.role = RoleConstant.STUDENT.value;
    }

    @Override
    public void inputInfo(Scanner scanner) {
        System.out.print("Nhập điểm trung bình: ");
        this.avgScore = returnAvg(scanner);
    }

    public void showInfo(Scanner scanner) {
        System.out.println("Mã tài khoản: " + this.id + ", Email: " + this.email);
        System.out.println("Họ tên: " + this.name + ", địa chỉ" + this.address + ", SĐT: " + this.phone);
        System.out.println("Điểm trung bình " + this.avgScore);
    }

}
