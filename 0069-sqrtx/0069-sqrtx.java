class Solution {
    public int mySqrt(int x) {
        int root = 1;
        while (true) {
            if (x - (root * root) < 0) {
                return root - 1;
            }

            root++;
        }
    }
}