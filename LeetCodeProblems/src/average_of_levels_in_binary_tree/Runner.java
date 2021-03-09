package average_of_levels_in_binary_tree;

import java.util.List;

public class Runner {

	public static void main(String[] args) {
		TreeNode root = new TreeNode();
		root.val = 3;
		
		root.left = new TreeNode(9);
		
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15); 
		root.right.right =  new TreeNode(7);
		
		Solution s = new Solution();
		List<Double> result = s.averageOfLevels(root);
		result.stream().forEach(System.out::println);
	}

}
