package school.entity;

import account.entity.IHandleGeneral;
import account.entity.User;
import school.constant.RoleConstant;

import java.util.Scanner;

public class Student extends User implements IHandleGeneral {
    private double avgScore;

    public double getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(double avgScore) {
        this.avgScore = avgScore;
    }

    public Student() {
        super();
        this.role = RoleConstant.STUDENT.value;
    }

//    @Override
//    public void inputInfo(Scanner scanner) {
//        super.inputInfo(scanner);
////        System.out.print("Nhập điểm trung bình: ");
////        this.avgScore = returnAvg(scanner);
//    }

    public void showInfo() {
        super.showInfo();
        System.out.println("Điểm trung bình: " + this.avgScore);
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
