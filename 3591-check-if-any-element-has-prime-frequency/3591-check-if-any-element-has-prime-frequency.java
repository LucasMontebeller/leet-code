class Solution {
    public boolean checkPrimeFrequency(int[] nums) {
        HashMap<Integer, Integer> frequencies = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int frequency = frequencies.getOrDefault(nums[i], 0) + 1;
            frequencies.put(nums[i], frequency);
        }

        // System.out.println(frequencies);
        for (int frequency : frequencies.values()) {
            // System.out.println(frequency);
            if (isPrime(frequency)) {
                return true;
            }
        }

        return false;
    }

    private boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }

        for (int i = 2; i <= num / 2; i++) {
            if ((num % i) == 0) {
                return false;
            }
        }

        return true;
    }
}