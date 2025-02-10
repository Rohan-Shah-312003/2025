import java.util.*;

/**
 * BinaryTreeInsert
 */
public class BinaryTreeInsert {

    static class Node {
        int data;
        Node left,right;
        Node(int v) {
            data = v;
            left = right = null;
        }
    }

    static Node root;
    static Scanner sc = new Scanner(System.in);
    public static void create(int v) {
        Queue<Node> q = new LinkedList<>();
        root = new Node(v);
        q.add(root);

        while(!q.isEmpty()) {
            Node temp = q.poll();
            int val = sc.nextInt();
            if(val != -1) {
                temp.left = new Node(val);
                q.add(temp.left);
            }

            val = sc.nextInt();
            if(val != -1) {
                temp.right = new Node(val);
                q.add(temp.right);
            }
        }
    }
    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }    
    public static void main(String[] args) {
        int ele = sc.nextInt();
        create(ele);
        inorder(root);
    }
}
