public class Solution {
    public string AddBinary(string a, string b) {
        (a, b) = EquipareStringsLengths(a, b);
        var stackResult = ComputeSum(a, b);

        return PrepareResult(stackResult);
    }

    private static (string a, string b) EquipareStringsLengths(string a, string b)
    {
        int differenceLength = a.Length - b.Length;

        // a > b
        if (differenceLength > 0)
            b = b.PadLeft(b.Length + differenceLength, '0');
        // a < b
        else if (differenceLength < 0)
            a = a.PadLeft(a.Length - differenceLength, '0');

        return (a, b);
    }

    private static Stack<char> ComputeSum(string a, string b)
    {
        Stack<char> stackResult = new Stack<char>(a.Length + 1);

        int index = a.Length - 1;
        int increment = 0;

        while (index >= 0)
        {
            int aNumber = a[index] - '0';
            int bNumber = b[index] - '0';

            int bitwiseXOR = aNumber ^ bNumber ^ increment;
            if (bitwiseXOR == 0)
            {
                if (aNumber + bNumber != 0)
                    increment = 1;

                stackResult.Push('0');
            }
            else
            {
                if (aNumber + bNumber == 0)
                    increment = 0;

                stackResult.Push('1');
            }

            index--;
        }

        if (increment == 1)
            stackResult.Push('1');

        return stackResult;
    }

    private static string PrepareResult(Stack<char> stackResult)
    {
        string result = "";
        foreach (char c in stackResult)
        {
            result += c;
        }

        return result;
    }
}