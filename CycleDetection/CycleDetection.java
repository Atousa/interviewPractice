public class CycleDetection {

    class ListNode {
        int value;
        ListNode next;

        ListNode(int value) {
            this.value = value;
            this.next = null;

        }

    }

    public static boolean hasCycle(ListNode head) {

        if (head == null) return false;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public static int lengthOfCycle(ListNode head) {

        if (head == null) return 0;
        ListNode slow = head;
        ListNode fast = head;
        int len = 1;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                while (fast != slow) {
                    slow = slow.next;
                    len++;
                }
                return len;
            }
        }
        return 0;
    }

    public static ListNode beginningOfCycle(ListNode head) {
        if (head == null) return null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                ListNode temp = head;
                while (head != slow) {
                    slow = slow.next;
                    temp = temp.next;
                }
                return temp;
            }
        }
        return null;
    }
}







