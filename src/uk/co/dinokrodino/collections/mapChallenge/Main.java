package uk.co.dinokrodino.collections.mapChallenge;

import java.util.Map;

public class Main {
    static StockList stockList = new StockList();

    public static void main(String[] args) {
        StockItem temp = new StockItem("bread", 0.86, 100);
        stockList.addItem(temp);

        temp = new StockItem("cake", 1.10, 7);
        stockList.addItem(temp);

        temp = new StockItem("car", 12.50, 2);
        stockList.addItem(temp);

        temp = new StockItem("chair", 62.0, 10);
        stockList.addItem(temp);

        temp = new StockItem("cup", 0.50, 200);
        stockList.addItem(temp);
        temp = new StockItem("cup", 0.45, 7);
        stockList.addItem(temp);

        temp = new StockItem("door", 72.95, 4);
        stockList.addItem(temp);

        temp = new StockItem("juice", 2.50, 36);
        stockList.addItem(temp);

        temp = new StockItem("phone", 96.99, 35);
        stockList.addItem(temp);

        temp = new StockItem("towel", 2.40, 80);
        stockList.addItem(temp);

        temp = new StockItem("vase", 8.76, 40);
        stockList.addItem(temp);

        System.out.println(stockList);

//        for(String s: stockList.Items().keySet()) {
//            System.out.println(s);
//        }

        Basket customer1Basket = new Basket("customer1");

        sellItem(customer1Basket, "car", 1);
        System.out.println(customer1Basket);

        sellItem(customer1Basket, "car", 1);
        System.out.println(customer1Basket);

        //won't sell becouse we run out of item(add control in StockItem.reserveStock())
        sellItem(customer1Basket, "car", 1);

        sellItem(customer1Basket, "spanner", 5);

        sellItem(customer1Basket, "juice", 4);
        sellItem(customer1Basket, "cup", 12);
        sellItem(customer1Basket, "bread", 1);
//        System.out.println(customer1Basket);

        Basket basket = new Basket("customer2");
        sellItem(basket, "cup", 100);
        sellItem(basket, "juice", 5);
        removeItem(basket, "cup", 1);
        System.out.println(basket);

        removeItem(customer1Basket, "car", 1);
        removeItem(customer1Basket, "cup", 9);
        removeItem(customer1Basket, "car", 1);
        System.out.println("cars removed: " + removeItem(customer1Basket, "car", 1));  // should not remove any

        System.out.println("+++++++++++++++++++++");
        System.out.println(customer1Basket);

        // remove all items from customer1Basket
        removeItem(customer1Basket, "bread", 1);
        removeItem(customer1Basket, "cup", 3);
        removeItem(customer1Basket, "juice", 4);
        removeItem(customer1Basket, "cup", 3);
        System.out.println(customer1Basket);

        System.out.println("\nDisplay stock list before and after checkout");
        System.out.println(basket);
        System.out.println(stockList);
        checkOut(basket);
        System.out.println(basket);
        System.out.println(stockList);

//        temp = new StockItem("pen", 1.12);
//        stockList.Items().put(temp.getName(), temp);
        StockItem car = stockList.Items().get("car");
        if(car != null) {
            car.adjustStock(2000);
        }
        if(car != null) {
            stockList.get("car").adjustStock(-1000);
        }

        System.out.println(stockList);
//        for(Map.Entry<String, Double> price: stockList.PriceList().entrySet()) {
//            System.out.println(price.getKey() + " costs " + price.getValue());
//        }

        checkOut(customer1Basket);
        System.out.println(customer1Basket);


    }

    public static int sellItem(Basket basket, String item, int quantity) {
        // retrieve the item from stock list
        StockItem stockItem = stockList.get(item);
        if(stockItem == null) {
            System.out.println("We don't sell " + item);
            return 0;
        }
        if(stockList.reserveStock(item, quantity) != 0) {
            return basket.addToBasket(stockItem, quantity);
        }
        return 0;
    }

    public static int removeItem(Basket basket, String item, int quantity) {
        // retrieve the item from stock list
        StockItem stockItem = stockList.get(item);
        if(stockItem == null) {
            System.out.println("We don't sell " + item);
            return 0;
        }
        if(basket.removeFromBasket(stockItem, quantity) == quantity) {
            return stockList.unreserveStock(item, quantity);
        }
        return 0;
    }

    public static void checkOut(Basket basket) {
        for (Map.Entry<StockItem, Integer> item : basket.Items().entrySet()) {
            stockList.sellStock(item.getKey().getName(), item.getValue());
        }
        basket.clearBasket();
    }

}