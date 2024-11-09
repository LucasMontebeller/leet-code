public class Solution {
    public string LongestCommonPrefix(string[] strs) {
       var prefix = "";

       Array.Sort(strs, (x, y) => x.Length.CompareTo(y.Length));
       var firstStringArray = strs[0].ToCharArray();
       for (int i = 0; i <= firstStringArray.Length - 1; i++)
       {
            var charElement = firstStringArray[i];
            if (!Array.TrueForAll(strs, x => x.ElementAt(i) == charElement))
                break;
            
            prefix = string.Concat(prefix, charElement);
       }

       return prefix;
    }
}