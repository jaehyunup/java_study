package DataStructure;

import java.util.Arrays;

public class example_03_CompleteBinaryTreeTest {

	public static void main(String[] args) {

		int size = 10;
		example_04_CompleteBinaryTree tree = new example_04_CompleteBinaryTree(size);
		
		for(int i=0; i<size; ++i){
			tree.add((char)(65+i));
		}
		System.out.println(Arrays.toString(tree.nodes));
//		tree.bfs();
//		tree.bfs2();
//		tree.printTreeByPreOrder();
//		tree.printTreeByInOrder();
//		tree.printTreeByPostOrder();
		
	}

}
