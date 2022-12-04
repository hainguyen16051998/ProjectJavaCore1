package shop.entity;

import account.entity.IHandleGeneral;
import shop.constant.TypeStatus;


import java.util.Scanner;

public class Product implements IHandleGeneral {
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

//    public Product(String name, String status, int quantity, double price, String description) {
//        this.id = autoID++;
//        this.name = name;
//        this.status = status;
//        this.quantity = quantity;
//        this.price = price;
//        this.description = description;
//    }

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
        System.out.printf("%10s\t\t\t%10s\t\t\t%10s\t\t\t%10s\t\t\t%10s\t\t\t%10s\n",this.id,this.name,this.status,this.quantity,this.price,this.description);
    }

    public void inputInfo(Scanner scanner) {
        System.out.print("Nhập tên mặt hàng: ");
        this.name = scanner.nextLine();
        System.out.print("Nhập trạng thái (1.Mới - 2.Cũ):  ");
        choseStatus(scanner);
        System.out.print("Nhập đơn giá: ");
        inputPrice(scanner);
        System.out.print("Nhập số lượng hàng: ");
        this.quantity = returnInt(scanner);
        System.out.print("Nhập miêu tả sản phẩm: ");
        this.description = scanner.nextLine();
    }

    // chọn trạng thái cũ hay mới
    public void choseStatus(Scanner scanner) {
        int statusChoice = chooseFunction(scanner,2,1);
        if (statusChoice == 1) {
            this.status = TypeStatus.NEW.value;
        } else {
            this.status = TypeStatus.OLD.value;
        }
    }

    public void inputPrice(Scanner scanner) {

        while (true) {
            try {
                this.price = Double.parseDouble(scanner.nextLine());
                if (this.price <= 0) {
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                System.out.print("Vui lòng chọn lại: ");
            }
        }

    }
}