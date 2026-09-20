/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode DetectCycle(ListNode head) {
        HashSet<ListNode> appearances = new HashSet<ListNode>();
        while (head != null)
        {
            if (appearances.Contains(head))
            {
                return head;
            }

            appearances.Add(head);
            head = head.next;
        }

        return null;
    }
}