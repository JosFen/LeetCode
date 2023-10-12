class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> fb = new HashMap<>();
        int count = 0, l = 0, r = 0;

        while (r < fruits.length) {
            fb.put(fruits[r], fb.getOrDefault(fruits[r], 0) + 1);
            
            while(fb.size() > 2) {
                fb.put(fruits[l], fb.get(fruits[l])-1);
                if (fb.get(fruits[l]) == 0) fb.remove(fruits[l]);
                l++;
            }
            count = Math.max(count, r-l+1);
            r++; 
        }
        return count;
    }
}
        
