package shop.handle;


import shop.entity.Customer;

import java.util.List;

public class HandleGeneral {
    public void showProducts(List<shop.enity.Product> products) {
        for (shop.enity.Product product : products) {
            product.showInfo();
        }
    }

    public void showOrder(List<shop.enity.Order> orders) {
        for (shop.enity.Order order : orders) {
            order.showInfo();
        }
    }

    public void eidtCustomer(Customer customer) {
        customer.showInfo();
        System.out.println();
    }
}
