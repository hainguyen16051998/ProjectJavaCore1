import data.HandleFile;
import shop.entity.Shop;

import java.util.Scanner;

public class MainRun {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Shop shop = new Shop();
        HandleFile handleFile = new HandleFile();
        handleFile.readFile(shop);
    }
}
