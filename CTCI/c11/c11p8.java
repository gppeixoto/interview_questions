class Node {
    Node left, right;
    int data, left_size;
    Node (int d) {
        data = d; left_size = 0;
        left = null; right = null;
    }

    void insert(int d) {
        if (d <= data) {
            if (left == null)
                left = new Node(d);
            else left.insert(d);
            left_size += 1;
        } else {
            if (right == null)
                right = new Node(d);
            else right.insert(d);
        }
    }

    int get_rank(int d) {
        if (d == data)
            return left_size;
        else if (d < data) {
            if (left == null)
                return -1;
            else
                return left.get_rank(d);
        } else {
            int right_rank = (right == null) ? -1 : right.get_rank(d);
            if (right_rank == -1)
                return -1;
            else
                return left_size + 1 + right_rank;
        }
    }

}

public class c11p8 {
    public static void main(String[] args) {
        Node root = new Node(5);
        for (String s : args) {
            root.insert(Integer.parseInt(s));
        }
        System.out.println(root.get_rank(1));
        System.out.println(root.get_rank(3));
        System.out.println(root.get_rank(4));
    }
}
