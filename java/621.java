class Solution {
  public int leastInterval(char[] tasks, int n) {
    int[] count = new int[26];

    for (final char task : tasks) count[task - 'A']++;

    final int maxFreq = Arrays.stream(count).max().getAsInt();
    // Get the number of tasks with the same frequency as `maxFreq`
    int mostFreqTasksCount = 0;
    for (int i : count) {
        if (i == maxFreq) mostFreqTasksCount++;
    }
    // Put the most frequent task in the slot first, then add extra most frequent tasks number
    int time = (maxFreq - 1) * (n + 1) + mostFreqTasksCount; 
    // max(
    //   the most frequent task is frequent enough to force some idle slots,
    //   the most frequent task is not frequent enough to force idle slots
    // )
    return Math.max(time, tasks.length);
  }
}
