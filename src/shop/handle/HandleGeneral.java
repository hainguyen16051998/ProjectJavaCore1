package shop.handle;


import shop.entity.Customer;

import java.util.List;

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

    public void eidtCustomer(Customer customer) {
        customer.showInfo();
        System.out.println();
    }
}
