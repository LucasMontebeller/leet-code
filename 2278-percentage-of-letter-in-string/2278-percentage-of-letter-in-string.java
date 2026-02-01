class Solution {
    public int percentageLetter(String s, char letter) {
        char[] charArray = s.toCharArray();
        int count = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == letter) {
                count++;
            }
        }
        
        double percentage = ((double) count / charArray.length) * 100;
        return (int) percentage;
    }
}