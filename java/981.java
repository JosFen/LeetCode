// class T {
//     public String key;
//     public int timestap;
//     public T(String value, int timestamp) {
//         this.value = value;
//         this.timestamp = timestamp;
//     }
// }

class TimeMap {
    private Map<String, List<Pair<Integer, String>>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Pair<>(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        List<Pair<Integer, String>> list = map.get(key); 
        if (list == null) return "";

        int l = 0, r = list.size();

        while (l < r) {
            int m = l + (r - l) / 2;
            if (list.get(m).getKey() > timestamp) r = m;
            else l = m + 1;
        }
        return (l == 0) ? "" : list.get(l - 1).getValue();
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
