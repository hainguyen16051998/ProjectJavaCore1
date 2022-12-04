package school.entity;

import account.entity.IHandleGeneral;
import account.entity.User;
import school.constant.RoleConstant;
import school.constant.SubjectType;

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
        this.role = RoleConstant.TEACHER.value;
    }


    @Override
    public void inputInfo(Scanner scanner) {
       super.inputInfo(scanner);
        System.out.print("Chọn chuyên môn: \n\t1.Tech \n\t2.Bussiness \n\t3.Language ");
        System.out.print("Chọn: ");
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

    public void showInfo() {
        super.showInfo();
        System.out.println("Môn phụ trách " + this.major);
    }

    public Teacher(String username, String name, String email, String password, String major) {
        super(username, name, email, password);
        this.major = major;
    }
}
