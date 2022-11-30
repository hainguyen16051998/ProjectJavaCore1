package shop.handle;

import shop.entity.Customer;
import shop.entity.Order;

import java.util.List;
import java.util.Scanner;

public class HandleStaff extends HandleGeneral {

    public void editCustomer(List<Customer> customers, Scanner scanner) {
        editCustomer(customers.get(0), scanner);
    }

    public void eidtOrder(List<Order> orders, Scanner scanner) {
    }
}
