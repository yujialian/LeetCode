public class LoopQueue<E> {
    private E[] data;
    private int size;
    private int front, tail;

    public LoopQueue(int getCapacity) {
        data = (E[]) new Object[getCapacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int getCapacity() {
        return this.data.length - 1;
    }

    public void enqueue(E e) {
        if((this.tail + 1) % this.data.length == this.front) resize(getCapacity() * 2);
        this.data[this.tail] = e;
        this.tail = (this.tail + 1) % this.data.length;
        this.size++;
    }

    public E dequeue() {
        if(isEmpty()) {
            throw new IlligalArgumentException("Can not dequeue from an empty queue!");
        }
        E ret = this.data[this.front];
        this.data[this.front] = null;
        this.front = (this.front + 1) % this.data.length;
        this.size--;
        if(size == getCapacity() / 4 && getCapacity() / 2 != 0) resize(getCapacity() / 2);
        return ret;
    }

    private void resize(int newCapacity) {
        E[] newArr = (E[]) new Object[newCapacity + 1];
        for(int i = 0; i < this.size; i++) {
            newArr[i] = this.data[(i + this.front) % this.data.length];
        }
        this.front = 0;
        this.tail = this.size;
        this.data = newArr;
    }

    public E getFront() {
        if(isEmpty()) throw new IlligalArgumentException("Queue is empty!");
        return this.data[this.front];
    }
}
