class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> result = getCommonStrings(list1, list2);
        return toArray(result);
    }

    private static List<String> getCommonStrings(String[] list1, String[] list2) {
        return list1.length > list2.length ? getCommonStringsByLength(list2, list1) : getCommonStringsByLength(list1, list2);
    }

    private static List<String> getCommonStringsByLength(String[] shortestList, String[] biggestList) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> stringIndexMap = mapUniqueWordsToIndex(shortestList);
        System.out.println(stringIndexMap);

        int leastIndexSum = 10000000;
        for (int i = 0; i < biggestList.length; i++) {
            var j = stringIndexMap.getOrDefault(biggestList[i], 10000000);
            if (i + j < leastIndexSum) {
                result = new ArrayList<String>();
                result.add(biggestList[i]);
                leastIndexSum = i + j;
            }
            else if (i + j == leastIndexSum) {
                result.add(biggestList[i]);;
            }
        }

        return result;
    }

    private static Map<String, Integer> mapUniqueWordsToIndex(String[] shortestList) {
        Map<String, Integer> result = new HashMap<>();
        for (int i = 0; i < shortestList.length; i++) {
            result.put(shortestList[i], i);
        }
        return result;
    }

    private static String[] toArray(List<String> list) {
        String[] result = new String[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}