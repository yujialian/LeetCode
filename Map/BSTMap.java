import java.util.Map;
import java.util.TreeMap;
import java.util.ArrayList;
public class BSTMap<K extends Comparable<K>, V> {
    int size;
    TreeMap<K, V>[] data;
    int capacityIndex;
    private final int[] capacity
            = {53, 97, 193, 389, 769, 1543, 3079, 6151, 12289, 24593,
            49157, 98317, 196613, 393241, 786433, 1572869, 3145739, 6291469,
            12582917, 25165843, 50331653, 100663319, 201326611, 402653189, 805306457, 1610612741};
    private static final int upperTol = 10;
    private static final int lowerTol = 2;

    public BSTMap() {
        size = 0;
        capacityIndex = 0;
        data = new TreeMap[capacityIndex];
        for(int i = 0; i < data.length; i++) {
            data[i] = new TreeMap<>();
        }
    }
    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public void add(K key, V value) {
        if(size >= 10 * capacity[capacityIndex]) {
            resize(capacityIndex + 1);
        } 
        if(!data[hash(key)].containsKey(key)) data[hash(key)].put(key, value);
        else {
            data[hash(key)].remove(key);
            data[hash(key)].put(key, value);
        } 
    }
    public V remove(K key) {
        if(hash(key) < 0 && hash(key) >= capacity.length) throw new IndexOutOfBoundsException();
        TreeMap<K, V> currMap = data[hash(key)];
        if(currMap.containsKey(key)) {
            V value = currMap.remove(key);
            size--;
            if(capacityIndex > 0 && size * 2 <= capacity[capacityIndex]) {
                resize(capacityIndex - 1);
            }
            return value;
        }
        throw new IllegalArgumentException("No such element!");
    }
    public boolean containsKey(K key) {
        if(hash(key) >= capacity[capacityIndex] && hash(key) < 0) throw new IndexOutOfBoundsException();
        return data[hash(key)].containsKey(key);

    }	
	private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % capacity[capacityIndex]; 
	}
    private boolean resize(int index) {
        if(index >= capacity.length && size <= capacity[0]) return false;
        capacityIndex = index;
        TreeMap<K, V>[] newData = new TreeMap[capacity[capacityIndex]];
        for(int i = 0; i < newData.length; i++) {
            newData[i] = new TreeMap<K, V>();
        }
        for(int i = 0; i < data.length; i++) {
            for(Map.Entry<K, V> entry: data[i].entrySet()) {
                newData[hash(entry.getKey())].put(entry.getKey(), entry.getValue());
            }
        }
        data = newData;
        return true;
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
