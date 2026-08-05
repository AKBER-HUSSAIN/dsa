class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<Integer>[] g = new ArrayList[n];
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();
        for (int[] e : invocations) g[e[0]].add(e[1]);

        boolean[] s = new boolean[n];
        Deque<Integer> st = new ArrayDeque<>();
        st.push(k);
        s[k] = true;
        while (!st.isEmpty()) {
            int u = st.pop();
            for (int v : g[u]) {
                if (!s[v]) {
                    s[v] = true;
                    st.push(v);
                }
            }
        }

        for (int[] e : invocations) {
            if (!s[e[0]] && s[e[1]]) {
                List<Integer> ans = new ArrayList<>();
                for (int i = 0; i < n; i++) ans.add(i);
                return ans;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!s[i]) ans.add(i);
        }
        return ans;
    }
}