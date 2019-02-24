package io.arkitekt.mainWorker.operationBilling;

public class BillingData {
    private String name;
    private String card;
    private String cvv;
    private String month;
    private String year;


    public BillingData(String name, String card, String cvv, String month, String year) {
        this.name = name;
        this.card = card;
        this.cvv = cvv;
        this.month = month;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public String getCard() {
        return card;
    }

    public String getCvv() {
        return cvv;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }
}
