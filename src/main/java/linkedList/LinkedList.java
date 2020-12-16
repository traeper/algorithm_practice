package linkedList;

/**
 * @author traeper
 */
interface LinkedList<E> {
    void add(int index, E element);

    void addFirst(E element);

    void addLast(E element);

    boolean contains(E element);

    int indexOf(E element);

    E get(int index);

    E getFirst();

    E getLast();

    E removeFirst();

    E removeLast();

    int size();
}
