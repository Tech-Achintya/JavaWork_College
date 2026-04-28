import java.util.HashMap;
import java.util.*;

class Node{
    int val;
    Node next;
    Node(int val){
        this.val = val;
        this.next = null;
    }
}

class exceptionHandle{
    public static void main(String[] args) {
        try {
            Node node = new Node(4);
//            System.out.println(node.next.next.val);
            System.out.println(node.val);

        }catch (NullPointerException e){
            System.out.println("Dont try to access null value");
        }
        finally {
            System.out.println("Important Message , this will run anyways");
        }
    }
}