public class MergeSort {
    public static ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode mid = FindMid.findMid(head);
        ListNode next = mid.next;
        mid.next = null;

        ListNode left = (mergeSort(head));
        ListNode right = mergeSort(next);

        return merge(left, right);
    }

//  21 leetcode , merge two sorted list
    //TC = O(m +n)
    //SC = O(1)
    private static ListNode merge(ListNode left, ListNode right) {
        ListNode sentinel = new ListNode(-1,null);
        ListNode tail = sentinel;

        while(left!= null && right!=null) {
            if(left.val <= right.val) {
                tail.next = left;
                left=left.next;
                tail = tail.next;
                tail.next = null;
            } else {
                tail.next = right;
                right = right.next;
                tail = tail.next;
                tail.next = null;
            }
        }

        if(left!= null) {
            tail.next = left;

        } else if (right!= null)
            tail.next = right;

        return sentinel.next;
    }

    public static ListNode findMid(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slowRunner = head;
        ListNode fastRunner = head;
        while (fastRunner != null && fastRunner.next != null) {
            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next.next;
        }
        return slowRunner;
    }

//    public static void main(String[] args) {
//
//    }
}



