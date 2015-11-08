/*
Find the lowest common ancestor in an unordered
binary tree given two values in the tree.

Lowest common ancestor : the lowest common ancestor (LCA) of 
two nodes v and w in a tree or directed acyclic graph (DAG) is the lowest 
(i.e. deepest) node that has both v and w as descendants. 
*/
public class LCA {
    boolean find_path(TreeNode root, int v, ArrayList<Integer> path) {
        if (root == null)
            return False;
        path.add(root.val);
        if (root.val == v)
            return True;
        boolean found = find_path(root.left, v) || find_path(root.right, v);
        if (!found) path.remove(path.size()-1);
        return found;
    }   

    public int lca(TreeNode a, int val1, int val2) {
        ArrayList<Integer> path1, path2;
        boolean find1 = find_path(a, val1, path1);
        if (!find1) return -1;
        boolean find2 = find_path(a, val2, path2);
        if (!find2) return -1;
        int sz = Math.min(path1.size(), path2.size());
        int i = 1;
        while ( i < sz) {
            if (path1.get(i) != path2.get(i)) break;
            i++;
        }
        return path1.get(i-1);
    }
}