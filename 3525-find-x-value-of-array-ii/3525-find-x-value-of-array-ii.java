class Solution {
    class Node {
        int prod;
        int[] cnt;
        Node() {
            cnt = new int[5];
        }
    }

    private Node[] tree;
    private int n, K;

    private Node merge(Node left, Node right) {
        Node res = new Node();
        res.prod = (int) (((long) left.prod * right.prod) % K);
        for (int r = 0; r < K; r++) {
            res.cnt[r] = left.cnt[r];
        }
        for (int r = 0; r < K; r++) {
            if (right.cnt[r] > 0) {
                int newRem = (int) (((long) left.prod * r) % K);
                res.cnt[newRem] += right.cnt[r];
            }
        }
        return res;
    }

    private void build(int node, int l, int r, int[] nums) {
        if (l == r) {
            int val = nums[l] % K;
            tree[node].prod = val;
            tree[node].cnt[val] = 1;
            return;
        }
        int mid = (l + r) / 2;
        build(2 * node, l, mid, nums);
        build(2 * node + 1, mid + 1, r, nums);
        tree[node] = merge(tree[2 * node], tree[2 * node + 1]);
    }

    private void update(int node, int l, int r, int idx, int val) {
        if (l == r) {
            int rem = val % K;
            tree[node].prod = rem;
            for (int i = 0; i < K; i++) {
                tree[node].cnt[i] = 0;
            }
            tree[node].cnt[rem] = 1;
            return;
        }
        int mid = (l + r) / 2;
        if (idx <= mid) {
            update(2 * node, l, mid, idx, val);
        } else {
            update(2 * node + 1, mid + 1, r, idx, val);
        }
        tree[node] = merge(tree[2 * node], tree[2 * node + 1]);
    }

    private Node query(int node, int l, int r, int ql, int qr) {
        if (ql <= l && r <= qr) {
            return tree[node];
        }
        int mid = (l + r) / 2;
        if (qr <= mid) {
            return query(2 * node, l, mid, ql, qr);
        }
        if (ql > mid) {
            return query(2 * node + 1, mid + 1, r, ql, qr);
        }
        Node left = query(2 * node, l, mid, ql, qr);
        Node right = query(2 * node + 1, mid + 1, r, ql, qr);
        return merge(left, right);
    }

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        this.n = nums.length;
        this.K = k;
        tree = new Node[4 * n];
        for (int i = 0; i < 4 * n; i++) {
            tree[i] = new Node();
        }

        build(1, 0, n - 1, nums);

        int m = queries.length;
        int[] ans = new int[m];

        for (int i = 0; i < m; i++) {
            int idx = queries[i][0];
            int val = queries[i][1];
            int start = queries[i][2];
            int x = queries[i][3];

            update(1, 0, n - 1, idx, val);
            Node resNode = query(1, 0, n - 1, start, n - 1);
            ans[i] = resNode.cnt[x];
        }

        return ans;
    }
}