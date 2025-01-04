// min-heap:
class KthLargest {
    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.minHeap = new PriorityQueue<>(k); // create a min-heap of k size
        this.k = k;
        for (int n : nums) add(n);
    }
    
    public int add(int val) {
        this.minHeap.offer(val);  // log(n)
        if (this.minHeap.size() > k) this.minHeap.poll();
        return this.minHeap.peek();
    }
}


// 1st version:
class KthLargest {
    private List<Integer> scores;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.scores = new ArrayList<>();
        for (int n : nums) this.scores.add(n);
        this.k = k - 1;
    }
    
    public int add(int val) {
        this.scores.add(val);
        Collections.sort(this.scores, Collections.reverseOrder());  // nlog(n) full sort each time
        return this.scores.get(this.k);
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
