/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int val=0, ListNode next=null) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */
public class Solution {
    public bool IsPalindrome(ListNode head) {
        List<int> elements = [];
        var node = head;
        while (true)
        {
            elements.Add(node.val);

            if (node.next is null)
                break;

            node = node.next;
        }

        for (int i = 0; i < elements.Count / 2; i++)
        {
            if (elements[i] != elements[elements.Count - i - 1])
                return false;
        }

        return true;
    }
}