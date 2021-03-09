package path_sum;

public class Runner {

	public static void main(String[] args) {
		TreeNode root = new TreeNode();
//		root.val = 3;
//		
//		root.left = new TreeNode(9);
//		
//		root.right = new TreeNode(20);
//		root.right.left = new TreeNode(15); 
//		root.right.right =  new TreeNode(7);
//		root.val = 1;		
//		root.left = new TreeNode(2);
		root.val = -2;		
		root.right = new TreeNode(-3);

		Solution s = new Solution();
		System.out.println(s.hasPathSum(root, -5));
	}

}
