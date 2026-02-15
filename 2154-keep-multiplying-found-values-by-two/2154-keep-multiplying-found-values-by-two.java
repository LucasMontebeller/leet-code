class Solution {
    public int findFinalValue(int[] nums, int original) {
        Set<Integer> setNumbers = new HashSet<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            setNumbers.add(nums[i]);
        }

        while (setNumbers.contains(original)) {
            original *= 2;
        }

        return original;
    }
}