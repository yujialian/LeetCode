import java.util.List;
import java.util.ArrayList;

public class maxHeap<E extends Comparable<E>> {
    List<E> data;
    public maxHeap(int size) {
        data = new ArrayList<>(size);
    }
    public maxHeap(List<E> input) {
        data = input;
        for(int i = parent(input.size() - 1); i >= 0; i--) {
            siftDown(i);
        }
    }
    public maxHeap() {
        data = new ArrayList<>();
    }
    public int size() {
        return data.size();
    }
    public boolean isEmpty() {
        return data.isEmpty();
    }
    public int parent(int k) {
        if(k < 0) throw new IllegalArgumentException();
        return (k - 1) / 2;
    }
    public int leftChild(int k) {
        if(k < 0) throw new IllegalArgumentException();
        return 2 * k + 1;
    }
    public int rightChild(int k) {
        if(k < 0) throw new IllegalArgumentException();
        return 2 * k + 2;
    }
    public void siftUp(int k) {
        while(k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            swap(k, parent(k));
            k = parent(k);
        }
    }
    public void siftDown(int k) {
        if(data.size() <= 1) return;
        while(leftChild(k) < data.size()) {
            int j = leftChild(k);
            if(rightChild(k) < data.size() && data.get(j).compareTo(data.get(rightChild(k))) < 0) {
                j = rightChild(k);
            }
            if(data.get(j).compareTo(data.get(k)) < 0) break;
            swap(j, k);
            k = j;
        }
    }
    private void swap(int i, int j) {
        E e = data.get(i);
        data.set(i, data.get(j));
        data.set(j, e);
    }
    public void add(E e) {
        data.add(e);
        siftUp(data.size() - 1);
    }
    public E findMax() {
        return data.get(0);
    }
    public E extractMax() {
        if(data.size() == 0) throw new IllegalStateException();
        E e = findMax();
        swap(0, data.size() - 1);
        data.remove(data.size() - 1);
        siftDown(0);
        return e;
    }
    public E replace(E e) {
        if(data.size() == 0) throw new IllegalStateException();
        E ret = data.get(0);
        data.set(0, e);
        siftDown(0);
        return ret;
    }
}
