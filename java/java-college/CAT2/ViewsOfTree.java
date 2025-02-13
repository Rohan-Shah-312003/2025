import java.util.*;

public class ViewsOfTree {
    static class node {
        int data;
        node left;
        node right;
        node (int d) {
            data = d;
            left = right = null;
        }
    }

    static node root;

    public static void create() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == -1) return;
        node newnode = new node(n);
        root = newnode;
        Queue<node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            node curr = q.poll();
            int I = sc.nextInt();
            if (I != -1) {
                node nn = new node(I);
                curr.left = nn;
                q.add(nn);
            }
            int r = sc.nextInt();
            if (r != -1) {
                node nn = new node (r);
                curr.right = nn;
                q.add(nn);
            }
        }
    }

    public static void leftview(node root, List<Integer> l, int size) {
        if (root == null) return ;
        if (size == l.size()) l.add(root.data);
        if (root.left != null) leftview(root.left, l, size + 1);
        if (root.right != null) leftview(root.right, l, size + 1); 
    }

    public static void rightview(node root, List<Integer> l, int size) {
        if (root == null) return ;
        if (size == l.size()) l.add(root.data);
        if (root.right != null) rightview(root.right, l, size + 1);
        if (root.left != null) rightview(root.left, l, size + 1); 
    }

    public static void main(String[] args) {
        create();
        List<Integer> l = new ArrayList<>();
        leftview(root, l, 0);
        System.out.println(l);
        List<Integer> r = new ArrayList<>();
        rightview(root, r, 0);
        System.out.println(r);
    }
}
