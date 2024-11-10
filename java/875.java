class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = piles[0];
        for (int pile : piles) {
            r = Math.max(r, pile);
        }

        while (l < r) {
            int m = l + (r - l ) / 2;
            if (eatBananasTime(piles, m) <= h) r = m;
            else l = m + 1;
        }
        return l;
    }

    private int eatBananasTime(int[] piles, int m) {
        int time = 0;
        for (int pile : piles) {
            time += ((pile - 1)/ m + 1);
        }
        return time;
    }
}

