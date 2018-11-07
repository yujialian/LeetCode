import java.util.Stack;
import java.util.ArrayList;
import java.util.Random;
public class BST<E extends Comparable<E>> {
    public class Node {
        E e;
        Node left;
        Node right;
        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }
    Node root;
    int size; 
    public BST() {
        root = null;
        size = 0;
    }
    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public void add(E e) {
       root = add(e, root);
    }
    private Node add(E e, Node node) {
        if(node == null) {
            size++;
            return new Node(e);
        }
        if(node.e.compareTo(e) == 0) return node;
        if(node.e.compareTo(e) > 0) node.left =  add(e, node.left); 
        else if(node.e.compareTo(e) < 0) node.right = add(e, node.right);
        return node;
    }
    public E max() {
        if(size == 0) return null;
        return max(root).e;
    }
    private Node max(Node node) {
        if(node.right == null) return node;
        return max(node.right);
    }
    public E removeMax() {
        if(size == 0) return null;
        Node maxNode = max(root);
        root = removeMax(root);
        maxNode.left = null;
        size--;
        return maxNode.e;
    }
    private Node removeMax(Node node) {
        if(node == null) return null;
        if(node.right == null) return node.left;
        node.right = removeMax(node.right);
        return node;
    }
    public E removeMin() {
        if(size == 0) return null;
        Node minNode = min(root);
        root = removeMin(root);
        size--;
		minNode.left = null;
        minNode.right = null;
        return minNode.e;
    }
    public Node removeMin(Node node) {
        if(node == null) return null;
        if(node.left == null) return node.right;
        node.left = removeMin(node.left);
        return node;
    }
    public E min() {
        if(size == 0) return null;
        return min(root).e;
    }
    public Node min(Node node) {
        if(node.left == null) return node;
        return min(node.left);
    }
    public void remove(E e) {
		if(size == 0) return;
        root = remove(root, e);
    }

    private Node remove(Node node, E e) {
        if(node == null) return null;
        if(node.e.compareTo(e) > 0) {
            node.left = remove(node.left, e);
            return node;
        }
        if(node.e.compareTo(e) < 0) {
            node.right = remove(node.right, e);
            return node;
        }
		size--;
		if(node.left == null) {
			Node rightNode = node.right;
			node.right = null;
			return rightNode;
		}
		if(node.right == null) {
			Node leftNode = node.left;
			node.left = null;
			return leftNode;
		}

        Node successor = min(node.right);
        successor.right = removeMin(node.right);
        successor.left = node.left;
        node.left = node.right = null;
        return successor;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuilder res){

        if(node == null){
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.e +"\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for(int i = 0 ; i < depth ; i ++)
            res.append("--");
        return res.toString();
    }
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        Random random = new Random();

        int[] testNums = {5, 3, 3, 6, 8, 4, 2};
        for(int num: testNums) {
            bst.add(num);
        }
        System.out.println("Add methods:");
        System.out.println(bst.toString());
		System.out.println("toString finished!");
        bst.remove(3);
        //System.out.println("After remove 3:\n" + bst.toString());
        bst.remove(5);
        System.out.println("After remove 5:\n" + bst.toString());
        
        int n = 100;
        ArrayList<Integer> nums = new ArrayList<>();
        // test removeMin
        for(int i = 0 ; i < n ; i ++)
            bst.add(random.nextInt(10000));

        while(!bst.isEmpty())
            nums.add(bst.removeMin());

        System.out.println(nums);
        for(int i = 1 ; i < nums.size() ; i ++)
            if(nums.get(i - 1) > nums.get(i))
                throw new IllegalArgumentException("Error!");
        System.out.println("removeMin test completed.");

        // test removeMax
        for(int i = 0 ; i < n ; i ++)
            bst.add(random.nextInt(10000));

        nums = new ArrayList<>();
        while(!bst.isEmpty())
            nums.add(bst.removeMax());
        //System.out.println("Size:" + bst.size());
        //bst.preOrder();
        System.out.println(nums);
       for(int i = 1 ; i < nums.size() ; i ++)
           if(nums.get(i - 1) < nums.get(i))
               throw new IllegalArgumentException("Error!");
       System.out.println("removeMax test completed.");
       
   }
}
