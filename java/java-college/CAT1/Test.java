//import java.util.*;
//
//public class Test {
//    static node head = null;
//    static class node {
//        int data;
//        node prev;
//        node next;
//
//        node(int n) {
//            this.data = n;
//            next = null;
//            prev = null;
//        }
//    }
//
//    static void insert (int n) {
//        node newnode = new node(n);
//        if (head == null) head = newnode;
//        else {
//            node cur = head;
//            while (cur.next != null) {
//                cur = cur.next;
//            }
//
//            cur.next = newnode;
//            newnode.prev = cur;
//        }
//    }
//
//    static node sort(node first) {
//        if (first == null || first.next == null) {
//            return first;
//        }
//
//        node second = split(first);
//        first = sort(first);
//        second = sort(second);
//
//        return merge(first, second);
//    }
//
//    static node merge(node first, node second) {
//        if (first == null) {
//            return second;
//        }
//
//        if (second == null) return first;
//
//        if (first.data <= second.data) {
//            first.next = merge(first.next, second);
//            first.next.prev = first;
//            first.prev = null;
//            return first;
//        } else {
//            second.next = merge(first, second.next);
//            second.next.prev = second;
//            second.prev = null;
//            return second;
//        }
//    }
//
//    static node split(node first) {
//        node fast = first;
//        node slow = first;
//
//        if (first != null && first.next != null || first.next.next != null) {
//            fast = fast.next.next;
//            slow = slow.next;
//        }
//
//        node temp = slow.next;
//        slow.next = null;
//        return temp;
//    }
//    static void display() {
//        node cur = head;
//        while(cur != null) {
//            System.out.print(cur.data+"-->");
//            cur = cur.next;
//        }
//        System.out.print("null");
//    }
//    public static void main(String ar[]) {
//        Scanner sw = new Scanner(System.in);
//        int n=sw.nextInt();
//        for(int i=0;i<n;i++) {
//            insert(sw.nextInt());
//        }
//        head=sort(head);
//        display();
//    }
//}


import java.util.*;
public class Test {
    static void span(int p[],int n,int s[]){
        Stack<Integer> st = new Stack<>();
        st.push(0);
        s[0]=1;
        for(int i=0;i<n;i++){
            while(!st.isEmpty()&&p[st.peek()]<=p[i]){
                st.pop();
            }
            s[i]=(st.isEmpty()?(i+1):(i-st.peek()));
            st.push(i);
        }
    }
        public static void main(String[] args)
        {
            Scanner sw= new Scanner(System.in);
            int n=sw.nextInt();
                int p[] = new int[n];
                for(int i=0;i<n;i++) p[i]=sw.nextInt();
                int s[] = new int[n];
                span(p, n, s);
                for(int i=0;i<n;i++)
                System.out.print(s[i]+" ");
        }
}
