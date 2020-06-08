package com.aor.refactoring.example3;

public class SimpleOrder {
    private Discount discount;
    private double price;

    public class NoDiscount implements Discount{
        @Override
        public double applyDiscount(double price) {
            return price;
        }
    }
    public SimpleOrder(double price) {
        this.price = price;
        this.discount= new NoDiscount();
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public double getTotal() {
        return discount.applyDiscount(price);
    }
}
