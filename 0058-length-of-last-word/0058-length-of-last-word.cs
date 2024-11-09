public class Solution {
    public int LengthOfLastWord(string s) {
        char[] charString = s.ToCharArray();
        int cont = 0;
        for (int i = charString.Length - 1; i >= 0; i--)
        {
            if (charString[i] != ' ')
                cont++;

            if (cont > 0 && charString[i] == ' ')
                break;
        }

        return cont;
    }
}