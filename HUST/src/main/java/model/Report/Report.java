package model.Report;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

import model.Order.Order;
import model.Products.Product;
import model.Products.ProductInfo;
import model.Products.ReceiveProductInfo;
import model.ReceiveNote.ReceiveNote;

import model.Databases.OrderDB;
import model.Databases.ReceiveNoteDB;

public class Report implements Serializable {
    private static final long serialVersionUID = 1L;

    private double revenue;
    private double costs;
    private double profit;
//    private ArrayList<ProductInfo> productInfos;
    private LocalDate startDate;
    private LocalDate endDate;
    private ArrayList<ReceiveProductInfo> receiveProductInfos;


    public Report(LocalDate startDate, LocalDate endDate) throws Exception {
        this.startDate = startDate;
        this.endDate = endDate;
        this.revenue = 0;
        this.costs = 0;
        this.profit = 0;
        this.receiveProductInfos = null;
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
        OrderDB orderdb = new OrderDB();
        ReceiveNoteDB receivenotedb = new ReceiveNoteDB();
        ArrayList<Order> orderList = orderdb.getByPeriod(this.startDate, this.endDate);
        ArrayList<ReceiveNote> receivenoteList = receivenotedb.getByPeriod(this.startDate, this.endDate);

        double tmprevenue = 0;
        double tmpcosts = 0;
        double tmpprofit = 0;
        for(Order o : orderList) {
            tmprevenue += o.getTotalCost();
        }
        for(ReceiveNote rn : receivenoteList) {
            tmpcosts += rn.getTotalCost();
        }
        tmpprofit = tmprevenue - tmpcosts;
        this.revenue = tmprevenue;
        this.costs = tmpcosts;
        this.profit = tmpprofit;

        for(ReceiveNote x : receivenoteList){
            this.receiveProductInfos.add(x.getReceiveProductInfo());
        }
    }
}