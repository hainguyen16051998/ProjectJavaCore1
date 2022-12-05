package school.handle;

import account.entity.IHandleGeneral;
import account.entity.User;
import account.handle.HandleAccount;
import school.entity.Clazz;
import school.entity.Student;
import school.entity.Subject;

import java.util.List;
import java.util.Scanner;

public class HandleStudent implements IHandleGeneral {
    public void showSubject(List<Subject> subjects) throws NullPointerException {
        System.out.println("\n=====Danh sách các môn học trong trường======");
        System.out.printf("%10s\t\t\t%10s\t\t\t%10s\t\t\t%10s\n", "ID", "Tên môn học", "Số tín chỉ", "Chuyên ngành");
        for (Subject s : subjects) {
            s.showInfo();
        }
    }


    public void showTeacher(List<Clazz> clazzes, Student student) throws NullPointerException {
        if (clazzes==null) {
            System.out.println("Không có dữ liệu");
            return;
        }
        System.out.println("\n=====Danh sách các lớp sinh viên " + student.getName() + " tham gia======");
        for (Clazz c : clazzes) {
            for (Student s : c.getStudents()) {             // tìm từng student trong từng clazz trùng với student đã cho
                if (s == student) { ///
                    System.out.println("Lớp " + c.getSubject().getName() + " do giáo viên " + c.getTeacher().getName() + " dạy.");
                }
            }
        }
    }

    public void editStudent(Scanner scanner, List<User> users, Student student) throws NullPointerException {
        HandleAccount handleAccount = new HandleAccount();
        student.showInfo();
        System.out.println("\nLựa chọn thay đổi thông tin: ");
        while (true) {
            System.out.println("1. Thay đổi họ tên: ");
            System.out.println("2. Thay đổi địa chỉ: ");
            System.out.println("3. Thay đổi SĐT: ");
            System.out.println("4. Thay đổi email: ");
            System.out.println("5. Thay đổi password: ");
            System.out.println("0. Không thay đổi thông tin ");
            System.out.print("Chọn chức năng: ");
            int changeInfoChoice = chooseFunction(scanner, 5, 0);

            switch (changeInfoChoice) {
                case 1:
                    System.out.println("============ Sửa họ tên ================");
                    System.out.print("Họ tên mới: ");
                    student.setName(scanner.nextLine());
                    continue;
                case 2:
                    System.out.println("============ Sửa địa chỉ ================");
                    System.out.print("Địa chỉ mới: ");
                    student.setAddress(scanner.nextLine());
                    continue;
                case 3:
                    System.out.println("============ Sửa SĐT ================");
                    System.out.print("SĐT mới: ");
                    student.setPhone(scanner.nextLine());
                    continue;
                case 4:
                    handleAccount.changeEmail(scanner, users, student);
                    continue;
                case 5:
                    handleAccount.changePassword(scanner, student);
                    continue;
                case 0:
                    return;
            }
        }
    }
}
