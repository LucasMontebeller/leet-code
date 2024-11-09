public class Solution {
    public int Reverse(int x) {
        if (!IsValid(x))
            return 0;

        var arrayNumber = ToArray(Math.Abs(x));
        string number = x > 0 ? "" : "-";
        for (int i = arrayNumber.Length - 1; i >= 0; i--)
        {
            var numberAsString = arrayNumber[i].ToString();
            number = String.Concat(number, numberAsString);
        }

        if (int.TryParse(number, out int result))
            return result;

        return 0;
    }

    private bool IsValid(int num)
        => num > Int32.MinValue && num < Int32.MaxValue;

    private static int[] ToArray(int num)
    {
        var arraySize = TotalDigits(num);
        int[] result = new int[arraySize];

        int currentNumber = num;
        for (int i = 0; i < arraySize; i++)
        {
            var n = (arraySize - 1 - i);
            var power = Math.Pow(10,  n);

            var digit = (int)Math.Floor(currentNumber / power);
            currentNumber = (int)(currentNumber % power);

            result[i] = digit;
        }

        return result;
    }

    private static byte TotalDigits(long n)
    {
        if (n >= 0)
        {
            if (n < 10L) return 1;
            if (n < 100L) return 2;
            if (n < 1000L) return 3;
            if (n < 10000L) return 4;
            if (n < 100000L) return 5;
            if (n < 1000000L) return 6;
            if (n < 10000000L) return 7;
            if (n < 100000000L) return 8;
            if (n < 1000000000L) return 9;
            if (n < 10000000000L) return 10;
            if (n < 100000000000L) return 11;
            if (n < 1000000000000L) return 12;
            if (n < 10000000000000L) return 13;
            if (n < 100000000000000L) return 14;
            if (n < 1000000000000000L) return 15;
            if (n < 10000000000000000L) return 16;
            if (n < 100000000000000000L) return 17;
            if (n < 1000000000000000000L) return 18;
            return 19;
        }
        else
        {
            if (n > -10L) return 2;
            if (n > -100L) return 3;
            if (n > -1000L) return 4;
            if (n > -10000L) return 5;
            if (n > -100000L) return 6;
            if (n > -1000000L) return 7;
            if (n > -10000000L) return 8;
            if (n > -100000000L) return 9;
            if (n > -1000000000L) return 10;
            if (n > -10000000000L) return 11;
            if (n > -100000000000L) return 12;
            if (n > -1000000000000L) return 13;
            if (n > -10000000000000L) return 14;
            if (n > -100000000000000L) return 15;
            if (n > -1000000000000000L) return 16;
            if (n > -10000000000000000L) return 17;
            if (n > -100000000000000000L) return 18;
            if (n > -1000000000000000000L) return 19;
            return 20;
        }
    } 
}