import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLnkLst {

    //Merge k Sorted Singly Linked Lists


        class SinglyLinkedListNode {
            public int data;
            public SinglyLinkedListNode next;

            public SinglyLinkedListNode(int nodeData) {
                this.data = nodeData;
                this.next = null;
            }
        }




    public static SinglyLinkedListNode merge_k_lists(List<SinglyLinkedListNode> lists) {

        if (lists.size() == 1) return lists.get(0);
        if (lists.size() == 0) return null;

        SinglyLinkedListNode head = null;
        SinglyLinkedListNode tail = null;

        PriorityQueue<SinglyLinkedListNode> minHeap = new PriorityQueue<>(lists.size(), (n1, n2) -> n1.data - n2.data);

        for (SinglyLinkedListNode node : lists) {
            if (node != null) {
                minHeap.add(node);
            }
        }

        while (!minHeap.isEmpty()) {
            SinglyLinkedListNode cur = minHeap.remove();

            if (head == null) {
                head = cur;
                tail = cur;
            } else {
                tail.next = cur;
                tail = tail.next;
            }
            if (cur.next != null) {
                minHeap.offer(cur.next);
            }

        }

        return head;

    }
}
