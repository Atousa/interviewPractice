public class MiddleNode {

    class ListNode {
        int value;
        ListNode next;

        ListNode(int value) {
            this.value = value;
            this.next = null;

        }

    }

        public static ListNode middleNode(ListNode head) {

            if (head == null || head.next == null) return head;

            ListNode slow = head;
            ListNode fast = head;

            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            if (fast.next == null) {
                return slow;
            } else
                return slow.next;

        }
    }

