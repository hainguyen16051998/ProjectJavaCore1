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
        System.out.println("=============Danh sách sản phẩm===========");
        System.out.printf("%10s\t\t\t%10s\t\t\t%10s\t\t\t%10s\t\t%10s\t\t\t%10s\n","ID sản phẩm","Tên sản phẩm","Trạng thái","Số lượng","Giá","Miêu tả");
        for (Product product : products) {
            product.showInfo();
        }
        System.out.println("==========================================");
    }

    default void showOrder(List<Order> orders)throws NullPointerException {
        for (Order order : orders) {
            order.showInfo();
        }
    }
}
