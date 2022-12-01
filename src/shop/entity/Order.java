package shop.entity;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Order {
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

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
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
        System.out.println("Đơn đặt hàng mã số " + this.id + ", được khởi tạo lúc " + this.orderTime);
        System.out.println("Trạng thái đơn hàng: " + this.status);
        System.out.println("Tên khách hàng: " + this.customer.getName());
        System.out.println("Tổng tiền thanh toán: " + this.total);
        //// show Map<Integer, Integer> products ??
    }


    public void inputInfo(Scanner scanner, List<Product> products, Customer customer) {
        double total = 0;// tổng tiền thanh toán
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
                        total += checkQuatity(scanner, p);////chọn số lượng mua
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
            buyMore(scanner, total);// có muốn mua thêm sản phâm không
        }
    }

    //=========================================================================================
    //trả về số nguyên
    public int returnInt(Scanner scanner) {
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

    //kiểm tra số lượng trong kho,tính giá tiền
    public double checkQuatity(Scanner scanner, Product product) {

        System.out.print("Nhập số lượng muốn mua:");
        int quantity;
        while (true) {
            quantity = returnInt(scanner);
            if (quantity <= product.getQuantity()) {
                break;
            }
            System.out.print("Số lượng muốn mua vượt quá số hàng trong kho, vui lòng chọn lại: ");
        }
        product.setQuantity(product.getQuantity() - quantity);
        this.products.put(product.getId(), quantity);
        return quantity * product.getPrice();
    }

    // kiểm tra mua tiếp hay ko
    public void buyMore(Scanner scanner, double total) {
        System.out.println("1. Mua thêm   2. Chốt đơn hàng ");
        int buyMoreChoice;
        while (true) {
            buyMoreChoice = =returnInt(scanner);
            if (buyMoreChoice == 1 || buyMoreChoice == 2) {
                break;
            }
            System.out.print("Chọn lại hợp lệ: ");
        }

        if (buyMoreChoice == 2) {                                   // không mua nữa kết thúc vòng lặp
            this.orderTime = LocalDateTime.now();             //set thời điểm hiện tại khi tạo order mới
            ///  this.status;                                        //status ??
            this.total = total;
            return;
        }
    }
}