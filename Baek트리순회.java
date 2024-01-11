import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek트리순회 {
	
	static class Node {
		char alpha;
		Integer left;
		Integer right;
		
		public Node(char alpha, Integer left, Integer right) {
			this.alpha = alpha;
			this.left = left;
			this.right = right;
		}
	}
	
	static Node[] binaryTree;
	static StringBuilder answer = new StringBuilder(); 

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		binaryTree = new Node[N];
		
		for(int idx = 0; idx < N; ++idx) {
			StringTokenizer input = new StringTokenizer(br.readLine());
			int pos = input.nextToken().charAt(0) - 'A';
			Integer left = null;
			Integer right = null;
			char cL = input.nextToken().charAt(0);
			if(cL != '.') left = cL - 'A';
			char cR = input.nextToken().charAt(0);
			if(cR != '.') right = cR - 'A';
			binaryTree[pos] = new Node((char)(pos + 'A'), left, right); 
		}
		
		preOrder(0);
		answer.append('\n');
		inOrder(0);
		answer.append('\n');
		postOrder(0);
		
		bw.write(answer.toString());
		br.close();
		bw.close();
	}

	private static void postOrder(int i) {
		if(binaryTree[i].left != null) postOrder(binaryTree[i].left);
		if(binaryTree[i].right != null) postOrder(binaryTree[i].right);
		answer.append(binaryTree[i].alpha);
	}

	private static void inOrder(int i) {
		if(binaryTree[i].left != null) inOrder(binaryTree[i].left);
		answer.append(binaryTree[i].alpha);
		if(binaryTree[i].right != null) inOrder(binaryTree[i].right);
	}

	private static void preOrder(int i) {
		answer.append(binaryTree[i].alpha);
		if(binaryTree[i].left != null) preOrder(binaryTree[i].left);
		if(binaryTree[i].right != null) preOrder(binaryTree[i].right);
	}

}
