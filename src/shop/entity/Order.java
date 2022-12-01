package shop.entity;


import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Order {
    private static int autoID = 1;
    private int id;
    private Date orderTime;
    private String status;
    private double total;
    private Map<Integer, Integer> products;
    private Customer customer;

    public Order() {
        this.id = autoID++;
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
        System.out.println("Tổng số lượng sản phẩm: " + this.total);

        //// show Map<Integer, Integer> products ??
    }


    public void inputInfo(Scanner scanner, List<Product> products, Customer customer) {
        while (true) {
            System.out.print("Nhập id mặt hàng muốn mua: ");
            Integer productId = Integer.parseInt(scanner.nextLine());    ///bổ sung try - catch
            Product product = null;
            while (true) {
                boolean canBuy = false;
                for (Product p : products) {
                    if (productId == p.getId()) {
                        if (p.getQuantity() > 0) {
                            canBuy = true;
                            product = p;
                            break;
                        } else {
                            System.out.println("Mặt hàng đã hết, vui lòng chọn mặt hàng khác.");
                            break;
                        }
                    }
                }
                if (!canBuy) {
                    System.out.print("Nhập lại id mặt hàng muốn mua: ");
                    productId = Integer.parseInt(scanner.nextLine());
                } else {
                    break;
                }
            }

            System.out.print("Nhập số lượng muốn mua cho mặt hàng này:");
            Integer quantity = Integer.parseInt(scanner.nextLine());    ///bổ sung try - catch
            while (true) {
                if (quantity > product.getQuantity()) {
                    System.out.print("Số lượng muốn mua vượt quá số hàng trong kho, vui lòng chọn lại: ");
                    quantity = Integer.parseInt(scanner.nextLine());
                } else {
                    this.total += quantity;                           //số lượng ok thì cộng vào tổng sản phẩm của order
                    break;
                }
            }

            this.products.put(productId, quantity);

            System.out.println("1. Mua thêm   2. Chốt đơn hàng ");
            int buyMoreChoice = Integer.parseInt(scanner.nextLine());    ///bổ sung try - catch
            while (buyMoreChoice < 1 || buyMoreChoice > 2) {
                System.out.print("Chọn lại hợp lệ: ");
                buyMoreChoice = Integer.parseInt(scanner.nextLine());
            }

            if (buyMoreChoice == 1) {                                   // Mua thêm thì chạy lại vòng lặp nhập từ đầu
                continue;
            }
            if (buyMoreChoice == 2) {                                   // không mua nữa kết thúc vòng lặp
                ///  this.orderTime = LocalDateTime.now();             //set thời điểm hiện tại khi tạo order mới
                ///  this.status;                                        //status ??
                this.customer = customer;
                break;
            }
        }
    }


}