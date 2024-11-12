/* 
Time Complexity
The time complexity is O(log(n - k) + k), where:
  O(log(n - k)) is the time complexity of the binary search.
  O(k) is the time to collect the k closest elements.
*/
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();

        int l = 0;
        int r = arr.length - k;

        // determine the smallest index l such that the subarray starting from l with length k will contain the closest elements to x
        while (l < r) { 
            int mid = (l + r) >>> 1;
            if (x - arr[mid] > arr[mid + k]- x) l = mid + 1;
            else r = mid; // k closest elements could be within the current subarray starting at or before mid
        }

        while (k > 0) {
            result.add(arr[l++]);
            k--;
        }

        return result;

    }
}
