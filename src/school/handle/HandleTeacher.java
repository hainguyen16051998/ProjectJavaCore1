package school.handle;

import account.entity.IHandleGeneral;
import account.entity.User;
import account.handle.HandleAccount;
import school.entity.Clazz;
import school.entity.Student;
import school.entity.Subject;
import school.entity.Teacher;

import java.util.List;
import java.util.Scanner;

public class HandleTeacher implements IHandleGeneral {
    public void showSubject(List<Clazz> clazzes, Teacher teacher) throws NullPointerException {
        if (clazzes==null) {
            System.out.println("Không có dữ liệu");
            return;
        }
        System.out.println("\n===== Danh sách các môn học giảng viên dạy ======");
        System.out.printf("%10s\t\t\t%10s", "Lớp", "Môn học");
        for (Clazz c : clazzes) {
            if (c.getTeacher() == teacher) {    //vòng lặp đi tìm lớp mình dạy
                System.out.printf("%10s\t\t\t%10s\n",c.getId(),c.getSubject().getName());
            }
        }
    }

    public void showStudent(List<Clazz> clazzes, Teacher teacher) throws NullPointerException {
        if (clazzes==null) {
            System.out.println("Không có dữ liệu");
            return;
        }
        System.out.println("\n=====Danh sách học sinh trong lớp thầy giáo " + teacher.getName() + " đảm nhận======");
        for (Clazz c : clazzes) {
            if (c.getTeacher() == teacher) {    //vòng lặp đi tìm lớp mình dạy
                System.out.println("Danh sách học sinh lớp " + c.getId() + ": ");
                System.out.printf("%15s\t\t\t%15s\t\t\t%15s\n", "Mã SV", "Họ tên", "Điểm trung bình");
                for (Student s : c.getStudents()) {
                    System.out.printf("%15s\t\t\t%15s\t\t\t%15s\n", s.getId(), s.getName(), s.getAvgScore());
                }
                System.out.println("-----------");
            }
        }
    }

    public void updateAvgScore(Scanner scanner, List<Clazz> clazzes, Teacher teacher) throws NullPointerException {
        if (clazzes == null) {
            System.out.println("Không có dữ liệu");
            return;
        }
        System.out.println("\n=====Cập nhật điểm học sinh======");
        System.out.print("Chọn mã lớp: ");
        String id = scanner.nextLine();
        while (true) {
            boolean check = false;
            for (Clazz c : clazzes) {
                if (c.getId().equals(id) && teacher == c.getTeacher()) {    //vòng lặp đi tìm lớp cần sửa
                    editScore(scanner, c);
                    check = true;
                }
            }
            if (!check) {
                System.out.print("Mời nhập lại mã lớp thầy giáo phụ trách: ");
                id = scanner.nextLine();
                continue;
            }
            break;
        }
    }

    private void editScore(Scanner scanner, Clazz clazz) throws NullPointerException{
        while (true) {
            System.out.println("1. Sửa điểm");
            System.out.println("2. Kết thúc cập nhật");
            System.out.print("Chọn chức năng: ");
            int choice = chooseFunction(scanner, 2, 1);
            if (choice == 2) {
                return;
            }
            if (choice == 1) {
                System.out.print("Nhập id sinh viên muốn sửa điểm: ");
                int studentId = returnInt(scanner);                        //try - catch

                while (true) {
                    boolean checkId = false;
                    for (Student s : clazz.getStudents()) {                   // tìm trong vòng lặp có student trùng id đã nhập thì set điểm
                        if (s.getId() == studentId) {
                            System.out.print("Nhập điểm mới cho học sinh " + s.getName() + ": ");
//                            double newAvrScore = returnAvg(scanner);     ///check điều kiện từ 0-10 + try catch
                            s.setAvgScore(returnAvg(scanner));
                            checkId = true;
                            break;
                        }
                    }

                    if (!checkId) {                                 // chạy hết vòng lặp for each mà ko có thì cho nhập lại
                        System.out.print("Không có id sinh viên hợp lệ, mời nhập lại: ");
                        studentId = returnInt(scanner);
                        continue;
                    }
                    break;
                }
            }
        }
    }


    public void editTeacher(Scanner scanner, List<User> users, Teacher teacher) throws NullPointerException{
        HandleAccount handleAccount = new HandleAccount();
        teacher.showInfo();
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
                    teacher.setName(scanner.nextLine());
                    continue;
                case 2:
                    System.out.println("============ Sửa địa chỉ ================");
                    System.out.print("Địa chỉ mới: ");
                    teacher.setAddress(scanner.nextLine());
                    continue;
                case 3:
                    System.out.println("============ Sửa SĐT ================");
                    System.out.print("SĐT mới: ");
                    teacher.setPhone(scanner.nextLine());
                    continue;
                case 4:
                    handleAccount.changeEmail(scanner, users, teacher);
                    continue;
                case 5:
                    handleAccount.changePassword(scanner, teacher);
                    continue;
                case 0:
                    return;
            }
        }
    }
}
