import java.util.SortedMap;
import java.util.TreeMap;

import java.util.*;

class StockPrice {

    private final TreeMap<Integer, Integer> timePrice;
    private final TreeMap<Integer, Integer> priceCount;

    public StockPrice() {
        timePrice = new TreeMap<>();
        priceCount = new TreeMap<>();
    }
    
    public void update(int timestamp, int price) {
        if (timePrice.containsKey(timestamp)) {
            int oldPrice = timePrice.get(timestamp);
            priceCount.put(oldPrice, priceCount.get(oldPrice) - 1);
            if (priceCount.get(oldPrice) == 0) {
                priceCount.remove(oldPrice);
            }
        }

        timePrice.put(timestamp, price);
        priceCount.put(price, priceCount.getOrDefault(price, 0) + 1);
    }
    
    public int current() {
        return timePrice.lastEntry().getValue();
    }
    
    public int maximum() {
        return priceCount.lastKey();
    }
    
    public int minimum() {
        return priceCount.firstKey();
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */