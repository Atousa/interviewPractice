import java.util.Arrays;
//https://www.youtube.com/watch?v=t0Cq6tVNRBA

// insert and delete logn and build is 0(n) if we build this way , if we need to insert n item then the
//complexity is nlogn and to build is o(n) then the total complexity is still nlogn
// it is in-place  and not stable because we do long range swap.
public class MaxHeap {
    private int item[];
    private int size;
    private int capacity;

    public int[] getItem() {
        return item;
    }

    public void setItem(int[] item) {
        this.item = item;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public MaxHeap(int capacity) {
        this.item = new int[capacity];
        this.size =0;
        this.capacity = capacity;
    }

    public MaxHeap(int[] arr) {
        this.item = arr.clone();
        this.size = arr.length;
        this.capacity = arr.length;
    }
    //complexity n
    public void buildMaxHeap(int[] arr) {
        int len = arr.length;
        for(int i = len-1; i >=0;i--) {
            heapifyUpOneLevel(arr,i);
        }
    }

    private void heapifyUpOneLevel(int[] arr, int fromIdx) {
        int parentIdx = fromIdx / 2;
        if (parentIdx >= 0) {
            if (arr[parentIdx] < arr[fromIdx]) {
                swap(parentIdx, fromIdx);
                heapifyDown(parentIdx);
            }
        }
    }


    private int getLeftChild(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private int getRightChild(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    private int getParent(int childIndex) {
        return (childIndex - 2) / 2;
    }

    private boolean hasParent(int childIndex) {
        return getParent(childIndex) >= 0;
    }

    private boolean hasLeftChild(int parentIndex) {
        return (2 * parentIndex + 1) < size;
    }

    private boolean hasRightChild(int parentIndex) {
        return (2 * parentIndex + 2 < size);
    }


    private boolean ensureExtraCapacity() {
        return (getSize() != getCapacity());
    }

    private void swap(int idx1, int idx2) {
        int temp = item[idx1];
        item[idx1] = item[idx2];
        item[idx2] = temp;
    }

    public int peek() {
        if (size == 0) throw new IllegalStateException();
        return item[0];
    }

    public int poll() {
        if (size == 0) throw new IllegalStateException();
        int maxElement = item[0];
        swap(0,size-1);
        size--;
        heapifyDown(0);
        return maxElement;
    }

    public void insert(int element) {
        if(ensureExtraCapacity()) {
            item[size] = element;
            heapifyUp(size);
            size++;
        }
    }

    private void heapifyUp(int fromIdx) {
        while (hasParent(fromIdx)) {
            if(item[getParent(fromIdx)] > item[fromIdx])
                swap(getParent(fromIdx), fromIdx);
            fromIdx = getParent(fromIdx);
        }
    }

    private void heapifyDown(int fromIdx) {
        int biggerChildIdx = fromIdx;
        while (fromIdx < size && getLeftChild(fromIdx) < size && hasLeftChild(fromIdx)) {
            int leftChildIdx = getLeftChild(fromIdx);
            if (hasRightChild(fromIdx) && item[getRightChild(fromIdx)] > item[leftChildIdx])
                biggerChildIdx = getRightChild(fromIdx);
            if (item[fromIdx] > item[biggerChildIdx]) break;
            swap(fromIdx, biggerChildIdx);
            fromIdx = biggerChildIdx;
        }
    }

}


