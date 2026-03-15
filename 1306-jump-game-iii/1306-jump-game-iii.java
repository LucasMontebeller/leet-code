class Solution {
    public boolean canReach(int[] arr, int start) {
        return recursion(arr, start, 0);
    }

    private boolean recursion(int[] arr, int index, int count) {
        if (index < 0 || index > arr.length - 1 || count == arr.length) {
            return false;
        }
        if (arr[index] == 0) {
            return true;
        }

        return recursion(arr, index + arr[index], count++) || recursion(arr, index - arr[index], count++);
    }
}