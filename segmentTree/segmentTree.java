public class segmentTree<E> {
    E[] data;
    E[] tree;
    private Merger<E> merger;
    public segmentTree(E[] arr, Merger<E> merger) {
        data = (E[]) new Object[arr.length];
        for(int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        this.merger = merger;
        tree = (E[]) new Object[4 * arr.length];
        buildSegmentTree(0, 0, data.length - 1);
    }
    private void buildSegmentTree(int treeIndex, int l, int r) {
        if(l == r) {
            tree[treeIndex] = data[l];
            return;
        }
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        int mid = l + (r - l) / 2;
        buildSegmentTree(leftTreeIndex, l, mid);
        buildSegmentTree(rightTreeIndex, mid + 1, r);
        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }
    public E get(int index) {
        if(index > data.length - 1 || index < 0) throw new IndexOutOfBoundsException();
        return data[index];
    }
    public int size() {
        return data.length;
    }
    private int leftChild(int index) {
        return 2 * index + 1;
    }
    private int rightChild(int index) {
        return 2 * index + 2;
    }
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append('[');
        for(int i = 0; i < tree.length; i++) {
            if(tree[i] != null) {
                res.append(tree[i]);
            } else {
                res.append("null");
            }
            if(i != tree.length - 1)
                res.append(",");
        }
        res.append(']');
        return res.toString();
    }
    public E query(int queryL, int queryR) {
        if(queryL < 0 || queryL >= data.length || queryR < 0 || queryR >= data.length || queryL > queryR)
            throw new IndexOutOfBoundsException();
        return query(0, 0, data.length - 1, queryL, queryR);
    }
    private E query(int treeIndex, int l, int r, int queryL, int queryR) {
        if(l == queryL && r == queryR) {
            return tree[treeIndex];
        }
        int mid = l + (r - l) / 2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        
        if(queryL >= mid + 1)
            return query(rightTreeIndex, mid + 1, r, queryL, queryR);
        else if(queryR <= mid)
            return query(leftTreeIndex, l, mid, queryL, queryR);
        E leftResult = query(leftTreeIndex, l, mid, queryL, mid);
        E rightResult = query(rightTreeIndex, mid + 1, r, mid + 1, queryR);
        return merger.merge(leftResult, rightResult);
    }
    public void set(int index, E e) {
        if(index < 0 || index >= data.length) {
            throw new IllegalArgumentException();
        }
        data[index] = e;
        set(0, 0, data.length - 1, index, e);

    }
    //在以tree index为根的线段树中更新index值为e
    private void set(int treeIndex, int l, int r, int index, E e) {
        if(l == r) {
            tree[treeIndex] = e;
            return;
        }
        int mid = l + (r - l) / 2;
        int leftChildIndex = leftChild(treeIndex);
        int rightChildIndex = rightChild(treeIndex);

        if(index >= mid + 1)
            set(rightTreeIndex, mid + 1, r, index, e);
        else //index <= mid
            set(leftTreeIndex, l, mid, index, e);
        tree[treeIndex] = merge.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }
}
