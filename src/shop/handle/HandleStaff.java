package shop.handle;

import account.entity.IHandleGeneral;
import account.entity.User;
import shop.entity.Product;
import shop.entity.Shop;
import shop.entity.Staff;

import java.util.List;
import java.util.Scanner;

public class HandleStaff extends HandleShop implements IHandleGeneral {
    private Shop shop;


//    public void eidtOrder(List<Order> orders, Scanner scanner) throws NullPointerException {
//        System.out.print("Tìm kiếm đơn hàng mã: ");
//        int id = returnInt(scanner);
//        boolean check = true;
//        for (Order order : orders) {
//            if (order.getId() == id) {
//
//            }
//        }
//        if (check) {
//            System.out.println("Không tìm thấy!");
//        }
//    }

    public void editProduct(Scanner scanner, List<Product> products) throws NullPointerException {
        System.out.print("Tìm kiếm mã sản phẩm: ");
        int id = returnInt(scanner);
        boolean check = false;
        for (Product product : products) {
            if (product.getId() == id) {
                check = true;
                product.inputInfo(scanner);
                         }
        }
        if (!check) {
            System.out.println("Không tìm thấy!");
        }
    }


    public void addProduct(Scanner scanner, List<Product> products) throws NullPointerException {
        System.out.print("Nhập số sản phẩm muốn thêm: ");
        int num = returnInt(scanner);
        for (int i = 0; i < num; i++) {
            Product product = new Product();
            product.inputInfo(scanner);
            products.add(product);
        }
    }

    public void removeProduct(Scanner scanner, List<Product> products) throws NullPointerException {
        System.out.print("Tìm kiếm mã sản phẩm: ");
        int id = returnInt(scanner);
        boolean check = true;
        for (Product product : products) {
            if (product.getId() == id) {
                check = false;
                products.remove(product);
                System.out.println("Đã xóa!");
                break;
            }
        }
        if (check) {
            System.out.println("Không tìm thấy!");
        }
    }

    public void registerStaff(Scanner scanner, List<User> users) {
        Staff staff = new Staff();
        System.out.println("================ Đăng ký tài khoản Staff ===============");
        staff.setUsername(inputUsername(scanner, users));
        staff.setEmail(inputEmail(scanner, users));
        staff.setPassword(inputPassword(scanner));
        staff.setPhone(inputPhone(scanner,users));
        this.shop.getStaffs().add(staff);
    }


    public String inputPassword(Scanner scanner) {
        String regex = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$";////
        String newPass;
        System.out.print("Password: ");
        while (true) {
            newPass = scanner.nextLine();
            if (!newPass.matches(regex)) {
                System.out.println("Mật khẩu tối thiểu 8 ký tự, gồm chữ cái, số và ký tự đặc biệt: ");
                continue;
            }
            break;
        }
        return newPass;
    }


    /// kiểm tra email
    public String inputEmail(Scanner scanner, List<User> users) {
        String regex = "^([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})$";
        String newMail;
        System.out.print("Email: ");
        while (true) {
            newMail = scanner.nextLine();
            if (!newMail.matches(regex)) {
                System.out.print("Không đúng định dạng! Nhập lại: ");
                continue;
            }
            boolean check = true;
            for (User temp : users) {
                if (temp.getEmail().equals(newMail)) {
                    check = false;
                    System.out.print("Email đã tồn tại! Nhập lại: ");
                    break;
                }
            }
            if (check)
                break;
        }
        return newMail;
    }

    //kiểm tra username
    public String inputUsername(Scanner scanner, List<User> users) {
        String newName;
        System.out.print("Username: ");
        while (true) {
            newName = scanner.nextLine();
            boolean check = true;
            for (User temp : users) {
                if (temp.getUsername().equals(newName)) {
                    check = false;
                    System.out.print("Username đã tồn tại! Nhập lại: ");
                    break;
                }
            }
            if (check)
                break;
        }
        return newName;
    }
    ///kiểm tra sđt
    private String inputPhone(Scanner scanner, List<User> users) {
        String regex = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$";
        String newSĐT;
        System.out.print("SĐT: ");
        while (true) {
            newSĐT = scanner.nextLine();
            if (!newSĐT.matches(regex)) {
                System.out.print("Không đúng định dạng! Nhập lại: ");
                continue;
            }
            boolean check = true;
            for (User temp : users) {
                if (temp.getPhone().equals(newSĐT)) {
                    check = false;
                    System.out.print("SĐT đã tồn tại! Nhập lại: ");
                    break;
                }
            }
            if (check)
                break;
        }
        return newSĐT;
    }
}

