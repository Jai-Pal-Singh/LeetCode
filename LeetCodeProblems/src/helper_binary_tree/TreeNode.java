package helper_binary_tree;

//Definition for a binary tree node.
public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	public TreeNode() {}
	public TreeNode(int val) { this.val = val; }
	public TreeNode(int val, TreeNode left, TreeNode right) {
	    this.val = val;
	    this.left = left;
	    this.right = right;
	}

	public static int height(TreeNode root) {
        if(root == null){
            return 0;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }

	public static void print(TreeNode root){
        // printGivenLevel(root);
		int h = height(root);
        for (int i=1; i<=h; i++)
            printGivenLevel(root, i);
	}

	public static void printGivenLevel (TreeNode root ,int level) {
        if (root == null) {
            System.out.print("null" + " ");
            return;
        }
        if (level == 1) System.out.print(root.val + " ");
        else if (level > 1)
        {
            printGivenLevel(root.left, level-1);
            printGivenLevel(root.right, level-1);
        }
    }

    public static void printGivenLevel (TreeNode root) {
        if (root == null) return;
        printGivenLevel(root.left);
        System.out.print(root.val + " ");
        printGivenLevel(root.right);
    }
}
