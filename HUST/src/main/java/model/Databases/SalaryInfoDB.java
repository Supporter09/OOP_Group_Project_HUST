package model.Databases;

import model.SalaryInfo.SalaryInfo;
import model.exception.DatabaseNotAvailableException;

import java.io.*;
import java.util.ArrayList;

public class SalaryInfoDB {
    private String path;
    private ArrayList<SalaryInfo> db;
    private boolean available;

    public SalaryInfoDB() {
        this.path = "./src/main/java/app/data/salaryinfodb.dat";
        this.db = new ArrayList<>();
        this.available = false;
        this.init();
    }

    public SalaryInfoDB(String path) {
        this.path = path;
        this.db = new ArrayList<>();
        this.available = false;
        this.init();
    }

    private void init() {
        try {
            File file = new File(this.path);
            if (!file.exists()) {
                file.createNewFile();
                this.db = new ArrayList<>();
            } else {
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis);
                this.db = (ArrayList<SalaryInfo>) ois.readObject();
                ois.close();
                fis.close();
            }
            this.available = true;
        } catch (Exception e) {
            e.printStackTrace();
            this.available = false;
        }
    }

    public void add(SalaryInfo salaryInfo) throws Exception {
        if (!available) {
            throw new DatabaseNotAvailableException("Database is not available");
        }
        this.db.add(salaryInfo);
        save();
    }

    public ArrayList<SalaryInfo> getAll() throws Exception {
        if (!available) {
            throw new DatabaseNotAvailableException("Database is not available");
        }
        return this.db;
    }

    private void save() throws IOException {
        FileOutputStream fos = new FileOutputStream(this.path);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this.db);
        oos.close();
        fos.close();
    }

    public void clear() throws Exception {
        if (!available) {
            throw new DatabaseNotAvailableException("Database is not available");
        }
        this.db.clear(); // Clear the in-memory list
        save(); // Save the empty list to the file
    }
}
