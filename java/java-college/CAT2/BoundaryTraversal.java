import java.util.*;


public class BoundaryTraversal {
    static class Node {
        int data;
        Node left;
        Node right;
        Node (int n) {
            data = n;
            left = right = null;
        }
    }

    static Node root;

    public static void create() {
        Queue<Node> q = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();

        if (n == -1) return ;

        root = new Node(n);
        q.add(root);
        while (!q.isEmpty()) {
            Node curr = q.poll();
            int l = sc.nextInt();
            if (l != -1) {
                Node leftNode = new Node(l);
                curr.left = leftNode;
                q.add(leftNode);
            }

            int r = sc.nextInt();
            if (r != -1) {
                Node rightNode = new Node(l);
                curr.right = rightNode;
                q.add(rightNode);
            }
        }
    }

    static ArrayList<Integer> boundaryTraversal(Node root) {
        ArrayList<Integer> res =  new ArrayList<>();
        if (root == null) return res;

        res.add(root.data);
        addLeftBoundary(root, res);
        addLeaves(root, res);
        addRightBoundary(root, res);
        return res;
    }


    static void addLeftBoundary(Node node, ArrayList<Integer> res) {
        Node curr = node.left;
        while (curr != null) {
            if (!isLeaf(curr)) {
                res.add(curr.data);
            }


            if (curr.left != null) {
                curr = curr.left;
            }

            if (curr.right != null) {
                curr = curr.right;
            }
        }
    }

    static void addRightBoundary(Node node, ArrayList<Integer> res) {
        Node curr = node.right;
        ArrayList<Integer> temp = new ArrayList<>();
        while (curr != null) {
            if (!isLeaf(curr)) {
                temp.add(curr.data);
            }

            if (curr.right != null) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }

        for (int i = temp.size() - 1; i >= 0; i--) {
           res.add(temp.get(i));
        }
    }

    static void addLeaves(Node node, ArrayList<Integer> res) {
         if (!isLeaf(node)) {
             res.add(node.data);
             return ;
         }

         if (node.left != null) {
             addLeaves(node.left, res);
         }

         if (node.right != null) {
             addLeaves(node.right, res);
         }
     }
    

    static boolean isLeaf(Node node) {
        return (node.left == null && node.right == null);
    }
    
    public static void main(String[] args) {
        create();
        ArrayList<Integer> result = boundaryTraversal(root);
        System.out.println("BoundaryTraversal of the tree:");
        for (int value : result) {
            System.out.println(value + " ");
        }
    }
}
