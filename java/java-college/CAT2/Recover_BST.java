import java.util.LinkedList;
import java.util.Queue;

public class Recover_BST {
    static class Treenode {
        int v;
        Treenode left, right;
        Treenode (int g) {
            v = g;
            left = right = null;
        }
    }
    
    static Treenode first, second, prev;

    static void recoverTree(Treenode root) {
        inorderTraversal(root);
        if (first != null && second != null) {
            int temp = first.v;
            first.v = second.v;
            second.v = temp;
        }
    }
    
    static void inorderTraversal(Treenode root) {
        if (root == null) return;
        inorderTraversal(root.left);
        if (prev != null && root.v < prev.v) {
            if (first == null) first = prev;
                second = root;
        }
        prev = root;
        inorderTraversal(root.right);
    }
    
    public static Treenode build(String[] a) {
        if (a.length == 0 || a[0].equals("N")) return null;
        Treenode root = new Treenode(Integer.parseInt(a[0]));
        Queue<Treenode> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while(!q.isEmpty() && i < a.length) {
            Treenode curr = q.poll();
            if (!a[i].equals("N")) {
                curr.left = new Treenode(Integer.parseInt(a[i]));
                q.add(curr.left);
            }
            i++;

            if (i < a.length && !a[i].equals("N")) {
                curr.right = new Treenode(Integer.parseInt(a[i]));
                q.add(curr.right);
            }
            i++;
        }
        return root;
    }
    

}
