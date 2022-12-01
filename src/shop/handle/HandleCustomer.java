package shop.handle;

import shop.entity.Customer;
import shop.entity.Order;
import shop.entity.Shop;

import java.util.List;
import java.util.Scanner;

public class HandleCustomer extends HandleGeneral {

    public void addOrder(Scanner scanner, Customer customer, Shop shop) {
        Order order = new Order();
        order.inputInfo(scanner, shop.getProducts(), customer);
        customer.getOrders().add(order);
        shop.getOrders().add(order);
    }


    public void editCustomer(Customer customer, Scanner scanner) {
        customer.showInfo();
        System.out.println("Thay đổi thông tin");
        System.out.print("Họ tên: ");
        customer.setName(scanner.nextLine());
        System.out.print("Địa chỉ: ");
        customer.setAddress(scanner.nextLine());
        System.out.print("SĐT: ");
        customer.setPhone(scanner.nextLine());
        System.out.print("Email: ");
        customer.setEmail(scanner.nextLine());
        System.out.print("Password: ");
        customer.setPassword(scanner.nextLine());

    }
}
