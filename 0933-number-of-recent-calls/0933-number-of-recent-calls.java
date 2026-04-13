class RecentCounter {

    private final Deque<Integer> requests;

    public RecentCounter() {
        requests = new ArrayDeque<>();
    }
    
    public int ping(int t) {
        requests.add(t);

        int cut = t - 3000;
        while (requests.peekFirst() < cut) {
            requests.removeFirst();
        }

        return requests.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */