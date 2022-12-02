package shop.handle;

import shop.entity.Order;
import shop.entity.Product;

import java.util.List;
import java.util.Scanner;

public interface IHandle {
    //trả về số nguyên
    default int returnInt(Scanner scanner) {
        int n;
        while (true) {
            try {
                n = Integer.parseInt(scanner.nextLine());
                if (n < 1) {
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                System.out.print("Vui lòng nhập lại: ");
            }
        }
        return n;
    }

    default void showProducts(List<Product> products) throws NullPointerException{

        for (Product product : products) {
            product.showInfo();
        }
    }

    default void showOrder(List<Order> orders)throws NullPointerException {
        for (Order order : orders) {
            order.showInfo();
        }
    }
}
