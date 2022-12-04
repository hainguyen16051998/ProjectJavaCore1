package school.handle;

import java.util.Scanner;

public interface IHandle {
    //trả về số double
    default double returnDouble(Scanner scanner) {
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
}
