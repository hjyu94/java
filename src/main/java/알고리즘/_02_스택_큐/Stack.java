package 알고리즘._02_스택_큐;

import java.util.EmptyStackException;

// 스택은 top 을 가진다.
public class Stack<T> {

    private Node<T> top;

    public T pop() {
        if (top == null) {
            throw new EmptyStackException();
        }
        T item = top.data;
        top = top.next;
        return item;
    }

    public void push(T item) {
        Node<T> pushed = new Node<>(item);
        pushed.next = top;
        top = pushed;
    }

    public T peek() {
        if (top == null) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

}
