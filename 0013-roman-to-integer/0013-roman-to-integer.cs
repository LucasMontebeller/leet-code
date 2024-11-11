public class Solution {
    private static Dictionary<char, int> _romanNumerals = new Dictionary<char, int>()
    {
        { 'I', 1 },
        { 'V', 5 },
        { 'X', 10 },
        { 'L', 50 },
        { 'C', 100 },
        { 'D', 500 },
        { 'M', 1000 }
    };

    private static Dictionary<string, int> _romanNumeralsComposed = new Dictionary<string, int>()
    {
        { "IV", 4 },
        { "IX", 9 },
        { "XL", 40 },
        { "XC", 90 },
        { "CD", 400 },
        { "CM", 900 }
    };

    public int RomanToInt(string s) {
        var charArray = s.ToCharArray();
        int number = 0;
        for (int i = 0; i < charArray.Length; i++)
        {
            var romanKey = charArray[i];
            if (i < charArray.Length - 1)
            {
                var nextRomanKey = charArray[i + 1];
                var keyComposed = new string(new char[] { romanKey, nextRomanKey });

                if (_romanNumeralsComposed.ContainsKey(keyComposed))
                {
                    number += _romanNumeralsComposed[keyComposed];
                    i += 1;
                    continue;
                }
            }
            
            number += _romanNumerals[romanKey];
        }

        return number;
    }
}