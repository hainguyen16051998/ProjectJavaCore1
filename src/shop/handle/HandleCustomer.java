package shop.handle;

import account.entity.IHandleGeneral;
import account.entity.User;
import account.handle.HandleAccount;
import shop.entity.Customer;
import shop.entity.Order;
import shop.entity.Shop;

import java.util.List;
import java.util.Scanner;

public class HandleCustomer extends HandleShop {

    public void addOrder(Scanner scanner, Customer customer, Shop shop) throws NullPointerException {
        Order order = new Order(customer);
        order.inputInfo(scanner, shop.getProducts());
        if (order.getTotal() > 0) {
            shop.getOrders().add(order);
        }
    }

    public void showOrder(List<Order> orders, Customer customer) throws NullPointerException {
        if (orders == null) {
            System.out.println("Không có dữ liệu!");
            return;
        }
        int count = 0;
        for (Order order : orders) {
            if (order.getCustomer().equals(customer)) {
                order.showInfo();
                count++;
            }

        }
        if (count==0){
            System.out.println("Bạn không có đơn hàng nào!");
        }
    }

}
