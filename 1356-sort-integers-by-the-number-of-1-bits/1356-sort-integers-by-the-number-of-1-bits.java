class Solution {
    public int[] sortByBits(int[] arr) {
        int minIndex;
        for (int i = 0; i < arr.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (numberOfOneBits(arr[j]) < numberOfOneBits(arr[minIndex]) ||
                    (numberOfOneBits(arr[j]) == numberOfOneBits(arr[minIndex]) 
                        && arr[j] < arr[minIndex])) {
                        minIndex = j;
                    }
            }

            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp; 
        }

        return arr;
    }

    private int numberOfOneBits(int number) {
        int result = 0;
        while (number > 0) {
            result += number % 2;
            number /= 2;
        }

        return result;
    }
}