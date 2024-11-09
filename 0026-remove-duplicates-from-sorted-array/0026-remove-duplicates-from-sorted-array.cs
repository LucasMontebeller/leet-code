public class Solution {
    public int RemoveDuplicates(int[] nums) {
        HashSet<int> memory = [];
        for (int i = 0; i < nums.Length; i++)
        {
            memory.Add(nums[i]);
        }

        var k = memory.Count;

        var memoryEnumerator = memory.GetEnumerator();
        memoryEnumerator.MoveNext();
        for (int i = 0; i < memory.Count; i++)
        {
            nums[i] = memoryEnumerator.Current;
            memoryEnumerator.MoveNext();
        }

        return k;
    }
}