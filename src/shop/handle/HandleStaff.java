package shop.handle;

import shop.entity.Order;
import shop.entity.Product;

import java.util.List;
import java.util.Scanner;

public class HandleStaff extends HandleGeneral {


    public void eidtOrder(List<Order> orders, Scanner scanner) {
        System.out.print("Tìm kiếm đơn hàng mã: ");
        int id = returnInt(scanner);
        boolean check = true;
        for (Order order : orders) {
            if (order.getId() == id) {

            }
        }
        if (check) {
            System.out.println("Không tìm thấy!");
        }
    }

    public void editProduct(Scanner scanner, List<Product> products) {
        System.out.print("Tìm kiếm mã sản phẩm: ");
        int id = returnInt(scanner);
        boolean check = true;
        for (Product product : products) {
            if (product.getId() == id) {
                check = false;

                ////chưa viết sửa thông tin
                ///
                ///
            }
        }
        if (check) {
            System.out.println("Không tìm thấy!");
        }
    }

    public int returnInt(Scanner scanner) {
        int id = 0;
        while (true) {
            try {
                id = Integer.parseInt(scanner.nextLine());
                if (id > 0) {
                    break;
                }
            } catch (Exception e) {
                System.out.print("Vui lòng nhập lại: ");
            }
        }
        return id;
    }

    public void addProduct(Scanner scanner, List<Product> products) {
        System.out.print("Nhập số sản phẩm muốn thêm: ");
        int num = returnInt(scanner);
        for (int i = 0; i < num; i++) {
            Product product = new Product();
            product.inputInfo(scanner);
            products.add(product);
        }
    }

    public void removeProduct(Scanner scanner, List<Product> products) {
        System.out.print("Tìm kiếm mã sản phẩm: ");
        int id = returnInt(scanner);
        boolean check = true;
        for (Product product : products) {
            if (product.getId() == id) {
                check = false;
                products.remove(product);
                System.out.println("Đã xóa!");
            }
        }
        if (check) {
            System.out.println("Không tìm thấy!");
        }
    }
}

