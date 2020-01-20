class TreeNode{
	Object data;
	TreeNode left;
	TreeNode right;
}

class LinkedTree{
	private TreeNode root;
	
	public TreeNode makeBT(TreeNode bt1, Object data, TreeNode bt2){
		TreeNode root = new TreeNode();
		root.data = data;
		root.left = bt1;
		root.right = bt2;
		return root;
	}
	public void preorder(TreeNode root){
		if(root != null){
			System.out.printf("%c", root.data);
			preorder(root.left);
			preorder(root.right);
		}
	}
	public void inorder(TreeNode root){
		if(root != null){
			inorder(root.left);
			System.out.printf("%c", root.data);			
			inorder(root.right);
		}
	}
	public void postorder(TreeNode root){
		if(root != null){
			postorder(root.left);					
			postorder(root.right);
			System.out.printf("%c", root.data);	
		}
	}
}

class Ex9_1{
	public static void main(String args[]){
		LinkedTree T = new LinkedTree();
		
		TreeNode n7 = T.makeBT(null, 'D', null);
		TreeNode n6 = T.makeBT(null, 'C', null);
		TreeNode n5 = T.makeBT(null, 'B', null);
		TreeNode n4 = T.makeBT(null, 'A', null);
		TreeNode n3 = T.makeBT(n6, '/', n7);
		TreeNode n2 = T.makeBT(n4, '*', n5);
		TreeNode n1 = T.makeBT(n2, '-', n3);
		
		System.out.printf("\n Preorder : ");
		T.preorder(n1);
		
		System.out.printf("\n Inorder : ");
		T.inorder(n1);
		
		System.out.printf("\n Postorder : ");
		T.postorder(n1);
	}
}