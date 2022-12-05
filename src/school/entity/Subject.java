package school.entity;

import account.entity.IHandleGeneral;
import school.constant.SubjectType;

import java.util.List;
import java.util.Scanner;

public class Subject implements IHandleGeneral {
    private static int autoID = 1;
    private int id;
    private String name;
    private int numberOfCredits;
    private String type;

    public Subject() {
        id = autoID++;
    }


    /// Các môn học sẽ là dữ liệu có sẵn nên ko cần inputInfo phải không?
    public void inputInfo(Scanner scanner, List<Subject> subjects) {
        System.out.print("Tên môn học: ");
        String name = scanner.nextLine();
        if (subjects!=null){
            for (Subject s : subjects) {
                if (s.getName().equals(name)){
                    System.out.println("Môn học đã tồn tại!");
                    return;
                }
            }
        }
        this.name=name;
        System.out.print("Số tín chỉ (<4): ");
        this.numberOfCredits = chooseFunction(scanner, 3, 1);
        System.out.println("Chọn chuyên ngành: \n\t1.Tech \n\t2.Bussiness \n\t3.Language ");
        System.out.print("Chọn: ");
        int majorChoice = chooseFunction(scanner, 3, 1);
        switch (majorChoice) {
            case 1:
                this.type = SubjectType.TECH.value;
                break;
            case 2:
                this.type = SubjectType.BUSINESS.value;
                break;
            case 3:
                this.type = SubjectType.LANGUAGE.value;
                break;
        }
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", numberOfCredits=" + numberOfCredits +
                ", type='" + type + '\'' +
                '}';
    }

    public void showInfo() {
        System.out.printf("%10s\t\t\t%10s\t\t\t%10s\t\t\t%10s\n", this.id, this.name, this.numberOfCredits, this.type);
    }


    public Subject(String name, int numberOfCredits, String type) {
        id = autoID++;
        this.name = name;
        this.numberOfCredits = numberOfCredits;
        this.type = type;
    }


    //    ===================
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfCredits() {
        return numberOfCredits;
    }

    public void setNumberOfCredits(int numberOfCredits) {
        this.numberOfCredits = numberOfCredits;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

