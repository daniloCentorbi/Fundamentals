package uk.co.dinokrodino.collections.mapChallenge;

import java.util.Objects;

public class StockItem implements Comparable<StockItem> {
    private final String name;
    private double price;
    private int quantityStock;
    private int reserved;

    public StockItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantityStock = 0;
        this.reserved = 0;
    }

    public StockItem(String name, double price, int quantityStock) {
        this.name = name;
        this.price = price;
        this.quantityStock = quantityStock;
        this.reserved = 0;
    }

    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        }
    }

    public void adjustStock(int quantity) {
        int newQuantity = quantityStock + quantity;
        if (newQuantity >= 0) {
            quantityStock = newQuantity;
        }
    }

    public int availableQuantity() {
        return quantityStock - reserved;
    }

    public int reserveStock(int quantity) {
        if (quantity <= availableQuantity()) {
            reserved += quantity;
            return quantity;
        }
        return 0;
    }

    public int unreserveStock(int quantity) {
        if (quantity <= reserved) {
            reserved -= quantity;
            return quantity;
        }
        return 0;
    }

    public int finaliseStock(int quantity) {
        if (quantity <= reserved) {
            quantityStock -= quantity;
            reserved -= quantity;
            return quantity;
        }

        return 0;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantityStock() {
        return quantityStock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || (this.getClass() != o.getClass())) return false;
        StockItem stockItem = (StockItem) o;
        return name.equals(stockItem.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name) + 57;
    }

    @Override
    public int compareTo(StockItem o) {
        if (this == o) {
            return 0;
        }
        if (o != null) {
            return this.name.compareTo(o.name);
        }
        throw new NullPointerException();
    }

    @Override
    public String toString() {
        return " Item: " + name + '\'' +
                ", price=" + price +
                ", quantityStock=" + quantityStock;
    }

}