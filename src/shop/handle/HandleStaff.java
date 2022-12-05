package shop.handle;

import account.entity.IHandleGeneral;
import shop.entity.Order;
import shop.entity.Product;

import java.util.List;
import java.util.Scanner;

public class HandleStaff extends HandleShop implements IHandleGeneral {


//    public void eidtOrder(List<Order> orders, Scanner scanner) throws NullPointerException {
//        System.out.print("Tìm kiếm đơn hàng mã: ");
//        int id = returnInt(scanner);
//        boolean check = true;
//        for (Order order : orders) {
//            if (order.getId() == id) {
//
//            }
//        }
//        if (check) {
//            System.out.println("Không tìm thấy!");
//        }
//    }

    public void editProduct(Scanner scanner, List<Product> products) throws NullPointerException {
        System.out.print("Tìm kiếm mã sản phẩm: ");
        int id = returnInt(scanner);
        boolean check = false;
        for (Product product : products) {
            if (product.getId() == id) {
                check = true;
                product.inputInfo(scanner);
                         }
        }
        if (!check) {
            System.out.println("Không tìm thấy!");
        }
    }


    public void addProduct(Scanner scanner, List<Product> products) throws NullPointerException {
        System.out.print("Nhập số sản phẩm muốn thêm: ");
        int num = returnInt(scanner);
        for (int i = 0; i < num; i++) {
            Product product = new Product();
            product.inputInfo(scanner);
            products.add(product);
        }
    }

    public void removeProduct(Scanner scanner, List<Product> products) throws NullPointerException {
        System.out.print("Tìm kiếm mã sản phẩm: ");
        int id = returnInt(scanner);
        boolean check = true;
        for (Product product : products) {
            if (product.getId() == id) {
                check = false;
                products.remove(product);
                System.out.println("Đã xóa!");
                break;
            }
        }
        if (check) {
            System.out.println("Không tìm thấy!");
        }
    }

}

