class AuctionSystem {

    static class Bid {
        int userId;
        int amount;

        Bid(int userId, int amount) {
            this.userId = userId;
            this.amount = amount;
        }
    }

    private final Map<Integer, Map<Integer, Integer>> itemBids;
    private final Map<Integer, PriorityQueue<Bid>> itemHighestBidder;

    public AuctionSystem() {
        itemBids = new HashMap<>();
        itemHighestBidder = new HashMap<>();
    }

    public void addBid(int userId, int itemId, int bidAmount) {
        updateBid(userId, itemId, bidAmount);
    }

    public void updateBid(int userId, int itemId, int newAmount) {
        Map<Integer, Integer> bids = itemBids.getOrDefault(itemId, new HashMap<>());
        bids.put(userId, newAmount);
        itemBids.put(itemId, bids);

        Comparator<Bid> bidComparator = (a, b) -> {
            if (a.amount != b.amount) {
                return b.amount - a.amount;
            }

            return b.userId - a.userId;
        };

        PriorityQueue<Bid> defaultQueue = new PriorityQueue<>(bidComparator);
        PriorityQueue<Bid> pq = itemHighestBidder.getOrDefault(itemId, defaultQueue);
        pq.offer(new Bid(userId, newAmount));
        itemHighestBidder.put(itemId, pq);
    }

    public void removeBid(int userId, int itemId) {
        Map<Integer, Integer> bids = itemBids.get(itemId);
        if (bids == null) {
            return;
        }

        bids.remove(userId);
        if (bids.isEmpty()) {
            itemBids.remove(itemId);
        }
    }

    public int getHighestBidder(int itemId) {
        PriorityQueue<Bid> pq = itemHighestBidder.get(itemId);
        if (pq == null) {
            return -1;
        }

        Map<Integer, Integer> currentBids = itemBids.get(itemId);
        while (!pq.isEmpty()) {
            Bid top = pq.peek();
            if (currentBids == null) {
                pq.poll();
                continue;
            }

            Integer officialAmount = currentBids.get(top.userId);
            if (officialAmount == null) {
                pq.poll();
                continue;
            }

            if (officialAmount != top.amount) {
                pq.poll();
                continue;
            }

            return top.userId;
        }

        return -1;
    }
}

/**
 * Your AuctionSystem object will be instantiated and called as such:
 * AuctionSystem obj = new AuctionSystem();
 * obj.addBid(userId,itemId,bidAmount);
 * obj.updateBid(userId,itemId,newAmount);
 * obj.removeBid(userId,itemId);
 * int param_4 = obj.getHighestBidder(itemId);
 */