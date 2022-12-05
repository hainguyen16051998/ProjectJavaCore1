import account.entity.User;
import account.handle.HandleAccount;
import account.view.Menu;
import school.entity.Clazz;
import school.entity.Student;
import school.entity.Subject;
import school.entity.Teacher;
import shop.entity.Shop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//import com.google.gson.Gson;
//import com.google.gson.reflect.TypeToken;
//
//import data.HandleFile;

public class MainRun {
    public static void main(String[] args) {
        Shop shop = new Shop();
        Scanner scanner = new Scanner(System.in);
        List<User> users = new ArrayList<>();
        User user1 = new User("hai", "Hải Dương", "hai123@gmail.com", "123");
        user1.setRole("admin");
//
//        Customer user2 = new Customer("customer", "Customer", "customer@gmail.com", "123");
//        shop.getCustomers().add(user2);
//
//        Staff user3 = new Staff("staff", "Staff", "staff@gmail.com", "123");
//        shop.getStaffs().add(user3);
//        user2.setBalance(1000);
//
//        Product product = new Product("iphone", "Cũ", 12, 135, "điệm thoại");
//        Product product1 = new Product("tv", "Cũ", 12, 105, "tv thoại");
//        shop.getProducts().add(product);
//        shop.getProducts().add(product1);
//
//
//        Gson gson = new Gson();
//        String json = gson.toJson(shop);
//        System.out.println(json);


//        HandleFile handleFile = new HandleFile();
////        handleFile.saveFile(shop,"shop");
//
//
//        shop = handleFile.readShop();
//        Order order = new Order(shop.getCustomers().get(0));
//        order.inputInfo(scanner, shop.getProducts());
//        shop.getOrders().add(order);
//        shop.getCustomers().get(0).getOrders().add(order);

        users.add(user1);
        users.addAll(shop.getCustomers());
        users.addAll(shop.getStaffs());
//
        System.out.println(users.toString());
        Menu menu = new Menu();
        HandleAccount handleAccount = new HandleAccount(menu, shop);
        menu.setHandleAccount(handleAccount);
        menu.setShop(shop);

        User user = new User();
        Clazz clazzes = new Clazz();
        Subject subjects = new Subject();
        Teacher teacher = new Teacher();
        Student student = new Student();
        menu.mainMenu(scanner, users, user, clazzes, subjects, teacher, student);
        System.out.println(1);
//        handleFile.saveFile(shop, "shop");

    }
}

