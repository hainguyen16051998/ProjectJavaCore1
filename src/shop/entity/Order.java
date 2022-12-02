package shop.entity;


import shop.handle.IHandle;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class Order implements IHandle {
    private static int autoID = 1;
    private int id;
    private LocalDateTime orderTime;
    private String status;
    private double total;
    private Map<Integer, Integer> products;
    private Customer customer;

    public Order(Customer customer) {
        this.id = autoID++;
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void showInfo() {
        System.out.println("---------------------- Đơn hàng-----------------------------");
        System.out.println("Đơn đặt hàng mã số " + this.id + ", được khởi tạo lúc " + this.orderTime);
        System.out.println("Trạng thái đơn hàng: " + this.status);
        System.out.println("Tên khách hàng: " + this.customer.getName());
        //// show Map<Integer, Integer> products ??
        System.out.println("Số lượng sản phẩm: ");
        for (Map.Entry<Integer, Integer> entry : products.entrySet()){
            System.out.println("\t\tMã: "+entry.getKey()+" - Số lượng: "+entry.getValue());
        }
        System.out.println("Tổng tiền thanh toán: " + this.total);
    }


    public void inputInfo(Scanner scanner, List<Product> products) {
        double total = 0;// tổng tiền thanh toán
        Map<Integer, Integer> map = new HashMap<>();
        while (true) {
            int productId;
            System.out.print("Nhập id mặt hàng muốn mua: ");
            productId = returnInt(scanner);
            boolean findID = false;
            boolean canBuy = false;
            for (Product p : products) {
                if (productId == p.getId()) {
                    findID = true;
                    if (p.getQuantity() > 0) {
                        total += checkQuatity(scanner, p, map);////chọn số lượng mua
                        break;
                    } else {
                        System.out.println("Mặt hàng đã hết!");
                        break;
                    }
                }
            }
            if (!findID) {
                System.out.print("Không tìm thấy sản phẩm!");
                break;
            }
            if (buyMore(scanner)) {// có muốn mua thêm sản phâm không
                this.total = total;
                this.orderTime = LocalDateTime.now();
                this.products = map;
                break;
            }
        }
    }

    //=========================================================================================

    //kiểm tra số lượng trong kho,tính giá tiền
    public double checkQuatity(Scanner scanner, Product product, Map<Integer, Integer> map) {

        System.out.print("Nhập số lượng muốn mua:");
        int quantity;
        while (true) {
            quantity = returnInt(scanner);
            if (quantity <= product.getQuantity()) {
                break;
            }
            System.out.print("Số lượng muốn mua vượt quá số hàng trong kho, vui lòng chọn lại: ");
        }
        if (this.customer.getBalance() < quantity * product.getPrice()) {
            System.out.println("Tài khoản của bạn không đủ tiền thanh toán!");
            return 0;
        }
        product.setQuantity(product.getQuantity() - quantity); /// trừ số lượng trong kho
        map.put(product.getId(), quantity);// thêm vào list order
        this.customer.setBalance(this.customer.getBalance() - quantity * product.getPrice());// trừ tiền
        return quantity * product.getPrice();// trả vể tổng tiền
    }

    // kiểm tra mua tiếp hay ko
    public boolean buyMore(Scanner scanner) {
        System.out.println("1. Mua thêm   2. Chốt đơn hàng ");
        int buyMoreChoice;
        while (true) {
            buyMoreChoice = returnInt(scanner);
            if (buyMoreChoice == 1 || buyMoreChoice == 2) {
                break;
            }
            System.out.print("Chọn lại hợp lệ: ");
        }

        if (buyMoreChoice == 2) {                                   // không mua nữa kết thúc vòng lặp
            //set thời điểm hiện tại khi tạo order mới
            ///  this.status;                                        //status ??
            return true;
        }
        return false;
    }
}