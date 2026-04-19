class UndergroundSystem {

    private record Ticket(String stationName, int time) {}

    private record Travel(String startStationName, String endStationName) {

        @Override
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }

            if (other == null || !(other instanceof Travel)) {
                return false;
            }

            Travel travel = (Travel) other;
            return this.startStationName.equals(travel.startStationName)
                    && this.endStationName.equals(travel.endStationName);
        }

        @Override
        public int hashCode() {
            return Objects.hash(startStationName, endStationName);
        } 
    }

    private final Map<Integer, Ticket> ticketIdentification;
    private final Map<Travel, Deque<Integer>> travelTimes;

    public UndergroundSystem() {
        ticketIdentification = new HashMap<>();
        travelTimes = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        ticketIdentification.put(id, new Ticket(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Ticket ticket = ticketIdentification.get(id);
        ticketIdentification.remove(id);

        Travel travel = new Travel(ticket.stationName, stationName);
        Deque<Integer> times = travelTimes.getOrDefault(travel, new ArrayDeque<>());
        times.add(t - ticket.time);
        travelTimes.put(travel, times);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        Deque<Integer> times = travelTimes.get(new Travel(startStation, endStation));
        int sum = 0;
        for (Integer time : times) {
            sum += time;
        }

        return (double) sum / times.size();
    }

}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */