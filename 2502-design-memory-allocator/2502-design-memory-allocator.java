class Allocator {

    private final int[] memory;
    private final Map<Integer, List<Integer>> mIDPositions;

    public Allocator(int n) {
        memory = new int[n];
        mIDPositions = new HashMap<>(n);
    }
    
    public int allocate(int size, int mID) {
        List<Integer> positions = new ArrayList<>(size);
        for (int i = 0; i < memory.length && positions.size() != size; i++) {
            if (memory[i] != 0) {
                positions.clear();
                continue;
            }

            positions.add(i);
        }

        if (positions.size() != size) {
            return -1;
        }

        for (var position : positions) {
            memory[position] = mID;
        }

        List<Integer> currentPositions = mIDPositions.getOrDefault(mID, new ArrayList<>());
        positions.addAll(currentPositions);
        mIDPositions.put(mID, positions);

        return positions.get(0);
    }
    
    public int freeMemory(int mID) {
        List<Integer> positions = mIDPositions.remove(mID);
        if (positions == null) {
            return 0;
        }

        for (var position : positions) {
            memory[position] = 0;
        }

        return positions.size();
    }
}

/**
 * Your Allocator object will be instantiated and called as such:
 * Allocator obj = new Allocator(n);
 * int param_1 = obj.allocate(size,mID);
 * int param_2 = obj.freeMemory(mID);
 */