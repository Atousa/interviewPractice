
import java.util.ArrayList;
import java.util.List;
// divide-solve-combine (divide and conquer strategy)
//time complexity (cn + nlogn) = o(nlogn) in all the cases is the same
// space complexity (o(n))
// not in-place and  it is stable
public class MergeSort {
    public static void mergeSort(int[] arr) {
        int len = arr.length;
        mergeSortHelper(arr, 0, len - 1);
    }

    private static void mergeSortHelper(int[] arr, int s, int e) {
        if (s >= e) return;

        int mid = s + ((e - s) / 2);
        mergeSortHelper(arr, s, mid);
        mergeSortHelper(arr, mid + 1, e);
        merge(arr, s, mid, e);
    }

    private static void merge(int[] arr, int s, int m, int e) {
        int[] auxArr = new int[e-s+1];
        int k = 0;
        int start = s;
        int s2 = m+1;

        while ( s <= m && s2 <= e) {
            if (arr[s] < arr[s2])
                auxArr[k++] = arr[s++];
            else
                auxArr[k++] = arr[s2++];
        }

        while(s <= m)
            auxArr[k++] = arr[s++];
        while(s2 <= e) {
            auxArr[k++] = arr[s2++];
        }

        System.arraycopy(auxArr, 0, arr,start,e-start+1);
    }

    public static List<Integer> mergeSortedArray(List<Integer> lst, int start, int end) {

        if (start == end) {
            List<Integer> tempList = new ArrayList<>();
            tempList.add(lst.get(start));
            return tempList;
        }

        int mid = start + (end - start) / 2;

        List<Integer> leftList = mergeSortedArray(lst, start, mid);
        List<Integer> rightList = mergeSortedArray(lst, mid + 1, end);

        int leftCur = 0;
        int rightCur = 0;

        List<Integer> resultTemp = new ArrayList<>();

        while (leftCur < leftList.size() && rightCur < rightList.size()) {
            if (leftList.get(leftCur) > rightList.get(rightCur)) {
                resultTemp.add(rightList.get(rightCur++));
            } else {
                resultTemp.add(leftList.get(leftCur++));
            }
        }
        while (leftCur < leftList.size()) {
            resultTemp.add(leftList.get(leftCur++));
        }

        while (rightCur < rightList.size()) {
            resultTemp.add(rightList.get(rightCur++));
        }
        return resultTemp;
    }

    public static void main(String[] args) {
        int[] a = {23,22,15,16,13};
        mergeSort(a);
        for(int i=0; i < a.length; i++) {
            System.out.print(a[i]);
            System.out.print(",");
        }
        System.out.println("");
        List<Integer> ls = new ArrayList<>();
        ls.add(4);
        ls.add(1);
        ls.add(1);
        ls.add(3);
        ls.add(-2);

        ls = mergeSortedArray(ls,0, ls.size()-1);
        System.out.println(ls);

    }

}



