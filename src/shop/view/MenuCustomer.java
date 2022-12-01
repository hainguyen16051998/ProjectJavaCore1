package shop.view;

import shop.handle.HandleCustomer;

import java.util.Scanner;

public class MenuCustomer {
    HandleCustomer handleCustomer = new HandleCustomer();

    /// hiện thị chức năng được chọn
    public void showMenu(Scanner scanner) {
        while (true){
            System.out.println("Xin mời chọn chức năng ");
            System.out.println("1. Xem thông tin tất cả sản phẩm trong shop ");
            System.out.println("2. Tạo đơn đặt hàng mới ");
            System.out.println("3. Xem thông tin đơn hàng của bạn ");
            System.out.println("4. Xem và chỉnh sửa thông tin cá nhân ");
            System.out.println("0. Đăng xuất ");
            chooseFunction(scanner);
        }

    }

    //// Chọn chức năng
    public void chooseFunction(Scanner scanner) {

        System.out.print("Chọn chức năng: ");
        int choice;
        while (true) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice < 0 || choice > 4) {
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                System.out.print("Vui lòng chọn chức năng hợp lệ: ");
            }
        }

        switch (choice) {
            case 1:
//                handleCustomer.showProducts();
                break;
            case 2:
                handleCustomer.addOrder();
                break;
            case 3:
//                handleCustomer.showOrder();
                break;
            case 4:
//                handleCustomer.eidtCustomer();
                break;
            case 0: // Quay lại  menu đăng nhập
                return;
        }
    }
}