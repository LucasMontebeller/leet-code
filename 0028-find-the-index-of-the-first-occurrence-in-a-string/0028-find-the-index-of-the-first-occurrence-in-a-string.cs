public class Solution {
    public int StrStr(string haystack, string needle) {
        var hayStackArray = haystack.ToCharArray();
        var needleArray = needle.ToCharArray();

        if (needle.Length > haystack.Length)
            return -1;
            
        for (int i = 0; i <= hayStackArray.Length - needleArray.Length; i++)
        {
            if (hayStackArray[i] != needleArray[0])
                continue;

            // check next occurrences
            bool allMatch = true;
            for (int j = 1; j < needleArray.Length; j++)
            {
                // no correspondence
                if (hayStackArray[i + j] != needleArray[j])
                {
                    allMatch = false;
                    break;
                }
            }

            if (allMatch)
                return i;
        }

        return -1;
    }
}