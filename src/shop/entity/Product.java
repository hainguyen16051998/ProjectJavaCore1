package shop.entity;

import account.constant.TypeRole;
import shop.constant.TypeStatus;

import java.util.Scanner;

public class Product {
    private static int autoID = 1;
    private int id;
    private String name;
    private String status;
    private int quantity;
    private double price;
    private String description;

    public Product() {
        this.id = autoID++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }

    public void showInfo() {
        System.out.println("Mã mặt hàng: " + this.id);
        System.out.println("Tên mặt hàng: " + this.name + ", Trạng thái: " + this.status);
        System.out.println("Số lượng: " + this.quantity + ", Giá: " + this.price);
        System.out.println("Miêu tả sản phẩm: " + this.description);
    }


    public void inputInfo(Scanner scanner) {
        System.out.println("Nhập tên mặt hàng: ");
        this.name = scanner.nextLine();
        System.out.print("Nhập trạng thái (1.Mới - 2.Cũ):  ");
        choseStatus(scanner);
        System.out.println("Nhập số lượng hàng: ");
        this.quantity = returnInt(scanner);
        System.out.println("Nhập miêu tả sản phẩm: ");
        this.description = scanner.nextLine();
    }

    // chọn trạng thái cũ hay mới
    public void choseStatus(Scanner scanner) {
        int statusChoice;
        while (true) {
            statusChoice = returnInt(scanner);
            if (statusChoice == 1 || statusChoice == 2) {
                break;
            }
            System.out.print("Vui lòng chọn lại: ");
        }
        if (statusChoice == 1) {
            this.status = TypeStatus.NEW.value;
        } else {
            this.status = TypeStatus.OLD.value;
        }
    }

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
}