package data;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import shop.entity.Product;
import shop.entity.Shop;


import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;

public class HandleFile{
    Gson gson = new Gson();

    public HandleFile() {

    }

    public void saveFile(Shop shop) {

        String json = gson.toJson(shop);

        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream("src/data/shop.json");

            byte[] data = json.getBytes("utf8");

            fos.write(data);
        } catch (Exception e) {
            System.out.println("Lỗi dữ liệu");
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (Exception e) {
                    System.out.println("Lỗi dữ liệu");
                }
            }
        }

    }

    public Shop readFile() {
        Shop shop = new Shop();
        FileReader reader = null;
        try {
            File file = new File("src/data/shop.json");
            reader = new FileReader(file);
            Type type = new TypeToken<Shop>(){}.getType();
            shop = gson.fromJson(reader, type);

        } catch (Exception e) {
            System.out.println("Lỗi dữ liệu");
        } finally {
            try {
                reader.close();
            } catch (Exception e) {
                System.out.println("Lỗi dữ liệu");
            }
        }
        return shop;
    }
}
