package shop.view;

import account.entity.IChooseFunction;
import account.entity.User;
import shop.entity.Customer;
import shop.entity.Shop;
import shop.handle.HandleCustomer;

import javax.jws.soap.SOAPBinding;
import java.util.List;
import java.util.Scanner;

public class MenuCustomer implements IChooseFunction {

    private Shop shop;

    public MenuCustomer(Shop shop) {
        this.shop = shop;

    }

    /// hiện thị chức năng được chọn
    public void showMenu(Scanner scanner, List<User> users, User user) {
        HandleCustomer handleCustomer = new HandleCustomer();
        Customer customer = (Customer) user;
        while (true) {
            System.out.println("Xin mời chọn chức năng ");
            System.out.println("1. Xem sản phẩm của shop ");
            System.out.println("2. Đặt hàng ");
            System.out.println("3. Xem thông tin đơn hàng của bạn ");
            System.out.println("4. Xem và chỉnh sửa thông tin cá nhân ");
            System.out.println("0. Đăng xuất ");
            System.out.print("Chọn chức năng: ");
            int choice = chooseFunction(scanner, 4,0);
            try {
                switch (choice) {
                    case 1:
                        handleCustomer.showProducts(this.shop.getProducts());
                        break;
                    case 2:
                        handleCustomer.addOrder(scanner, customer, this.shop);
                        break;
                    case 3:
                        handleCustomer.showOrder(customer.getOrders());
                        break;
                    case 4:
                        handleCustomer.editCustomer(users, customer, scanner);
                        break;
                    case 0:
                        return;
                }
            } catch (Exception e) {
                System.out.println("Chưa có dữ liệu!");
            }

        }

    }


}