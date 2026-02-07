class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> wordCountS1 = getWordCounts(s1);
        Map<String, Integer> wordCountS2 = getWordCounts(s2);

        Set<String> intersectionS1 = new HashSet<>();
        for (Map.Entry<String, Integer> entry : wordCountS1.entrySet()) {
            if (entry.getValue() == 1 && !wordCountS2.containsKey(entry.getKey())) {
                intersectionS1.add(entry.getKey());
            }
        }

        Set<String> intersectionS2 = new HashSet<>();
        for (Map.Entry<String, Integer> entry : wordCountS2.entrySet()) {
            if (entry.getValue() == 1 && !wordCountS1.containsKey(entry.getKey())) {
                intersectionS2.add(entry.getKey());
            }
        }

        intersectionS1.addAll(intersectionS2);
        String[] result = intersectionS1.toArray(new String[intersectionS1.size()]);
        return result;
    }



    private Map<String, Integer> getWordCounts(String s) {
        Map<String, Integer> wordCount = new HashMap<>();

        for (String word : s.split("\\s+")) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        return wordCount;
    }

}