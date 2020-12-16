package dataStructure.linkedList;

import java.util.NoSuchElementException;

/**
 * @author traeper
 */
public class LinkedListImpl<E> implements LinkedList<E> {
    private Node<E> first;
    private Node<E> last;
    private int size;

    public LinkedListImpl() {
        first = null;
        size = 0;
    }

    @Override
    public void add(int index, E element) {
        if (!isPositionIndex(index)) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }

        if (index == 0) {
            addFirst(element);
        } else if (index == size) {
            addLast(element);
        } else {
            Node<E> node = getNode(index);
            Node<E> prev = node.prev;
            Node<E> newNode = new Node<>(element);

            prev.next = newNode;
            newNode.prev = prev;
            newNode.next = node;
            node.prev = newNode;
            size++;
        }
    }

    private Node<E> getNode(int index) {
        // java.util.LinkedList 구현을 따옴. 성능 개선 코드
        Node<E> ptr;
        if (index < (size >> 1)) {
            ptr = first;
            for (int i = 0; i < index; i++) {
                ptr = ptr.next;
            }
        } else {
            ptr = last;
            for (int i = size - 1; i > index; i--)
                ptr = ptr.prev;
        }
        return ptr;
    }

    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }

    @Override
    public void addFirst(E element) {
        Node<E> newNode = new Node<>(element);
        if (first == null) {
            last = newNode;
        } else {
            first.prev = newNode;
            newNode.next = first;
        }
        first = newNode;
        size++;
    }

    @Override
    public void addLast(E element) {
        Node<E> newNode = new Node<>(element);
        if (last == null) {
            first = newNode;
        } else {
            last.next = newNode;
            newNode.prev = last;
        }
        last = newNode;
        size++;
    }

    @Override
    public boolean contains(E element) {
        return indexOf(element) != -1;
    }

    @Override
    public int indexOf(E element) {
        int index = 0;
        if (element == null) {
            for (Node<E> node = first; node != null; node = node.next) {
                if (node.element == null) {
                    return index;
                }
                index++;
            }
        } else {
            for (Node<E> node = first; node != null; node = node.next) {
                if (element.equals(node.element)) {
                    return index;
                }
                index++;
            }
        }
        return -1;
    }

    @Override
    public E get(int index) {
        if (!isElementIndex(index)) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }

        return getNode(index).element;
    }

    @Override
    public E getFirst() {
        final Node<E> f = first;
        if (f == null)
            throw new NoSuchElementException();

        return f.element;
    }

    @Override
    public E getLast() {
        final Node<E> l = last;
        if (l == null)
            throw new NoSuchElementException();

        return l.element;
    }

    @Override
    public E removeFirst() {
        final Node<E> f = first;
        if (f == null) {
            throw new NoSuchElementException();
        }

        final Node<E> next = f.next;
        final E e = f.element;

        first = next;

        // Help GC
        f.element = null;
        f.next = null;

        if (next == null) {
            last = null;
        } else {
            next.prev = null;
        }

        size--;
        return e;
    }

    @Override
    public E removeLast() {
        final Node<E> l = last;
        if (l == null) {
            throw new NoSuchElementException();
        }

        final Node<E> prev = l.prev;
        final E e = l.element;

        last = prev;

        // Help GC
        l.element = null;
        l.prev = null;

        if (prev == null) {
            first = null;
        } else {
            prev.next = null;
        }

        size--;
        return e;
    }

    @Override
    public int size() {
        return size;
    }

    private static class Node<E> {
        private E element;
        private Node<E> prev;
        private Node<E> next;

        public Node(E element) {
            this.element = element;
        }
    }
}
