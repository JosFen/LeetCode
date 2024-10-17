class RecentCounter {
    Queue<Integer> records;

    public RecentCounter() {
        records = new LinkedList<>();
    }
    
    public int ping(int t) {
        records.add(t);
        while (t - records.peek() > 3000) records.poll();
        return records.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
