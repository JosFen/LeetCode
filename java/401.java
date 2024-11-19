// Bit count: O(12*60)

class Solution {
  public List<String> readBinaryWatch(int turnedOn) {
    List<String> ans = new ArrayList<>();  // Use ArrayList instead of LinkedList

    for (int h = 0; h < 12; ++h)
      for (int m = 0; m < 60; ++m)
        if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn)
          ans.add(h + (m < 10 ? ":0" : ":") + m);

    return ans;
  }
}

// DFS: O(2^10)
class Solution {
  public List<String> readBinaryWatch(int turnedOn) {
    List<String> ans = new ArrayList<>();
    dfs(turnedOn, 0, 0, 0, ans);
    return ans;
  }

  private int[] hours = {1, 2, 4, 8};  
  private int[] minutes = {1, 2, 4, 8, 16, 32};  
  private void dfs(int turnedOn, int s, int h, int m, List<String> ans) {
    if (turnedOn == 0) {
      String time = h + ":" + (m < 10 ? "0" : "") + m;
      ans.add(time);
      return;
    }

    // use i to locate in hours or minutes LEDS
    for (int i = s; i < hours.length + minutes.length; ++i) { 
      if (i < hours.length && h + hours[i] < 12) {
        dfs(turnedOn - 1, i + 1, h + hours[i], m, ans);
      } else if (i >= hours.length && m + minutes[i - hours.length] < 60) {
        dfs(turnedOn - 1, i + 1, h, m + minutes[i - hours.length], ans);
      }
    }
  }
}
