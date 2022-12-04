package account.entity;

import account.handle.HandleAccount;
import shop.entity.Customer;

import java.util.List;
import java.util.Scanner;

public interface IHandleGeneral {

    default int chooseFunction(Scanner scanner, int max, int min) {
        int ch;
        while (true) {
            try {
                ch = Integer.parseInt(scanner.nextLine());
                if (ch < min || ch > max) {
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                System.out.print("Mời chọn lại: ");
            }
        }
        return ch;
    }

    default double returnAvg(Scanner scanner) {
        double n;
        while (true) {
            try {
                n = Double.parseDouble(scanner.nextLine());
                if (n < 0 || n > 10) {
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                System.out.print("Vui lòng nhập lại: ");
            }
        }
        return n;
    }

    default int returnInt(Scanner scanner) {
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

    default double returnDouble(Scanner scanner) {
        double balance;
        while (true) {
            try {
                balance = Double.parseDouble(scanner.nextLine());
                if (balance <= 0) {
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                System.out.print("Vui lòng nhập lại: ");
            }
        }
        return balance;
    }
}
