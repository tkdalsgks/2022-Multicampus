package tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

	Node root;

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}
	
	// 조회
	// depth first search : 왼쪽 - 루트 - 오른쪽
	public void inorder(Node n) {
		if(n != null) {
			inorder(n.getLeft());
			System.out.print(n.getName() + "-");
			inorder(n.getRight());
		}
	}
	
	// depth first search : 루트 - 왼쪽 - 오른쪽
	public void preorder(Node n) {
		if(n != null) {
			System.out.print(n.getName() + "-");
			preorder(n.getLeft());
			preorder(n.getRight());
		}
	}
	
	// depth first search : 왼쪽 - 오른쪽 - 루트
	public void postorder(Node n) {
		if(n != null) {
			postorder(n.getLeft());
			postorder(n.getRight());
			System.out.print(n.getName() + "-");
		}
	}
	
	// 루트 자식 기억 - 다음 레벨 이동하기 전 출력
	public void levelorder(Node n) {
		// 같은 레벨 저장 - 추출 - 다음 레벨 이동
		Queue<Node> q = new LinkedList();
		q.add(n);
		
		Node temp;
		while(!q.isEmpty()) {
			temp = q.remove();
			System.out.print(temp.getName() + "-");
			if(temp.getLeft() != null) {
				q.add(temp.getLeft());
			}
			if(temp.getRight() != null) {
				q.add(temp.getRight());
			}
		}
	}
}
