class Solution {
    private List<Integer> ways(final String str, Map<String, List<Integer>> mem) {
        if (mem.containsKey(str)) return mem.get(str);
    
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            // if an operator is encountered:
            if (!Character.isDigit(str.charAt(i))) {
                for (final int op1 : ways(str.substring(0,i), mem)) {
                    for (final int op2 : ways(str.substring(i+1), mem)) {
                        if (str.charAt(i) == '+') answer.add(op1 + op2);
                        else if (str.charAt(i) == '-') answer.add(op1 - op2);
                        else answer.add(op1 * op2);
                    }
                }
            } 
        }
        // Single number, i.e., no operator encountered：
        if (answer.isEmpty()) answer.add(Integer.parseInt(str));

        mem.put(str, answer);
        return answer;
    }

    public List<Integer> diffWaysToCompute(String expression) {
        return ways(expression, new HashMap<>());
    }
}
