public class RemoveNthNode {
//leetcode 19; Given the head of a linked list, remove the nth node from the end of the list and return its head.

    // important constrain that make this program works: 1 <= n <= sz
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode sentinel = new ListNode(-1, head);
            ListNode leader = sentinel;

            int k = n;
            while(k>0) {
                leader = leader.next;
                k--;
            }
            ListNode follower = head;
            ListNode pred = sentinel;

            while(leader != null ) {
                pred = follower;
                follower = follower.next;
                leader = leader.next;
            }
            pred.next = follower.next;
            return sentinel.next;
        }


    }
}
