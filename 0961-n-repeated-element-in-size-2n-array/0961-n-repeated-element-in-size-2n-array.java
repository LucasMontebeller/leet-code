import java.util.HashSet;

class Solution {
    public int repeatedNTimes(int[] nums) {
        Set<Integer> numsFounded = new HashSet<Integer>();
        for (int i = 0; i <= nums.length; i++) {
            if (!numsFounded.add(nums[i])) {
                return nums[i];
            }
        }

        return 1;
    }
}