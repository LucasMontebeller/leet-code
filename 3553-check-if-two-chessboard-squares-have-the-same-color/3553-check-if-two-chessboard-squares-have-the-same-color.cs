public class Solution {
    private readonly static char[] _alphabet = "abcdefgh".ToCharArray();

    public bool CheckTwoChessboards(string coordinate1, string coordinate2) {
        var letterIndex1 = Array.IndexOf(_alphabet, coordinate1[0]);
        var letterIndex2 = Array.IndexOf(_alphabet, coordinate2[0]);

        return (letterIndex1 + coordinate1[1] - '0') % 2 == (letterIndex2 + coordinate2[1] - '0') % 2;
    }
}