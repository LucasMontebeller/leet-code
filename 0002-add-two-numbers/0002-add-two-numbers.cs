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
    public ListNode AddTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new();
        ListNode current = result;

        bool addNextOne = false;
        while (l1 is not null || l2 is not null || addNextOne)
        {
            int val1 = l1?.val ?? 0;
            int val2 = l2?.val ?? 0;
            int sum = val1 + val2 + (addNextOne ? 1 : 0);

            if (sum >= 10)
            {
                sum -= 10;
                addNextOne = true;
            }
            else
                addNextOne = false;

            current.next = new(sum);
            current = current.next;

            l1 = l1?.next;
            l2 = l2?.next;
        }

        return result.next;
    }
}