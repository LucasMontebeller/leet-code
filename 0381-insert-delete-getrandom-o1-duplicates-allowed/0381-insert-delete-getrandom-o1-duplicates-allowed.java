class RandomizedCollection {

    private final List<Integer> allElements;
    private final Set<Integer> uniqueElements;
    private final Random random;

    public RandomizedCollection() {
        allElements = new ArrayList<Integer>();
        uniqueElements = new HashSet<Integer>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        allElements.add(val);
        return uniqueElements.add(val);
    }
    
    public boolean remove(int val) {
        int index = allElements.indexOf(val);
        if (index == -1) {
            return false;
        }

        allElements.remove(index);
        if (!allElements.contains(val)) {
            uniqueElements.remove(val);
        }

        return true;
    }

    
    public int getRandom() {
        return allElements.get(random.nextInt(allElements.size()));
    }

}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */