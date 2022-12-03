import account.entity.User;
import account.handle.HandleAccount;
import account.view.Menu;
import com.google.gson.Gson;
import data.HandleFile;
import org.ietf.jgss.GSSContext;
import shop.entity.*;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainRun {
    public static void main(String[] args) throws Exception {
        Shop shop = new Shop();
        Scanner scanner = new Scanner(System.in);
        List<User> users = new ArrayList<>();
        User user1 = new User("hai", "Hải Dương", "hai123@gmail.com", "123");

        Customer user2 = new Customer("tuan", "Hà Nam", "ta456@gmail.com", "123");
        User user3 = new Staff("linh", "Hà Nội", "linh789@gmail.com", "123");
        user2.setBalance(1000);
        user1.setRole("admin");
        user2.setRole("customer");
        user3.setRole("staff");
        users.add(user1);
        users.add(user2);
        users.add(user3);
        System.out.println(users);
        List<Staff> staffs = new ArrayList<>();
        staffs.add((Staff) user3);
        shop.setStaffs(staffs);
        List<Customer> customers = new ArrayList<>();
        customers.add(user2);
        shop.setCustomers(customers);
        Product product = new Product("iphone", "Cũ", 12, 135, "điệm thoại");
        Product product1 = new Product("tv", "Cũ", 12, 105, "tv thoại");
        System.out.println(product.getId());
        List<Product> products = new ArrayList<>();
        products.add(product);
        products.add(product1);
        shop.setProducts(products);
        Order order = new Order((Customer) user2);
        List<Order> orders = new ArrayList<>();
        orders.add(order);
        user2.setOrders(orders);
        shop.setOrders(orders);
        order.inputInfo(scanner, shop.getProducts());

//        Gson gson = new Gson();
//        String json = gson.toJson(orders);
//        System.out.println(json);
//        System.out.println(shop.toString());


        Menu menu = new Menu();
        HandleAccount handleAccount = new HandleAccount(menu, shop);
        menu.setHandleAccount(handleAccount);
        menu.setShop(shop);
        while (true) {
            menu.mainMenu(scanner, users);
            System.out.println(users);
        }
    }
}
