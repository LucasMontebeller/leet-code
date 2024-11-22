public class Solution {
    public double MyPow(double x, int n) {
        if (Math.Round(x, 4) == 0)
            return 0;

        if (n >= int.MaxValue / 2)
            return x;

        if (n <= int.MinValue / 2)
            return Math.Abs(x) == 1 ? Math.Abs(x) : 0;
        
        bool isFrac = false;
        if (n < 0)
        {
            isFrac = true;
            n = -n; // abs
        }

        // Compute
        double result = 1;
        for (int i = 1; i <= n; i++)
        {
            result *= x;
        }

        return isFrac ? 1 / result : result;
    }
}