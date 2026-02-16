class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> frequencies = new HashMap<Integer, Integer>();
        int maxFrequency = 0;
        for (int i = 0; i < nums.length; i++) {
            int frequency = frequencies.getOrDefault(nums[i], 0) + 1;
            frequencies.put(nums[i], frequency);
            if (frequency > maxFrequency) {
                maxFrequency = frequency;
            }
        }

        int result = 0;
        for (int frequency : frequencies.values()) {
            if (frequency != maxFrequency) {
                continue;
            }
            result += frequency;
        }

        return result;
    }
}