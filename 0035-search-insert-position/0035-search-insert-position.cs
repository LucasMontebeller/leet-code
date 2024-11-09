public class Solution {
    public int SearchInsert(int[] nums, int target) {
        HashSet<int> uniqueNums = new HashSet<int>(nums);
        int pos = -1;
        foreach (var uniqueNum in uniqueNums)
        {
            pos++;
            if (uniqueNum >= target)
                return pos;
        }

        return uniqueNums.Count;
    }
}