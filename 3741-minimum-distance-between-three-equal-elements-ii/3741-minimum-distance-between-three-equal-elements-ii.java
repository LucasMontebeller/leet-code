class Solution {
    public int minimumDistance(int[] nums) {
        HashMap<Integer, List<Integer>> numIndexOccurences = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> indexOccurences = numIndexOccurences.getOrDefault(nums[i], new ArrayList<Integer>());
            indexOccurences.add(i);
            numIndexOccurences.put(nums[i], indexOccurences);
        }

        int minimumDistance = Integer.MAX_VALUE;
        for (List<Integer> indexOccurences : numIndexOccurences.values()) {
            if (indexOccurences.size() < 3) { // not a good tuple
                continue;
            }

            int distance = getMinimumDistanceOfCombinations(indexOccurences);
            if (distance < minimumDistance) {
                minimumDistance = distance;
            }
        }

        // no good tuples found
        if (minimumDistance == Integer.MAX_VALUE) {
            return -1;
        }

        return minimumDistance;
    }

    private int getMinimumDistanceOfCombinations(List<Integer> indexOccurences) {
        int minimumDistance = Integer.MAX_VALUE;

        for (int i = 0; i <= indexOccurences.size() - 3; i++) {
            int first = indexOccurences.get(i);
            int third = indexOccurences.get(i + 2);

            int distance = 2 * (third - first);

            if (distance < minimumDistance) {
                minimumDistance = distance;
            }
        }

        return minimumDistance;
    }
}