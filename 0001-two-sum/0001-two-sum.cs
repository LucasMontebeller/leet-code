public class Solution {
    public int[] TwoSum(int[] nums, int target) {
        int difference = 0;
        for (int i = 0; i < nums.Length - 1; i++)
        {
            if (target > 0)
                difference = target < nums[i] ? target - nums[i] : Math.Abs(nums[i] - target);
            else
                difference = Math.Abs(nums[i]) - Math.Abs(target);
            var j = nums[i] != difference ? Array.IndexOf(nums, difference) : Array.IndexOf(nums, difference, i + 1);

            if (j != -1)
                return new int[2] { i, j };
        }

        return Array.Empty<int>();
    }
}