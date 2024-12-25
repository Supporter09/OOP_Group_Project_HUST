package model.Databases;

import model.SalaryInfo.SalaryInfo;
import model.Users.Staff;
import model.Users.User;

import java.time.LocalDate;
import java.util.ArrayList;

public class TestSalaryInfo {
    public static void main(String[] args) throws Exception {
        // Initialize the SalaryInfoDB
        SalaryInfoDB salaryInfoDB = new SalaryInfoDB();

        // Create sample staff data
        UserDB userdb = new UserDB();
        ArrayList<Staff> staffList = new ArrayList<>();

        ArrayList<User> allStaff = userdb.getAllUsers();
        for(User x : allStaff){
            if (x instanceof Staff){
                staffList.add((Staff) x);
                System.out.println(x.getUsername());
            }
        }

        // Create a new SalaryInfo object
        SalaryInfo salaryInfo = new SalaryInfo(staffList, LocalDate.now());

        try {
            // Save the new SalaryInfo to the database
            salaryInfoDB.add(salaryInfo);
            System.out.println("SalaryInfo saved successfully!");

            // Retrieve and print all SalaryInfo records from the database
            ArrayList<SalaryInfo> allSalaryInfos = salaryInfoDB.getAll();

            System.out.println("All SalaryInfo records:");
            for (SalaryInfo info : allSalaryInfos) {
                System.out.println(info.toString());
            }

            if (allSalaryInfos.size() >= 5) {
                // Clear the database
                salaryInfoDB.clear();

                System.out.println("Database cleared successfully!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error occurred while handling SalaryInfoDB.");
        }
    }
}
