package uk.co.dinokrodino.collections.mapChallenge;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class StockList {
private final Map<String, StockItem> stockList;

    public StockList() {
        this.stockList = new TreeMap<String, StockItem>();
    }

    public int addItem(StockItem item){
        if(item != null){
            //check if item already exist
            StockItem inStock = stockList.getOrDefault(item.getName(), item);

            if(inStock != item){
                //already exist, add quntity to quantity in stock
                item.adjustStock(inStock.availableQuantity());
            }
            stockList.put(item.getName(),item);
            return item.availableQuantity();
        }
        return 0;
    }

    public int sellStock(String item, int quantity) {
        StockItem inStock = stockList.get(item);

        if((inStock != null) && (quantity > 0)) {
            return inStock.finaliseStock(quantity);
        }
        return 0;
//        StockItem inStock = list.getOrDefault(item, null);
//
//        if((inStock != null) && (inStock.availableQuantity() >= quantity) && (quantity >0)) {
//            inStock.adjustStock(-quantity);
//            return quantity;
//        }
//        return 0;
    }

    public int reserveStock(String item, int quantity) {
        StockItem inStock = stockList.get(item);

        if((inStock != null) && (quantity > 0)) {
            return inStock.reserveStock(quantity);
        }
        return 0;
    }

    public int unreserveStock(String item, int quantity) {
        StockItem inStock = stockList.get(item);

        if((inStock != null) && (quantity > 0)) {
            return inStock.unreserveStock(quantity);
        }
        return 0;

    }

    public StockItem get(String name){
        return stockList.get(name);
    }

    public Map<String,StockItem> Items(){
        return Collections.unmodifiableMap(stockList);
    }

    @Override
    public String toString() {
        String s = "\nStock List\n";
        double totalCost = 0.0;
        for (Map.Entry<String, StockItem> item : stockList.entrySet()) {
            StockItem stockItem = item.getValue();

            double itemValue = stockItem.getPrice() * stockItem.getQuantityStock();

            s = s + stockItem + ". There are " + stockItem.getQuantityStock() + " in stock. Value of items: ";
            s = s + itemValue + "\n";
            totalCost += itemValue;
        }

        return s + "Total stock value " + totalCost;
    }
}
