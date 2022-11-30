package shop.view;

import shop.enity.Staff;
import shop.entity.Shop;
import shop.handle.HandleStaff;

import java.util.Scanner;

public class menuStaff {
    HandleStaff handleStaff = new HandleStaff();

    // hiện thị chức năng được chọn
    public void showMenu(Scanner scanner, Shop shop, shop.enity.Staff staff) {
        while (true) {
            System.out.println("Xin mời chọn chức năng: ");
            System.out.println("1. Xem danh sách sản phẩm");
            System.out.println("2. Chỉnh sửa thông tin sản phẩm");
            System.out.println("3. Thêm sản phẩm ");
            System.out.println("4. Xóa sản phẩm ");
            System.out.println("5. Xem danh sách đơn hàng ");
            System.out.println("0. Đăng xuất ");
            chooseFunction(scanner, shop, staff);
        }
    }

    //// chọn chức năng
    public void chooseFunction(Scanner scanner, Shop shop, Staff staff) {
        System.out.print("Chọn chức năng: ");
        int choice;
        while (true) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice < 0 || choice > 5) {
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                System.out.print("Vui lòng chọn chức năng hợp lệ: ");
            }
        }

        switch (choice) {
            case 1:
                handleStaff.showProducts(shop.getProducts());
                break;
            case 2:
                handleStaff.editProduct(scanner, shop.getProducts());
                break;
            case 3:
                handleStaff.addProduct(scanner, shop.getProducts());
                break;
            case 4:
                handleStaff.removeProduct(scanner, shop.getProducts());
                break;
            case 5:
                handleStaff.showOrder(shop.getOrders());
                break;
            case 0: // Quay lại  menu đăng nhập
                return;
        }
    }
}