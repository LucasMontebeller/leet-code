class SmallestInfiniteSet {

    private final Set<Integer> removedNumbers;

    public SmallestInfiniteSet() {
        removedNumbers = new HashSet<>();
    }
    
    public int popSmallest() {
        int number = 1;
        while (number <= 1000) {
            if (!removedNumbers.contains(number)) {
                break;
            }

            number += 1;
        }

        removedNumbers.add(number);
        return number;
    }
    
    public void addBack(int num) {
        removedNumbers.remove(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */