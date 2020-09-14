package trees.problems;

public class BinaryTree {

	TreeNode root;
	BinaryTree(int key) {
		root = new TreeNode(key);
	}
	BinaryTree() {
		root = null;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree tree = new BinaryTree();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
	}

}
