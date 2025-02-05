package model.Report;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

import controller.Login;
import model.Databases.SalaryInfoDB;
import model.Order.Order;
import model.Products.Product;
import model.Products.ProductInfo;
import model.Products.ReceiveProductInfo;
import model.ReceiveNote.ReceiveNote;

import model.Databases.OrderDB;
import model.Databases.ReceiveNoteDB;
import model.SalaryInfo.SalaryInfo;
import model.Users.Staff;
import model.Users.User;

public class Report implements Serializable {
    private static final long serialVersionUID = 1L;

    private double revenue;
    private double costs;
    private double profit;
//    private ArrayList<ProductInfo> productInfos;
    private LocalDate startDate;
    private LocalDate endDate;
    private ArrayList<ReceiveProductInfo> receiveProductInfos;
    private ArrayList<ProductInfo> ordersProductInfo;


    public Report(LocalDate startDate, LocalDate endDate) throws Exception {
        this.startDate = startDate;
        this.endDate = endDate;
        this.revenue = 0;
        this.costs = 0;
        this.profit = 0;
        this.receiveProductInfos = new ArrayList<>();
        this.ordersProductInfo = new ArrayList<>();
        this.calculateEveryThing();
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) throws Exception {
        this.startDate = startDate;
        this.calculateEveryThing();
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) throws Exception {
        this.endDate = endDate;
        this.calculateEveryThing();
    }

    public ArrayList<ReceiveProductInfo> getReceiveProductInfos() {
        return receiveProductInfos;
    }

    public ArrayList<ProductInfo> getOrdersProductInfo() {
        return ordersProductInfo;
    }

    public double getRevenue() {
        return revenue;
    }

    public double getCosts() {
        return costs;
    }

    public double getProfit() {
        return profit;
    }

    private void calculateEveryThing() throws Exception {
        SalaryInfoDB salaryInfoDB = new SalaryInfoDB();
        OrderDB orderdb = new OrderDB();
        ReceiveNoteDB receivenotedb = new ReceiveNoteDB();
        
        ArrayList<SalaryInfo> salaryInfo = salaryInfoDB.getByPeriod(this.startDate,this.endDate);
        ArrayList<Order> orderList = orderdb.getByPeriod(this.startDate, this.endDate);
        ArrayList<ReceiveNote> receivenoteList = receivenotedb.getByPeriod(this.startDate, this.endDate);

        double tmprevenue = 0;
        double tmpcosts = 0;
        double tmpsalary = 0;

        for(Order o : orderList) {
            tmprevenue += o.getTotalCost();
        }

        for(ReceiveNote rn : receivenoteList) {
            tmpcosts += rn.getTotalCost();
        }

        for(SalaryInfo s : salaryInfo){
            tmpsalary += s.getTotalSalary();
        }


        this.revenue = tmprevenue;
        this.costs = (tmpcosts + tmpsalary);
        double tmpprofit = this.revenue - this.costs;
        this.profit = tmpprofit;

        this.receiveProductInfos = new ArrayList<>();
        this.ordersProductInfo = new ArrayList<>();

        for(ReceiveNote rn : receivenoteList){
            this.receiveProductInfos.add(rn.getReceiveProductInfo());
        }

        for(Order o : orderList){
            ArrayList<ProductInfo> productInfoArrayList = o.getProductInfoList();
            for (ProductInfo p : productInfoArrayList){
                this.ordersProductInfo.add(p);
            }
        }
    }
}