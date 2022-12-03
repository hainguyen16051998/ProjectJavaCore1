package shop.handle;

import account.entity.IChooseFunction;
import account.entity.User;
import account.handle.HandleAccount;
import shop.entity.Customer;
import shop.entity.Order;
import shop.entity.Shop;

import java.util.List;
import java.util.Scanner;

public class HandleCustomer implements IHandle, IChooseFunction {

    public void addOrder(Scanner scanner, Customer customer, Shop shop) throws NullPointerException {
        Order order = new Order(customer);
        order.inputInfo(scanner, shop.getProducts());
        if (order.getTotal() > 0) {
            customer.getOrders().add(order);
            shop.getOrders().add(order);
        }
    }


    public void editCustomer(List<User> users, Customer customer, Scanner scanner) {
        HandleAccount handleAccount = new HandleAccount();
        customer.showInfo();
        System.out.println("\nLựa chọn thay đổi thông tin: ");
        while (true) {
            System.out.println("1. Thay đổi họ tên: ");
            System.out.println("2. Thay đổi địa chỉ: ");
            System.out.println("3. Thay đổi SĐT: ");
            System.out.println("4. Thay đổi email: ");
            System.out.println("5. Thay đổi password: ");
            System.out.println("0. Không thay đổi thông tin ");

            int changeInfoChoice = chooseFunction(scanner, 5);

            switch (changeInfoChoice) {
                case 1:
                    System.out.println("============ Sửa họ tên ================");
                    System.out.print("Họ tên mới: ");
                    customer.setName(scanner.nextLine());
                    continue;
                case 2:
                    System.out.println("============ Sửa địa chỉ ================");
                    System.out.print("Địa chỉ mới: ");
                    customer.setAddress(scanner.nextLine());
                    continue;
                case 3:
                    System.out.println("============ Sửa SĐT ================");
                    System.out.print("SĐT mới: ");
                    customer.setPhone(scanner.nextLine());
                    continue;
                case 4:
                    handleAccount.changeEmail(scanner, users, customer);
                    continue;
                case 5:
                    handleAccount.changePassword(scanner, customer);
                    continue;
                case 0:
                    return;
            }
        }
    }
}
