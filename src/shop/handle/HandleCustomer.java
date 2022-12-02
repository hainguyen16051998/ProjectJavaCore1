package shop.handle;

import account.entity.User;
import account.handle.HandleAccount;
import shop.entity.Customer;
import shop.entity.Order;
import shop.entity.Shop;

import java.util.List;
import java.util.Scanner;

public class HandleCustomer implements IHandle {

    public void addOrder(Scanner scanner, Customer customer, Shop shop) throws NullPointerException {
        Order order = new Order();
        order.inputInfo(scanner, shop.getProducts(), customer);
        if (order.getTotal() > 0) {
            customer.getOrders().add(order);
            shop.getOrders().add(order);
        }
    }


    public void editCustomer(List<User> users, Customer customer, Scanner scanner) {
        HandleAccount handleAccount = new HandleAccount();
        customer.showInfo();
        System.out.println("Thay đổi thông tin");
        System.out.print("Họ tên: ");
        customer.setName(scanner.nextLine());
        System.out.print("Địa chỉ: ");
        customer.setAddress(scanner.nextLine());
        System.out.print("SĐT: ");/// check
        customer.setPhone(scanner.nextLine());
        System.out.print("Email: ");
        handleAccount.changeEmail(scanner, users, customer);
        System.out.print("Password: ");
        handleAccount.changePassword(scanner, customer);

    }
}
