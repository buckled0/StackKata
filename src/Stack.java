
public class Stack {
    private int size = 0;
    private int[] elements;

    public static Stack create(int capacity) {
        if(capacity < 1)
            throw new IllegalCapacity();

        return new Stack(capacity);
    }

    private Stack(int capacity) {
        elements = new int[capacity];
    }

    public void push(int element) {
        if(isAtCapacity())
            throw new Overflow();

        this.elements[size++] = element;
    }

    public int pop() {
        if(isEmpty())
            throw new Underflow();

        return elements[--size];
    }

    public int peek() {
        if(isEmpty())
            throw new Empty();

        return elements[size-1];
    }

    public Integer search(int element) {
        for(int i = size-1; i >= 0; i--)
            if(elements[i] == element)
                return (size - 1) - i;
        return null;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private boolean isAtCapacity() {
        return size == elements.length;
    }

    public static class Underflow extends RuntimeException { }
    public static class Overflow extends RuntimeException { }
    public static class IllegalCapacity extends RuntimeException { }
    public static class Empty extends RuntimeException { }
}
