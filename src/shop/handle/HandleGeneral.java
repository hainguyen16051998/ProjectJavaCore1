package shop.handle;


import shop.entity.Customer;

import java.util.List;
import java.util.Scanner;

public class HandleGeneral {
    public void showProducts(List<shop.entity.Product> products) {
        for (shop.entity.Product product : products) {
            product.showInfo();
        }
    }

    public void showOrder(List<shop.entity.Order> orders) {
        for (shop.entity.Order order : orders) {
            order.showInfo();
        }
    }

    public void editCustomer(Customer customer, Scanner scanner) {
        customer.showInfo();
        System.out.println();
    }
}
