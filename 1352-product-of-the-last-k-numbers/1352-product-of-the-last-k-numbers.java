class ProductOfNumbers {

    private final Deque<Integer> numbers;

    public ProductOfNumbers() {
        numbers = new ArrayDeque<>();
    }
    
    public void add(int num) {
        numbers.offer(num);
    }
    
    public int getProduct(int k) {
        Iterator<Integer> iterator = numbers.descendingIterator();
        int result = 1;
        while (k > 0) {
            result *= iterator.next();
            k--;
        }

        return result;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */