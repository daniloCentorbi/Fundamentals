package uk.co.dinokrodino.collections.mapChallenge;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Basket {
    private final String name;
    private final Map<StockItem, Integer> basketList;

    public Basket(String name) {
        this.name = name;
        this.basketList = new TreeMap<>();
    }

    public int addToBasket(StockItem item, int quantity) {
        if((item != null) && (quantity > 0)){
            int inBasket = basketList.getOrDefault(item,0);
        basketList.put(item, inBasket + quantity);
        return quantity;
        }
        return 0;
    }

    public int removeFromBasket(StockItem item, int quantity) {
        if((item != null) && (quantity > 0)) {
            // check if we already have the item in the basket
            int inBasket = basketList.getOrDefault(item, 0);
            int newQuantity = inBasket - quantity;

            if(newQuantity > 0) {
                basketList.put(item, newQuantity);
                return quantity;
            } else if(newQuantity == 0) {
                basketList.remove(item);
                return quantity;
            }
        }
        return 0;
    }

    public void clearBasket() {
        this.basketList.clear();
    }

    public Map<StockItem, Integer> Items() {
        return Collections.unmodifiableMap(basketList);
    }

    @Override
    public String toString() {
        String s = "\nShopping basket " + name + " contains " + basketList.size() + ((basketList.size() == 1) ? " item" : " items") + "\n";
        double totalCost = 0.0;
        for (Map.Entry<StockItem, Integer> item : basketList.entrySet()) {
            s = s + item.getKey() + ". " + item.getValue() + " purchased\n";
            totalCost += item.getKey().getPrice() * item.getValue();
        }
        return s + "Total cost " + totalCost;
    }
}
