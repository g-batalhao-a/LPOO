package com.aor.refactoring.example1;

public class OrderLine {
    private Product product;
    private int quantity;

    public OrderLine(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getOrderLineTotal(){
        return product.getPrice()*quantity;
    }

    public String printOrderLine(){
        StringBuffer printBuffer = new StringBuffer();
        printBuffer.append(product.getName() + "(x" + quantity + "): " + (product.getPrice() * quantity) + "\n");
        return printBuffer.toString();
    }
}
