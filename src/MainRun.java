import account.entity.User;
import account.handle.HandleAccount;
import account.view.Menu;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import data.HandleFile;
import shop.entity.*;

import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainRun {
    public static void main(String[] args) {
        Shop shop = new Shop();
        Scanner scanner = new Scanner(System.in);
        List<User> users = new ArrayList<>();
        User user1 = new User("hai", "Hải Dương", "hai123@gmail.com", "123");

        Customer user2 = new Customer("tuan", "Hà Nam", "ta456@gmail.com", "123");
        List<Customer> customers = new ArrayList<>();
        customers.add(user2);
        User user3 = new Staff("linh", "Hà Nội", "linh789@gmail.com", "123");
        user2.setBalance(1000);
        user1.setRole("admin");
        user2.setRole("customer");
        user3.setRole("staff");
        users.add(user1);
        users.add(user2);
        users.add(user3);
//        System.out.println(users);
//        List<Staff> staffs = new ArrayList<>();
//        staffs.add((Staff) user3);
//        shop.setStaffs(staffs);
//        List<Customer> customers = new ArrayList<>();
//        customers.add(user2);
//        shop.setCustomers(customers);
        Product product = new Product("iphone", "Cũ", 12, 135, "điệm thoại");
        Product product1 = new Product("tv", "Cũ", 12, 105, "tv thoại");
//        System.out.println(product.getId());
        List<Product> products = new ArrayList<>();
        products.add(product);
        products.add(product1);
        shop.setProducts(products);
        Order order = new Order((Customer) user2);
        List<Order> orders = new ArrayList<>();
//        List<Order> orders1 = new ArrayList<>();
//        orders.add(order);
////        orders1.add(order);
////        user2.setOrders(orders1);
////        shop.setOrders(orders);
//        order.inputInfo(scanner, shop.getProducts());
//        user2.setOrders(orders);
////        Type type = new TypeToken<Shop>() {
////        }.getType();

        Gson gson = new Gson();
        String json = gson.toJson(shop);
        System.out.println(json);
//HandleFile<Shop> handleFile = new HandleFile<>(shop);
//handleFile.saveFile();
        List<Product> products1 = new ArrayList<>();
//        HandleFile<Product> handleFile = new HandleFile<>(product1);
//        handleFile.readFile();

        Shop shop1 = new Shop();
        FileReader reader = null;
        try {
            File file = new File("D:\\Java_Springboot\\ProjectJavaCore1\\src\\data\\shop.json");
            reader = new FileReader(file);
            Type type = new TypeToken<Shop>(){}.getType();
            shop1 = gson.fromJson(reader, type);

        } catch (Exception e) {
            System.out.println("Lỗi dữ liệu");
        } finally {
            try {
                reader.close();
            } catch (Exception e) {
                System.out.println("Lỗi dữ liệu");
            }
        }

        System.out.println(shop1.toString());

//
//        Menu menu = new Menu();
//        HandleAccount handleAccount = new HandleAccount(menu, shop);
//        menu.setHandleAccount(handleAccount);
//        menu.setShop(shop);
//        while (true) {
//            menu.mainMenu(scanner, users);
//            System.out.println(users);
//        }
    }
}
