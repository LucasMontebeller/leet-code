class Solution {
    public boolean isPalindrome(String s) {
        char[] charArray = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase().toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] != charArray[charArray.length -1 -i]) {
                return false;
            }
        }
        return true;
    }
}