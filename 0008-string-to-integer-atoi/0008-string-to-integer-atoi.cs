public class Solution {
    public int MyAtoi(string s) {
        var charArray = s.ToCharArray();
        List<int> numberStack = [];

        int result = 0;
        int signal = 0;
        bool leftZero = false;
        for (int i = 0; i < charArray.Length; i++)
        {
            if (IsWhiteSpace(charArray[i]))
            {
                if (leftZero || numberStack.Count > 0)
                    break;
                
                if (signal != 0)
                    return result;
                    
                continue;
            }

            if (IsSignal(charArray[i]))
            {
                if (numberStack.Count > 0 || signal != 0 || leftZero)
                    // return result;
                    break;

                signal = IsNegative(charArray[i]) ? -1 : 1;
                continue;
            }
            else if (!IsNumber(charArray[i]))
                break;
            else if (ToNumber(charArray[i]) == 0 && numberStack.Count == 0)
            {
                leftZero = true;
                continue;
            }

            numberStack.Add(ToNumber(charArray[i]));
        }

        if (signal == 0)
            signal = 1;

        // if (IsLong(numberStack.Count))
        //     return signal > 0 ? int.MaxValue : int.MinValue;

        foreach (var number in numberStack)
        {
            if (result > int.MaxValue / 10 || (result == int.MaxValue / 10 && number > int.MaxValue % 10))
                return signal > 0 ? int.MaxValue : int.MinValue;

            result = result * 10 + number;
        }

        return signal * result;
    }

    private static bool IsLong(int lenght)
        => lenght > 10;

    private static bool IsWhiteSpace(char c)
        => c == ' ';

    private static bool IsNumber(char c)
    {
        var number = ToNumber(c);
        return number >= 0 && number <= 9;
    }

    private static int ToNumber(char c)
        => c - '0';

    private static bool IsSignal(char c)
        => IsNegative(c) || IsPositive(c);

    private static bool IsNegative(char c)
        => c == '-';

    private static bool IsPositive(char c)
        => c == '+';
}