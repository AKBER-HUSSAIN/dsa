class Solution {
    private int count = 0;

    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return count;
    }

    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0}; // {sum, count}
        }

        // Post-order traversal: compute left and right subtrees first
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        int currentSum = left[0] + right[0] + node.val;
        int currentCount = left[1] + right[1] + 1;

        // Check if current node's value equals the floor average of its subtree
        if (currentSum / currentCount == node.val) {
            count++;
        }

        return new int[]{currentSum, currentCount};
    }
}