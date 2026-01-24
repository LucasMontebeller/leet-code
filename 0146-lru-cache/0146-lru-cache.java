class LRUCache {

    private final int capacity; 
    private final Map<Integer, Integer> cache;
    private final Queue<Integer> usedKeyQueue;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<Integer, Integer>(capacity);
        this.usedKeyQueue = new LinkedList<Integer>();
    }
    
    public int get(int key) {
        var value = this.cache.getOrDefault(key, -1);
        if (value != - 1) {
            usedKeyQueue.remove(key);
            usedKeyQueue.offer(key);
        }
        
        return value;
    }
    
    public void put(int key, int value) {
        if (this.cache.containsKey(key)) {
            usedKeyQueue.remove(key);
        }
        else if (cache.size() == capacity) {
            var leastUsedKey = usedKeyQueue.poll();
            this.cache.remove(leastUsedKey);
        }

        usedKeyQueue.offer(key);
        this.cache.put(key, value);
    }
}