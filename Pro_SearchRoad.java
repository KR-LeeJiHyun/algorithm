import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Pro_SearchRoad {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] nodeinfo = {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
		solution(nodeinfo);
	}
	
	public static class Node{
		int x;
		int idx;
		Node left;
		Node right;
		
		Node(int x, int idx){
			this.x = x;
			this.idx = idx;
			left = null;
			right = null;
		}
	}
	
	public static class BinaryTree{
		Node root = null;
		
		//public BinaryTree() {}
		
		public void insert(int x, int idx) {
			if(root != null) {
				Node cNode = root;
				
				while(true) {
					if(x < cNode.x) {
						if(cNode.left != null) cNode = cNode.left;
						else {
							cNode.left = new Node(x, idx);
							break;
						}
					}
					else {
						if(cNode.right != null) cNode = cNode.right;
						else {
							cNode.right = new Node(x, idx);
							break;
						}
					}
				}
			} 
			else root = new Node(x, idx);
		}
		
		public void preorder(Node n, ArrayList<Integer> list) {
			list.add(n.idx);
			if(n.left != null) preorder(n.left, list);
			if(n.right != null) preorder(n.right, list);
		}
		
		public void postorder(Node n, ArrayList<Integer> list) {
			if(n.left != null) postorder(n.left, list);
			if(n.right != null) postorder(n.right, list);
			list.add(n.idx);
		}
	}
	
    public static int[][] solution(int[][] nodeinfo) {
    	int len = nodeinfo.length;
        int[][] answer = new int[2][len], infos = new int[len][3];
        
        for(int idx = 0; idx < len; ++idx) {
        	infos[idx][0] = nodeinfo[idx][0];
        	infos[idx][1] = nodeinfo[idx][1];
        	infos[idx][2] = idx + 1;
        }
        
        Arrays.sort(infos, new Comparator<int[]>() {
        	public int compare(int[] o1, int[] o2) {
        		if(o1[1] == o2[1]) {
        			return o1[0] - o2[0]; 
        		}
        		return o2[1] - o1[1];
        	};
        });
        
       BinaryTree binary = new BinaryTree();
       for(int idx = 0; idx < len; ++idx) binary.insert(infos[idx][0], infos[idx][2]);
       ArrayList<Integer> pre = new ArrayList<>();
       binary.preorder(binary.root, pre);
       ArrayList<Integer> post = new ArrayList<>();
       binary.postorder(binary.root, post);
       
       for(int idx = 0; idx < len; ++idx) {
    	   answer[0][idx] = pre.get(idx);
    	   answer[1][idx] = post.get(idx);
       }
       return answer;
    }

}
