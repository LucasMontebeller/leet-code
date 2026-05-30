class RideSharingSystem {

    private final Queue<Integer> driverQueue;
    private final Queue<Integer> riderQueue;

    public RideSharingSystem() {
        driverQueue = new ArrayDeque<>();
        riderQueue = new ArrayDeque<>();
    }
    
    public void addRider(int riderId) {
        riderQueue.offer(riderId);
    }
    
    public void addDriver(int driverId) {
        driverQueue.offer(driverId);
    }
    
    public int[] matchDriverWithRider() {
        System.out.println(riderQueue);
        System.out.println(driverQueue);
        if (riderQueue.isEmpty() || driverQueue.isEmpty()) {
            return new int[] {-1, -1};
        }
        
        return new int[] {driverQueue.poll(), riderQueue.poll()};
    }
    
    public void cancelRider(int riderId) {
        riderQueue.remove(riderId);
    }
}

/**
 * Your RideSharingSystem object will be instantiated and called as such:
 * RideSharingSystem obj = new RideSharingSystem();
 * obj.addRider(riderId);
 * obj.addDriver(driverId);
 * int[] param_3 = obj.matchDriverWithRider();
 * obj.cancelRider(riderId);
 */