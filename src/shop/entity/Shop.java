package shop.entity;

import shop.entity.Customer;

import java.util.List;

public class Shop {
    private List<shop.entity.Product> products;
    private List<shop.enity.Staff> staffs;
    private List<Customer> customers;
    private List<shop.entity.Order> orders;

    public List<shop.entity.Product> getProducts() {
        return products;
    }

    public void setProducts(List<shop.entity.Product> products) {
        this.products = products;
    }

    public List<shop.enity.Staff> getStaffs() {
        return staffs;
    }

    public void setStaffs(List<shop.enity.Staff> staffs) {
        this.staffs = staffs;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public List<shop.entity.Order> getOrders() {
        return orders;
    }

    public void setOrders(List<shop.entity.Order> orders) {
        this.orders = orders;
    }
}