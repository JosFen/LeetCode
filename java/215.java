// heap sort: O(nlogk)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) minHeap.poll();
        }
        return minHeap.peek();
    }
}

// Quick Select (randomized pivot): O(n) average -> O(n^2) worst, e.g., for all equal numbers
class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    private int quickSelect(int[] nums, int l, int r, int k) {
        int randomIdx = new Random().nextInt(r - l + 1) + l;
        swap(nums, randomIdx, r); // swap randomly picked pivot to the rightmost place

        int pivot = nums[r];
        int cursor = l; // points to where the next number to be swapped if that number >= pivot 

        for (int i = l; i < r; i++) { // compare all numbers from index l to r-1
            if (nums[i] >= pivot) swap(nums, cursor++, i); // increment cursor too next position after swap
        }
        swap(nums, cursor, r); // swap pivot to the left

        int count = cursor - l + 1; // count the number of elements recursed to the left side
        if (count == k) return nums[cursor]; // kth largest found
        if (count > k) return quickSelect(nums, l, cursor - 1, k); 
        return quickSelect(nums, cursor + 1, r, k - count); // look for remaining k-count largest numbers if count < k
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

