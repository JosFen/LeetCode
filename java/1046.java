class Solution {
    public int lastStoneWeight(int[] stones) {
        if (stones.length == 1) return stones[0];

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // create a max heap using Comparator: Collections.reverseOrder()
        for (int stone : stones) maxHeap.offer(stone);

        while(maxHeap.size() >= 2) {
            int y = maxHeap.poll();
            int x = maxHeap.poll();
            if (y != x) maxHeap.add(y - x);
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}
