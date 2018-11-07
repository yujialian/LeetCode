public class LinkedListStack<E> implements Stack<E> {
    private LinkedList<E> stack;
    public LinkedListStack() {
        stack = new LinkedList<E>();
    }
    public LinkedListStack(List<E> list) {
        this.stack = list;
    }
    @Override
    public int getSize() { return stack.size(); }

    @Override
    public boolean isEmpty() { return stack.isEmpty(); }

    @Override
    public void push(E e) { stack.add(e); }

    @Override
    public E pop() { 
        if(stack.isEmpty()) throw new IlligalArgumentException("Empty stack~!");
        return stack.remove(stack.size() - 1);
    }

    @Override
    public E peek() {
        if(stack.isEmpty()) throw new IlligalArgumentException("Empty stack~!");
        return stack.get(stack.size() - 1);
    }
}
