// Bucket sort: Time Complexity: O(n), Space Complexity: O(k), k is the range; Untable
class Solution {
    public int[] sortArray(int[] nums) {
        if (nums.length == 1) return nums;

        int largest = nums[0], smallest = nums[0];
        for (int n : nums) {
            largest = Math.max(largest, n);
            smallest = Math.min(smallest, n);
        }

        int range = largest - smallest + 1;
        int[] count = new int[range];
        for (int n : nums) {
            count[n - smallest]++;
        }

        int i = 0;
        for (int j = 0; j < range; j++) {
            while (count[j] > 0) {
                nums[i++] = j + smallest;
                count[j]--;
            }
        }
        return nums;
    }
}

//  Merge sort (Bottom-up): Time Complexity: O(nlog(n)), Space Complexity: O(n); Stable
class Solution {
    public int[] sortArray(int[] nums) {
        if (nums.length == 1) return nums;
        mergeSort(nums, 0, nums.length-1);
        return nums;
    }

    private static void mergeSort(int[] nums, int l, int r) {
        if (l < r) {
            int mid = (l+r)/2;
            mergeSort(nums, l, mid);
            mergeSort(nums, mid+1, r);
            merge(nums, l, mid, r);
        } 
    }

    private static void merge(int[] nums, int l, int mid, int r) {
        int len1 = mid - l + 1;
        int len2 = r - mid;

        int[] tmpArr1 = new int[len1];
        int[] tmpArr2 = new int[len2];
        for (int i = 0; i < len1; i++) {
            tmpArr1[i] = nums[l+i];
        }
        for (int j = 0; j < len2; j++) {
            tmpArr2[j] = nums[mid+1+j];
        }

        int i = 0, j = 0, ptr = l;
        while (i < len1 && j < len2) {
            if (tmpArr1[i] <= tmpArr2[j]) nums[ptr++] = tmpArr1[i++];
            else nums[ptr++] = tmpArr2[j++];
        }
        while (i < len1) nums[ptr++] = tmpArr1[i++];
        while (j < len2) nums[ptr++] = tmpArr2[j++];
    }
}


// Heap sort: Time Complexity: O(nlog(n)), Space Complexity: O(1); Untable
class Solution {
    public int[] sortArray(int[] nums) {
        heapSort(nums);
        return nums;
    }

    private void heapSort(int[] nums) {
        buildHeap(nums);
        int size = nums.length;
        for (int i = nums.length - 1; i > 0; i--) {
            swap(nums, i, 0);
            size--;
            maxHeapify(nums, size, 0);
        }
    }

    private void buildHeap(int[] nums) {
        for (int i = nums.length/2; i >= 0; i--) {
            maxHeapify(nums, nums.length, i);
        }
    }

    private void maxHeapify(int[] nums, int size, int key) {
        int lc = 2 * key + 1;
        int rc = 2 * key + 2;
        int maxKey = key;

        if (lc < size && nums[lc] > nums[maxKey]) maxKey = lc;
        if (rc < size && nums[rc] > nums[maxKey]) maxKey = rc;

        if (maxKey != key) {
            swap(nums, maxKey, key);
            maxHeapify(nums, size, maxKey);
        }
    }

    private void swap(int[] A, int i, int j) {
        final int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}

// Quick sort: Time Complexity: O(nlog(n)), Space Complexity: O(1); Untable, In-place
class Solution {
  public int[] sortArray(int[] nums) {
    quickSort(nums, 0, nums.length - 1);
    return nums;
  }

  private void quickSort(int[] A, int l, int r) {
    if (l >= r) return;

    final int m = partition(A, l, r);
    quickSort(A, l, m - 1);
    quickSort(A, m + 1, r);
  }

  private int partition(int[] A, int l, int r) {
    final int randIndex = new Random().nextInt(r - l + 1) + l;
    swap(A, randIndex, r); // swap the pivot number to the end
    final int pivot = A[r];
    int nextSwapped = l;
    for (int i = l; i < r; ++i) {
      if (A[i] <= pivot) swap(A, nextSwapped++, i);
    }
    swap(A, nextSwapped, r);
    return nextSwapped;
  }

  private void swap(int[] A, int i, int j) {
    final int temp = A[i];
    A[i] = A[j];
    A[j] = temp;
  }
}



// Insertion sort: Time Complexity: O(n^2), Space Complexity: O(1); Stable, In-place
class Solution {
    public int[] sortArray(int[] nums) {
        if (nums.length == 1) return nums;

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            int j = i - 1;
            while (j >= 0 && curr < nums[j]) {
                nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = curr;
        }
        return nums;
    }
}
