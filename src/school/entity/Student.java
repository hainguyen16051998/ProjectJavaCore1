package school.entity;

import account.entity.User;
import school.constant.RoleConstant;

import java.util.Scanner;

public class Student extends User {
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
        this.avgScore = Double.parseDouble(scanner.nextLine());
    }

    public void showInfo() {
        System.out.println("Mã tài khoản: " + this.id + ", Email: " + this.email);
        System.out.println("Họ tên: " + this.name + ", địa chỉ" + this.address + ", SĐT: " + this.phone);
        System.out.println("Điểm trung bình " + this.avgScore);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", avgScore=" + avgScore +
                '}';
    }

    // thêm tạm contructor có id để test, sau khi hoàn thiện phần admin có chức năng khởi tạo student sẽ xoá.
    public Student(int id, String username, String name, String email, String password, double avgScore) {
        super(username, name, email, password);
        this.avgScore = avgScore;
        this.id = id;
    }
}
