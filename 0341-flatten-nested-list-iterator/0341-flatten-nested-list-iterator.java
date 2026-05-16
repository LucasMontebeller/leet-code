/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    private final List<Integer> list;
    private int currentIndex = 0;

    public NestedIterator(List<NestedInteger> nestedList) {
        list = new ArrayList<>();
        fillRecursive(nestedList, list);
    }

    @Override
    public Integer next() {
       var result = list.get(currentIndex);
       currentIndex++;
       return result;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < list.size();
    }

    private void fillRecursive(List<NestedInteger> nestedSubList, List<Integer> result) {
        for (NestedInteger nested : nestedSubList) {
            if (nested.isInteger()) {
                result.add(nested.getInteger());
            }

            fillRecursive(nested.getList(), result);
        }
    }

}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */