package account.entity;

import java.util.Scanner;

public interface IChooseFunction {
    default int chooseFunction(Scanner scanner, int max) {
        System.out.print("Chọn chức năng: ");
        int ch;
        while (true) {
            try {
                ch = Integer.parseInt(scanner.nextLine());
                if (ch < 0 || ch > max) {
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                System.out.print("Mời chọn lại: ");
            }
        }
        return ch;
    }
}
