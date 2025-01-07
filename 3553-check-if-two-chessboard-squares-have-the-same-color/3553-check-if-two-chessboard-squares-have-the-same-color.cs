public class Solution {
    public bool CheckTwoChessboards(string coordinate1, string coordinate2)
        => (coordinate1[0] - 'a' + coordinate1[1] - '0') % 2 == (coordinate2[0] - 'a' + coordinate2[1] - '0') % 2;
        
}