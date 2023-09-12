package model;

import java.util.Date;

public class CurrencyExchange {
    public String getFromToSymbol() {
        return fromToSymbol;
    }

    public void setFromToSymbol(String fromToSymbol) {
        this.fromToSymbol = fromToSymbol;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPercentChange() {
        return percentChange;
    }

    public void setPercentChange(String percentChange) {
        this.percentChange = percentChange;
    }

    private String fromToSymbol; // USD/JPY
    private String price;
    private String percentChange;
}
