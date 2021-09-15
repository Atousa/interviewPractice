public class InsertionSortList {

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

        public ListNode insertionSortList(ListNode head) {

            ListNode sentinel = new ListNode(-1,null);
            ListNode cur1 = head;
            ListNode succ = cur1;

            while(cur1 != null) {
                succ = cur1.next;
                cur1.next = null;

                ListNode pred = sentinel;
                ListNode cur2 = pred.next;

                while(cur2 != null && cur1.val> cur2.val) {
                    pred = cur2;
                    cur2= cur2.next;

                }

                cur1.next = cur2;
                pred.next = cur1;

                cur1 = succ;

            }
            return sentinel.next;

        }
    }





