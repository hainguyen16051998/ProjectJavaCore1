package shop.view;

import account.entity.IHandleGeneral;
import account.entity.User;
import shop.entity.Staff;
import shop.entity.Shop;
import shop.handle.HandleStaff;

import java.util.List;
import java.util.Scanner;

public class MenuStaff implements IHandleGeneral {
    private Shop shop;

    public MenuStaff(Shop shop) {
        this.shop = shop;
    }

    // hiện thị chức năng được chọn
    public void showMenu(Scanner scanner, List<User> users, User user) {
        HandleStaff handleStaff = new HandleStaff();
//        Staff staff = (Staff) user;
        while (true) {
            System.out.println("========== Chức năng của bạn ==========");
            System.out.println("1. Xem danh sách sản phẩm");
            System.out.println("2. Chỉnh sửa thông tin sản phẩm");
            System.out.println("3. Thêm sản phẩm ");
            System.out.println("4. Xóa sản phẩm ");
            System.out.println("5. Xem danh sách đơn hàng ");
            System.out.println("6. Xem và chỉnh sửa thông tin cá nhân ");
            System.out.println("0. Đăng xuất ");
            System.out.print("Chọn chức năng: ");
            int choice = chooseFunction(scanner, 6, 0);
            try {
                switch (choice) {
                    case 1:
                        handleStaff.showProducts(this.shop.getProducts());
                        break;
                    case 2:
                        handleStaff.editProduct(scanner, this.shop.getProducts());
                        break;
                    case 3:
                        handleStaff.addProduct(scanner, this.shop.getProducts());
                        break;
                    case 4:
                        handleStaff.removeProduct(scanner, this.shop.getProducts());
                        break;
                    case 5:
                        handleStaff.showOrder(this.shop.getOrders());
                        break;
                    case 6:
                        user.editInfo(users,user,scanner);
                        break;
                    case 0: // Quay lại  menu đăng nhập
                        return;
                }
            } catch (Exception e) {
                System.out.println("Chưa có dữ liệu!");
            }

        }
    }
}