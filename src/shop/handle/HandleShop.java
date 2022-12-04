package shop.handle;

import shop.entity.Order;
import shop.entity.Product;

import java.util.List;

public class HandleShop {
    public void showProducts(List<Product> products) throws NullPointerException {
        if (products==null){
            System.out.println("Không có dữ liệu!");
            return;
        }
        System.out.println("=============Danh sách sản phẩm===========");
        System.out.printf("%10s\t\t\t%10s\t\t\t%10s\t\t\t%10s\t\t%10s\t\t\t%10s\n", "ID sản phẩm", "Tên sản phẩm", "Trạng thái", "Số lượng", "Giá", "Miêu tả");
        for (Product product : products) {
            product.showInfo();
        }
        System.out.println("==========================================");
    }

    public void showOrder(List<Order> orders) throws NullPointerException {
        if (orders == null) {
            System.out.println("Không có dữ liệu!");
            return;
        }
        for (Order order : orders) {
            order.showInfo();
        }
    }
}
