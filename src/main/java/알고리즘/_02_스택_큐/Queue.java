// https://youtu.be/W3jNbNGyjMs

package 알고리즘._02_스택_큐;

import java.util.NoSuchElementException;

// 큐는 first, last 노드를 가진다.
public class Queue<T> {

    private Node<T> first;
    private Node<T> last;

    public void add(T item) {
        Node<T> newNode = new Node<>(item);
        if (last != null) {
            last.next = newNode;
        }
        last = newNode;
        if (first == null) {
            first = newNode;
        }
    }

    public T remove() {
        if(first == null) {
            throw new NoSuchElementException();
        }

        T data = first.data;
        first = first.next;

        if(first == null) {
            last = null;
        }

        return data;
    }

    public T peek() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        return first.data;
    }

    public boolean isEmpty() {
        return first == null;
    }

}
