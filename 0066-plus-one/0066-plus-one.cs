public class Solution {
    public int[] PlusOne(int[] digits) {
        if (digits[^1] != 9)
        {
            digits[^1] += 1;
            return digits;
        }
        else
        {
            int size = digits.Length + 1;
            for (int i = 0; i < digits.Length; i++)
            {
                if (digits[i] != 9)
                {
                    size = digits.Length;
                    break;
                }
            }

            int[] newDigits = new int[size];
            bool sumNext = true;
            for (int i = digits.Length - 1; i >= 0; i--)
            {
                if (digits[i] == 9 && sumNext)
                {
                    if (i > 0)
                        continue;

                    newDigits[i] = 1;
                }
                else
                {
                    newDigits[i] = digits[i] + (sumNext ? 1 : 0);
                    sumNext = false;
                }
            }

            return newDigits;
        }
    }
}