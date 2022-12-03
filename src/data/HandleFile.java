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

public class HandleFile<T> {
    Gson gson = new Gson();
    private T obj;

    public HandleFile(T obj) {
        this.obj = obj;
    }

    public void saveFile() {

        String json = gson.toJson(obj);

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

//    public <E> void readFile(List<E>) {
//        FileReader reader = null;
//        try {
//            File file = new File("src/data/shop.json");
//            reader = new FileReader(file);
//            Type type = new TypeToken<List<Product>>(){}.getType();
//            obj = gson.fromJson(reader, type);
//
//        } catch (Exception e) {
//            System.out.println("Lỗi dữ liệu");
//        } finally {
//            try {
//                reader.close();
//            } catch (Exception e) {
//                System.out.println("Lỗi dữ liệu");
//            }
//        }
//    }
}
