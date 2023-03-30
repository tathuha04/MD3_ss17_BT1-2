import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static List<Product> productList;

    public static void main(String[] args) {
        productList = readFile();
        //thêm mới sản phẩm
        System.out.println("Nhập số lượng sản phẩm bạn muốn thêm vào");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            Product product = addProduct();
            productList.add(product);
        }
        writeFile();
        //hiển thị danh sách sản phẩm

        showProduct();
        //tìm kiếm sản phẩm
        System.out.println("bạn muốn tìm kiếm sản phẩm gì?");
        String searchProduct = scanner.nextLine();
        searchProduct(searchProduct);
    }

    public static Product addProduct() {
        Product product = new Product();
        System.out.println("Nhập id:");
        product.setId(Integer.parseInt(scanner.nextLine()));
        System.out.println("Nhập tên sẩn phẩm:");
        product.setName(scanner.nextLine());
        System.out.println("Nhập hãng sản xuất:");
        product.setProduction(scanner.nextLine());
        System.out.println("Nhập giá:");
        product.setPrice(Integer.parseInt(scanner.nextLine()));
        System.out.println("Nhập mô tả khác:");
        product.setTitle(scanner.nextLine());

        return product;
    }

    public static void showProduct() {
        for (Product product : productList
        ) {
            System.out.println(product);
        }
    }

    public static void searchProduct(String name) {
        boolean check = false;
        for (Product product : productList) {
            if (product.getName().equalsIgnoreCase(name)) {
                check = true;
                System.out.println(product);
            }
        }
        if (!check) {
            System.out.println("không tìm thấy sản phẩm");
        }
    }

    public static List<Product> readFile() {
        try {
            File file = new File("copyFile.txt");
            if (file.exists()) {
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis);
                List<Product> productStream = (List<Product>) ois.readObject();
                ois.close();
                fis.close();
                return productStream;
            }

        } catch (IOException | ClassNotFoundException i) {
            i.printStackTrace();
        }
        return new ArrayList<>();
    }

    public static void writeFile() {
        try {
            File file = new File("copyFile.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(productList);
            oos.close();
            fos.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}