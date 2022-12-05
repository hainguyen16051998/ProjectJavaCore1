import account.entity.User;
import account.handle.HandleAccount;
import account.view.Menu;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import data.HandleFile;
import school.entity.School;
import shop.entity.*;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainRun {
    public static void main(String[] args) {
        Shop shop = new Shop();
        School school = new School();
        Scanner scanner = new Scanner(System.in);
        List<User> users = new ArrayList<>();


        HandleFile handleFile = new HandleFile();
        school = handleFile.readSchool();
        shop = handleFile.readShop();
        User admin = handleFile.readAdmin();

        users.add(admin);
        users.addAll(shop.getCustomers());
        users.addAll(shop.getStaffs());
        users.addAll(school.getStudents());
        users.addAll(school.getTeachers());
//        System.out.println(users);

        Menu menu = new Menu();
        HandleAccount handleAccount = new HandleAccount(menu, shop, school);
        menu.setHandleAccount(handleAccount);
        menu.mainMenu(scanner, users);

        handleFile.saveFile(shop, "shop");
        handleFile.saveFile(school, "school");
        handleFile.saveFile(admin, "admin");

    }
}

