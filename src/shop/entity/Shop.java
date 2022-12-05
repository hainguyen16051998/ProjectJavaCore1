package shop.entity;

import shop.entity.Customer;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private List<Product> products;
    private List<Staff> staffs;
    private List<Customer> customers;
    private List<Order> orders;

    public Shop() {
        this.customers = new ArrayList<>();
        this.products = new ArrayList<>();
        this.orders = new ArrayList<>();
        this.staffs = new ArrayList<>();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Staff> getStaffs() {
        return staffs;
    }

    public void setStaffs(List<Staff> staffs) {
        this.staffs = staffs;
    }

    // tại sao xem nv bán hàng lại getCustomẻ- vừa sửa lại bị nhầm thầy :)) lát e đổi lại, mà nó ko gọi đk dữ liêu tới, ko hiểu
    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "products=" + products +
                ", staffs=" + staffs +
                ", customers=" + customers +
                ", orders=" + orders +
                '}';
    }
}