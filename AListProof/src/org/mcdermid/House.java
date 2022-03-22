package org.mcdermid;

public class House {

    private String address;

    private double price;

    public House(String a, double p) {
        this.address = a;
        this.price = p;
    }

    public String toString() {
        return "A house costing $" + price +
                "and located at " + address;
    }
}
