
/**/
class Node {
    int data; Node left, right; 
    public Node(int d){data=d; left=null; right = null;}}

public class c4p8 {
   

   public static Node build_bst(int[] sorted_array, int start, int end) {
        if (end < start)
            return null;
        int mid = (end+start)/2;
        Node n = new Node(sorted_array[mid]);
        n.left = build_bst(sorted_array, start, mid-1);
        n.right = build_bst(sorted_array, mid+1, end);
        return n;
    }

    public static boolean sub(Node p, Node q){
	if (p==null) return false;
	if (p.data == q.data) return matchTree(p, q);
	else return sub(p.left, q) || sub(p.right, q);		
    }

    public static void inOrder(Node r) {
	if (r == null) return;
	System.out.print(r.data + " ");
	inOrder(r.left);
	inOrder(r.right);
    }

    public static boolean isSubtree(Node p, Node q){
	if (q == null) return true;
	return sub(p, q);
    }
    
    public static boolean matchTree(Node p, Node q){
	if (p == null && q == null) return true;
	if (p == null || q == null) return false;
	if (p.data == q.data)
		return matchTree(p.left, q.left) &&
		       matchTree(p.right, q.right);
	return false;
    }

    public static void main(String[] args) {
        int arg0 = Integer.parseInt(args[0]);
        int[] arr = new int[arg0];
        for (int i=0; i<arg0; ++i) arr[i] = i;
        Node p = build_bst(arr, 0, arr.length-1);
	inOrder(p); System.out.println();
	Node q = new Node(7); q.right = new Node(8); q.right.right = new Node(9);
	q.left = new Node(5); q.left.right = new Node(6);
        System.out.println(isSubtree(p, q));
    }
}
