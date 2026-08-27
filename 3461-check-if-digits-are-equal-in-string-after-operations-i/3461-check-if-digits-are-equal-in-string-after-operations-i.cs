public class Solution {
    public bool HasSameDigits(string s) {
        string result = s;
        while (result.Length > 2)
        {
            result = Calculate(result);
        }

        return result[0] == result[1];
    }

    private string Calculate(string s)
    {
       var result = new char[s.Length - 1];
       for (int i = 0; i < s.Length - 1; i++)
       {
            result[i] = SumModulo10(s[i], s[i + 1]);
       }

       return new string(result); 
    }

    private char SumModulo10(char number1, char number2)
    {
        int result = ((number1 - '0') + (number2 - '0')) % 10;
        return (char)(result + '0');
    }
}