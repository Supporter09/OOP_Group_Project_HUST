package app;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Databases.UserDB;
import model.Products.Stationary;
import model.Products.Toy;
import model.Store.Store;
import model.Users.Admin;
import model.Users.Customer;
import model.Users.Staff;
import model.Products.Book;


import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main extends Application {
    private static final Boolean FIRST_RUN = false;

    private static UserDB userdb = new UserDB();
    private static Store store = new Store();

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, Exception {
        if(FIRST_RUN)
        {
            initial();
        }

        else {
            launch(args);

        }
    }
    @Override
    public void start(Stage primiaryStage) throws Exception {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/controller/Login.fxml"));
            Parent root = fxmlLoader.load();

            primiaryStage.setTitle("HUST Book Store");
            Image image  = new Image(getClass().getResourceAsStream("/app/image/HUST.png"));
            primiaryStage.getIcons().add(image);
            primiaryStage.setScene(new Scene(root,1080,750));

            primiaryStage.show();

            primiaryStage.setOnCloseRequest(event -> {
                event.consume();
                logout(primiaryStage);
            });

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void logout(Stage stage) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You about to logout");
        alert.setContentText("Do you want to save before exiting?");

        if (alert.showAndWait().get() == ButtonType.OK) {
            System.out.println("You have logged out");
            stage.close();
        }

    }

    private static Staff generateStaff(String username, String password, String phone, LocalDate dateJoined, float salary) throws Exception
    {
        Staff staff = new Staff(username, password,phone,dateJoined, salary);
        return staff;
    }

    private static Customer generateCustomer(String username, String password) throws Exception
    {
        Customer customer = new Customer(username, password);
        return customer;
    }

    public static void initial() throws Exception
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        Staff staff7 = generateStaff("2","2","0987654321",LocalDate.parse("01/01/2024", formatter),200);
//        Admin test = new Admin("1","1","0",LocalDate.parse("01/01/2024", formatter),0);
//        Customer customer3 = generateCustomer("0", "0");


//        Customer customer1 = generateCustomer("Bui Cong Minh", "Em Fan Anh 7");
//        Customer customer2 = generateCustomer("Binh Cong Mui", "Em Fan Anh 10");
        Admin adminTest = new Admin("1","1","1",LocalDate.parse("01/01/2024",formatter),0);
        Staff staffTest = generateStaff("2","2","2",LocalDate.parse("01/01/2024",formatter),0);
        Customer customerTest = generateCustomer("0","0");

        Admin admin = new Admin("Mai Văn Nhật Minh","333","0192999492",LocalDate.parse("01/01/2024",formatter),800);

        Staff staff1 = generateStaff("Phạm Đức Duy","123","0916569655", LocalDate.parse("21/07/2024", formatter),3750);
        Staff staff2 = generateStaff("Mai Văn Nhật Minh","123","0981545964",LocalDate.parse("19/05/2024", formatter),440);
        Staff staff3 = generateStaff("Tạ Quốc Hùng","123","0983659452",LocalDate.parse("08/11/2024", formatter),300);
        Staff staff4 = generateStaff("Đặng Trung Anh","123","0905975125",LocalDate.parse("17/12/2024", formatter),400);
        Staff staff5 = generateStaff("Bùi Công Minh","123","0989630214",LocalDate.parse("14/10/2024", formatter),350);
        Staff staff6 = generateStaff("Nguyễn Thái Anh Minh","123","0986251455",LocalDate.parse("22/08/2024", formatter),300);

        Customer customer1 = generateCustomer("Nguyễn Văn A","111");
        Customer customer2 = generateCustomer("Nguyễn Thị B","222");

        Book book1 = new Book("Giải tích I", 2.05, "Sách lý thuyết môn Giải tích I",
                "NXB Đại học Bách Khoa","Đoàn Công Định, Trịnh Ngọc Hải", 963244461);
        Book book2 = new Book("Giải tích II", 2.77, "Sách lý thuyết môn Giải tích II",
                "NXB Đại học Bách Khoa","Trần Thị Kim Oanh, Phan Xuân Thành", 975244521);
        Book book3 = new Book("Giải tích III", 2.32, "Sách lý thuyết môn Giải tích III",
                "NXB Đại học Bách Khoa","Nguyễn Thiệu Huy, Bùi Xuân Diệu, Đào Tuấn Anh", 963235521);
        Book book4 = new Book("Đại số", 2.14, "Sách lý thuyết môn giải tích Đại số",
                "NXB Đại học Bách Khoa","Vũ Thị Ngọc Hà, Tạ Thị Thanh Mai", 978604481);

        Toy toy1 = new Toy("Siêu Xe Sang Trọng Mercedes-Benz 190E 2.5-1.6",4.95,
                "Màu bạc", "Hot Wheels");
        Toy toy2 = new Toy("Qiyi Smartcube",10.24,
                "Rubik Cube", "Qiyi");
        Toy toy3 = new Toy("Barbie Dream Closet Toy Playset", 24.14,
                "Barbie doll","Barbie");
        Toy toy4 = new Toy("Monopoly Classic", 20.17,
                "Board game","Hasbro");

        Stationary stationary1 = new Stationary("Bút bi",24.6,"Hộp bút bi nước - 30 cái","Thiên Long",
                "Dụng cụ viết");
        Stationary stationary2 = new Stationary("Bút chì",8.96,"Hộp bút chì gỗ - 2B - 20 cái","Staedtler",
                "Dụng cụ viết");
        Stationary stationary3 = new Stationary("Vở ô ly",0.53,"Vở ô ly 48 trang","Hồng Hà",
                "Giấy vở");
        Stationary stationary4 = new Stationary("Kéo",2.55,"Kéo cắt giấy văn phòng","Pro Office",
                "Dụng cụ cắt");


        admin.addProductToStore(book1,20,0.85);
        admin.addProductToStore(book2,15,0.95);
        admin.addProductToStore(book3,25,0.88);
        admin.addProductToStore(book4,30,0.97);
        admin.addProductToStore(toy1,9,1.85);
        admin.addProductToStore(toy2,24,3.69);
        admin.addProductToStore(toy3,12,10.85);
        admin.addProductToStore(toy4,7,9.62);
        admin.addProductToStore(stationary1,20,15.8);
        admin.addProductToStore(stationary2,20,5.66);
        admin.addProductToStore(stationary2,100,0.15);
        admin.addProductToStore(stationary2,30,1.08);


//        Book book1 = new Book("Harry Potter and BCM", 1.0d, "The Adventure of Harry Potter and BCM", "BCM", "Minh",123);
//        Book book2 = new Book("Harry Potter and PDD", 100.0d, "The Adventure of Harry Potter and PDD", "PDD", "Minh",123);
//
//        staff1.addProductToStore(book1, 10, 4.0); // thêm 10 cuốn sách book1 vào store với giá nhập là 4.0
//        staff1.addProductToStore(book1, 20, 6.0); // tiếp tục thêm 20 cuốn sách book1 vào store với giá nhập là 6.0
//        staff1.addProductToStore(book2, 20, 5.0); // thêm 20 cuốn sách book2 vào store với giá nhập là 5.0
//
//        Toy toy1 = new Toy("Tai nghe 100 cu", 100000000d, "Tai nghe nghe sieu hay", "Handmade");
//        Toy toy2 = new Toy("Laptop 1 ty 7", 1700000000d, "Laptop sieu khoe", "Hang tang khong ban");
//        Toy toy3 = new Toy("But bi", 2.0d, "but bi cho hoc sinh", "Thien Long");
//
//        staff1.addProductToStore(toy1, 2, 10.4); // thêm 2 toy1 vào store với giá nhập là 10.4
//        staff1.addProductToStore(toy2, 1, 5.7); // thêm 1 toy2 vào store  với giá nhập là 5.7
//        staff1.addProductToStore(toy3, 100, 1.2); // thêm 100 toy3 vào store với giá nhập là 1.2
//
//        Toy toy4 = new Toy("Rong trang mat xanh", 100d, "Sieu khoe", "Yugioh");
//        Stationary stationary1 = new Stationary("But bi",1.24,"Xin","Thien Ly","But");
//        staff2.addProductToStore(toy4, 1, 10);
//        staff2.addProductToStore(stationary1,1,0.24);
    }



}

