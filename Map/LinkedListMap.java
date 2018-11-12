import java.util.ArrayList;
public class LinkedListMap<K extends Comparable<K>, V> {
    Node dummyNode;
    int size;
    public class Node {
        K key;
        V value;
        Node next;
        public Node() {
            this.key = null;
            this.value = null;
            this.next = null;
        }
        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
    public LinkedListMap() {
        dummyNode = new Node(null, null, null);
        size = 0;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }
    public void put(K k, V v) {
        if(size == 0) {
            size++;
            dummyNode.next = new Node(k, v, null);
            return;
        }
        if(!containsKey(k)) {
            size++;
            Node newNode = new Node(k, v, dummyNode.next);
            dummyNode.next = newNode;
            return;
        }
        Node containedNode = getKeyNode(k);
        containedNode.value = v;
    }
    public boolean containsKey(K k) {
        Node head = dummyNode.next;
        while(head != null && head.key.compareTo(k) != 0) {
            head = head.next;
        }
        return head != null;
    }
    private Node getKeyNode(K k) {
        Node head = dummyNode.next;
        if(head == null) return null;
        while(head != null && head.key.compareTo(k) != 0) {
            head = head.next;
        }
        return head;
    }
    public V remove(K key) {
        Node head = dummyNode;
        while(head.next != null && head.next.key.compareTo(key) != 0) {
            head = head.next;
        }
        if(head.next == null) return null;
        size--;
        Node deleteNode = head.next;
        head.next = deleteNode.next;
        deleteNode.next = null;
        return deleteNode.value;
    }
    public V get(K key) {
        Node target = getKeyNode(key);
        return target == null ? null : target.value;
    }
    public static void main(String[] args){

        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile("PrideandPrejudice.txt", words)) {
            System.out.println("Total words: " + words.size());

            LinkedListMap<String, Integer> map = new LinkedListMap<>();
            for (String word : words) {
                if (map.containsKey(word))
                    map.put(word, map.get(word) + 1);
                else
                    map.put(word, 1);
            }

            System.out.println("Total different words: " + map.size());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
        }

        System.out.println();
    }
}
