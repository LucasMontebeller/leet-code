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
        Dictionary<int, int> positionValue = [];

        var node = head;
        var position = 0;
        while (true)
        {
            positionValue.Add(position, node.val);
            if (node.next is null)
                break;

            node = node.next;
            position++;
        }

        for (int i = 0; i < positionValue.Count / 2; i++)
        {
            if (positionValue[i] != positionValue[positionValue.Count - i - 1])
                return false;
        }

        return true;
    }
}