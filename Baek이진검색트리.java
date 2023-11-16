import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baek이진검색트리 {
	
	static class Node {
		int val;
		Node left;
		Node right;
		
		public Node(int val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}
		
		
	}
	
	static Node root;
	static StringBuilder answer = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input = br.readLine();
		root = new Node(Integer.parseInt(input));
		while((input = br.readLine()) != null && !input.equals("")) {
			int current = Integer.parseInt(input);
			searchAndInsert(current, root);
		}
		
		postorder(root);
		
		bw.write(answer.toString());
		br.close();
		bw.close();
	}

	private static void postorder(Node node) {
		if(node == null) return;
		Node left = node.left;
		Node right = node.right;
		postorder(left);
		postorder(right);
		answer.append(node.val);
		answer.append('\n');
	}

	private static void searchAndInsert(int current, Node node) {
		if(current < node.val) {
			if(node.left == null) {
				node.left = new Node(current);
			}
			else {
				searchAndInsert(current, node.left);
			}
		}
		else {
			if(node.right == null) {
				node.right = new Node(current);
			}
			else {
				searchAndInsert(current, node.right);
			}
		}
	}

}
