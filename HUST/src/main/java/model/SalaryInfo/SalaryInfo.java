package model.SalaryInfo;

import model.Users.Staff;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class SalaryInfo implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private ArrayList<Staff> staffList; // List of staff with salary info
    private LocalDate createdAt;

    // Constructor
    public SalaryInfo() {
        this.staffList = new ArrayList<Staff>();
        this.createdAt = LocalDate.now();
    }


    public SalaryInfo(ArrayList<Staff> staffList, LocalDate createdAt) {
        this.staffList = staffList;
        this.createdAt = createdAt;
    }

    // Getters and setters
    public double getTotalSalary() {
        return staffList.stream().mapToDouble(Staff::getSalary).sum();
    }

    public ArrayList<Staff> getStaffList() {
        return staffList;
    }

    public void setStaffList(ArrayList<Staff> staffList) {
        this.staffList = staffList;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        SalaryInfo that = (SalaryInfo) obj;
        return Double.compare(that.getTotalSalary(), this.getTotalSalary()) == 0 &&
                staffList.equals(that.staffList) &&
                createdAt.equals(that.createdAt);
    }

    @Override
    public String toString() {
        return "SalaryInfo{" +
                "totalSalary=" + getTotalSalary() +
                ", staffListLength" + staffList.size() +
                ", createdAt=" + createdAt +
                '}';
    }
}
