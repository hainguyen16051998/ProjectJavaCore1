package data;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import school.entity.School;
import shop.entity.Product;
import shop.entity.Shop;


import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;

public class HandleFile {

    Gson gson = new Gson();

    public <T> void saveFile(T obj, String o) {
        String path = null;
        if (o.equals("shop")){
            path = "src/data/shop.json";
        }
        if (o.equals("school")){
            path = "src/data/school.json";
        }

        String json = gson.toJson(obj);

        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream(path);

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

    public Shop readShop() {
        Shop shop = null;
        FileReader reader = null;
        try {
            File file = new File("src/data/shop.json");
            reader = new FileReader(file);
            Type type = new TypeToken<Shop>() {
            }.getType();
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

    public School readSchool() {
        School school = null;
        FileReader reader = null;
        try {
            File file = new File("src/data/school.json");
            reader = new FileReader(file);
            Type type = new TypeToken<School>() {
            }.getType();
            school = gson.fromJson(reader, type);

        } catch (Exception e) {
            System.out.println("Lỗi dữ liệu");
        } finally {
            try {
                reader.close();
            } catch (Exception e) {
                System.out.println("Lỗi dữ liệu");
            }
        }
        return school;
    }
}
