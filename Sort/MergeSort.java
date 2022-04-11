
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


//mergesort different way 

/* Java program for Merge Sort */
class MergeSort
{
	// Merges two subarrays of arr[].
	// First subarray is arr[l..m]
	// Second subarray is arr[m+1..r]
	void merge(int arr[], int l, int m, int r)
	{
		// Find sizes of two subarrays to be merged
		int n1 = m - l + 1;
		int n2 = r - m;

		/* Create temp arrays */
		int L[] = new int[n1];
		int R[] = new int[n2];

		/*Copy data to temp arrays*/
		for (int i = 0; i < n1; ++i)
			L[i] = arr[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = arr[m + 1 + j];

		/* Merge the temp arrays */

		// Initial indexes of first and second subarrays
		int i = 0, j = 0;

		// Initial index of merged subarray array
		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			}
			else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		/* Copy remaining elements of L[] if any */
		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		/* Copy remaining elements of R[] if any */
		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}

	// Main function that sorts arr[l..r] using
	// merge()
	void sort(int arr[], int l, int r)
	{
		if (l < r) {
			// Find the middle point
			int m =l+ (r-l)/2;

			// Sort first and second halves
			sort(arr, l, m);
			sort(arr, m + 1, r);

			// Merge the sorted halves
			merge(arr, l, m, r);
		}
	}

	/* A utility function to print array of size n */
	static void printArray(int arr[])
	{
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	// Driver code
	public static void main(String args[])
	{
		int arr[] = { 12, 11, 13, 5, 6, 7 };

		System.out.println("Given Array");
		printArray(arr);

		MergeSort ob = new MergeSort();
		ob.sort(arr, 0, arr.length - 1);

		System.out.println("\nSorted array");
		printArray(arr);
	}
}
/* This code is contributed by Rajat Mishra */


