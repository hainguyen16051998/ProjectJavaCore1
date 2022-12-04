package shop.view;

import account.entity.IChooseFunction;
import account.entity.User;
import shop.entity.Staff;
import shop.entity.Shop;
import shop.handle.HandleStaff;

import java.util.List;
import java.util.Scanner;

public class MenuStaff implements IChooseFunction {
    private Shop shop;

    public MenuStaff(Shop shop) {
        this.shop = shop;
    }

    // hiện thị chức năng được chọn
    public void showMenu(Scanner scanner, List<User> users, User user) {
        HandleStaff handleStaff = new HandleStaff();
        Staff staff = (Staff) user;
        while (true) {
            System.out.println("Xin mời chọn chức năng: ");
            System.out.println("1. Xem danh sách sản phẩm");
            System.out.println("2. Chỉnh sửa thông tin sản phẩm");
            System.out.println("3. Thêm sản phẩm ");
            System.out.println("4. Xóa sản phẩm ");
            System.out.println("5. Xem danh sách đơn hàng ");
            System.out.println("0. Đăng xuất ");
            int choice = chooseFunction(scanner,5,0);
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
                    case 0: // Quay lại  menu đăng nhập
                        return ;
                }
            } catch (Exception e) {
                System.out.println("Chưa có dữ liệu!");
            }

        }
    }
}