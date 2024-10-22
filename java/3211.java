class Solution {
    private List<String> ans = new ArrayList<>();
    private StringBuilder sb = new StringBuilder();
    private int n;

    public List<String> validStrings(int n) {
        this.n = n;
        dfs(0);
        return ans;
    }

    private void dfs(int i) {
        if (i >= n) {
            ans.add(sb.toString());
            return;
        }
        for (int j = 0; j < 2; ++j) {
            if ((j == 0 && (i == 0 || sb.charAt(i - 1) == '1')) || j == 1) {
                sb.append(j);
                dfs(i + 1);
                sb.deleteCharAt(sb.length() - 1); // return to previous state after dfs returns
            }
        }
    }
}
