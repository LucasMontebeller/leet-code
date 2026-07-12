class MyHashSet {
    
    private final Integer[] dummySet;

    public MyHashSet() {
        dummySet = new Integer[10000];
    }
    
    public void add(int key) {
        for (int i = 0; i < dummySet.length; i++) {
            if (dummySet[i] == null) {
                dummySet[i] = key;
                return;
            }
        }
        // Extend the array size
    }
    
    public void remove(int key) {
        for (int i = 0; i < dummySet.length; i++) {
            if (dummySet[i] != null && dummySet[i] == key) {
                dummySet[i] = null;
            }
        }
    }
    
    public boolean contains(int key) {
        for (int i = 0; i < dummySet.length; i++) {
            if (dummySet[i] != null && dummySet[i] == key) {
                return true;
            }
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */