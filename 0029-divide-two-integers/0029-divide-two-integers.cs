public class Solution {
    public int Divide(int dividend, int divisor) {

        int signal = (divisor >= 0 && dividend >= 0) || (divisor <= 0 && dividend <= 0) ? 1 : -1;
        int absDividend = dividend < 0 ? -1 * dividend : dividend;
        int absDivisor = divisor < 0 ? -1 * divisor : divisor;

        if (absDivisor == 1)
        {
            if (absDividend == Int32.MinValue)
            {
                return divisor > 0 ? Int32.MinValue : 2147483647;
            }

            return signal * absDividend;
        }

        int sum = 0;
        int cont = 0;
        while (sum <= absDividend - absDivisor)
        {
            if (sum == dividend)
                break;

            sum += absDivisor;
            cont++;
        }

        return signal * cont;
    }
}