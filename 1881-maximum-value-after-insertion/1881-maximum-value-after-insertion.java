class Solution {
    public String maxValue(String n, int x) {
        boolean isPositive = n.charAt(0) != '-';
        int i = isPositive 
            ? findBestIndexForPositiveNumber(n, x) 
            : findBestIndexForNegativeNumber(n, x);

        return n.substring(0, i) + (char)(x + '0') + n.substring(i);
    }

    private int findBestIndexForPositiveNumber(String n, int x) {
        int i;
        for (i = 0; i < n.length(); i++) {
            if (x > n.charAt(i) - '0') {
                break;
            }
        }

        return i;
    }

    private int findBestIndexForNegativeNumber(String n, int x) {
        int i;
        for (i = 1; i < n.length(); i++) {
            if (x < n.charAt(i) - '0') {
                break;
            }
        }
        
        return i;
    }
}