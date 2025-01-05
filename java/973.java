class Solution {
    private int squaredDist(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    // using Quick Select: O(n) on average
    public int[][] kClosest(int[][] points, int k)  {
        quickSelect(points, 0, points.length - 1, k);
        return Arrays.copyOf(points, k);
    }

    private void quickSelect(int[][] points, int l, int r, int k) {
        final int randIndex = new Random().nextInt(r - l + 1) + l;
        swap(points, randIndex, r);
        final int[] pivot = points[r];

        int nextSwapped = l;
        for (int i = l; i < r; ++i) {
            if (squaredDist(points[i]) <= squaredDist(pivot)) {
                swap(points, nextSwapped++, i);
            }
        }
        swap(points, nextSwapped, r);

        final int count = nextSwapped - l + 1; // the number of points <= pivot
        if (count == k) return;
        if (count > k) quickSelect(points, l, nextSwapped - 1, k);
        else quickSelect(points, nextSwapped + 1, r, k - count);
    }

    private void swap(int[][] points, int i, int j) {
        final int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }

 //  ---------------------------------------------------------
    // using Arrays,  time: nlog(n):
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, (a, b) -> squaredDist(a) - squaredDist(b));
        return Arrays.copyOf(points, k); // return sublist of smallest k points
    }

    // using minHeap: time klog(n):
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((p1, p2) -> (squaredDist(p1) - squaredDist(p2)));

        for (int[] point : points) minHeap.offer(point);
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) result[i] = minHeap.poll();

        return result;
    }

    // using maxHeap, time: nlog(k):
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((p1, p2) -> (squaredDist(p2) - squaredDist(p1)));

        for (int[] point : points) {
            maxHeap.offer(point);
            // remove extra point beyong kth point which is farthest:
            if (maxHeap.size() > k) maxHeap.poll(); 
        }
        return maxHeap.toArray(new int[k][2]);
    }
}

