public class MergeKSortedList {
    // leetcode 23
//    You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
//
//    Merge all the linked-lists into one sorted linked-list and return it.
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
        public ListNode mergeKLists(ListNode[] lists) {
            ListNode sentinel = new ListNode(-1,null);
            ListNode tail = sentinel;

            PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> (a.val - b.val));


            //head of the lists we have
            for(int i=0;i<lists.length;i++)
            {
                if(lists[i] != null)
                    pq.add(lists[i]);
            }

            while(!pq.isEmpty()) {
                ListNode temp = pq.poll();
                tail.next = temp;
                temp = temp.next;
                tail= tail.next;
                tail.next = null;
                if(temp!= null)
                    pq.add(temp);
            }
            return sentinel.next;

        }
    }

}
