public class Solution {

    private readonly HashSet<int> _primeNumbers;

    public Solution()
    {
        _primeNumbers = GetPrimeNumbersBefore(1000);
    }

    public int DistinctPrimeFactors(int[] nums) {
        HashSet<int> result = new();
        for (int i = 0; i < nums.Length; i++)
        {
            result.UnionWith(GetPrimeDivisors(nums[i]));
        }

        return result.Count;
    }

    private HashSet<int> GetPrimeDivisors(int n)
    {
        if (_primeNumbers.Contains(n))
            return new HashSet<int> { n };

        HashSet<int> result = new();
        for (int i = 2; i <= (n / 2); i++)
        {
            if (n % i == 0)
            {
                result.UnionWith(GetPrimeDivisors(n / i));
            }
        }

        return result;
    }

    private static HashSet<int> GetPrimeNumbersBefore(int n)
    {
        HashSet<int> result = new() { 2 };
        for (int i = 3; i < n; i++)
        {
            if (IsPrime(i))
                result.Add(i);
        }

        return result;
    }

    private static bool IsPrime(int n)
    {
        for (int i = 2; i <= (n / 2); i++)
        {
            if (n % i == 0)
                return false;
        }

        return true;
    }
}