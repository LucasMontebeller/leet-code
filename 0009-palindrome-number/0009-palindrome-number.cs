public class Solution {
    public bool IsPalindrome(int x) {
        char[] splitNumbers = x.ToString().ToCharArray();
        var arrayLength = splitNumbers.Length;
        for (int i = 0; i < arrayLength / 2; i++)
        {
            if (splitNumbers[i] != splitNumbers[arrayLength - (i + 1)])
                return false;
        }

        return true;
    }
}