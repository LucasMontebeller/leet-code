public class Solution {
    private readonly static Dictionary<char, int> _alphabet = new()
    {
        { 'a', 0 }, { 'b', 1 }, { 'c', 2 }, { 'd', 3 },
        { 'e', 4 }, { 'f', 5 }, { 'g', 6 }, { 'h', 7 },
    };


    public bool CheckTwoChessboards(string coordinate1, string coordinate2)
    {
        _alphabet.TryGetValue(coordinate1[0], out var letterIndex1);
        _alphabet.TryGetValue(coordinate2[0], out var letterIndex2);

        return (letterIndex1 + coordinate1[1] - '0') % 2 == (letterIndex2 + coordinate2[1] - '0') % 2;
    }
        
}