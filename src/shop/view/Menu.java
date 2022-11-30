package shop.view;

import java.util.Scanner;

public class Menu {
    public void displayMenu(Scanner scanner) {
        System.out.println("------MẢNG BÁN HÀNG-----");
        System.out.println("1. Đăng nhập");
        System.out.println("2. Đăng ký");
        System.out.println("0. Thoát");
        System.out.print("Mời bạn chọn: ");
        int choice = 0;
        try {
            do {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice == 1 || choice == 2)
                    break;
                System.out.println("Nhập sai, nhập lại");
            } while (true);
        } catch (Exception e) {
            System.out.println("Nhập số, nhập lại: ");
        }
        switch (choice){
            case 1:
                break;
            case 2:
                break;
            case 0:
                return;
        }
    }
}
