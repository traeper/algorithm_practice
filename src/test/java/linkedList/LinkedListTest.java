package linkedList;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author traeper
 */
public class LinkedListTest {

    @Test
    void addFirst_one_element_exists() {
        final LinkedList<Integer> linkedList = new LinkedListImpl<>();
        linkedList.addFirst(1);
        assertThat(linkedList.contains(1)).isTrue();
        assertThat(linkedList.get(0)).isEqualTo(1);
        assertThat(linkedList.indexOf(1)).isEqualTo(0);
        assertThat(Objects.equals(linkedList.getFirst(), linkedList.getLast())).isTrue();

        checkSize(linkedList, 1);
    }

    @Test
    void addFirst_null() {
        final LinkedList<Integer> linkedList = new LinkedListImpl<>();
        linkedList.addFirst(null);
        assertThat(linkedList.contains(null)).isTrue();
        assertThat(linkedList.get(0)).isEqualTo(null);
        assertThat(linkedList.indexOf(1)).isEqualTo(-1);
        assertThat(linkedList.indexOf(null)).isEqualTo(0);
        assertThat(Objects.equals(linkedList.getFirst(), linkedList.getLast())).isTrue();

        checkSize(linkedList, 1);
    }

    @Test
    void addFirst_addFirst_right_order() {
        final LinkedList<Integer> linkedList = new LinkedListImpl<>();
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        assertThat(linkedList.getFirst()).isEqualTo(2);
        assertThat(linkedList.get(0)).isEqualTo(2);
        assertThat(linkedList.indexOf(2)).isEqualTo(0);
        assertThat(linkedList.getLast()).isEqualTo(1);
        assertThat(linkedList.get(1)).isEqualTo(1);
        assertThat(linkedList.indexOf(1)).isEqualTo(1);
        assertThat(linkedList.contains(1)).isTrue();

        checkSize(linkedList, 2);
    }

    @Test
    void addFirst_addLast_right_order() {
        final LinkedList<Integer> linkedList = new LinkedListImpl<>();
        linkedList.addFirst(1);
        linkedList.addLast(2);
        assertThat(linkedList.getFirst()).isEqualTo(1);
        assertThat(linkedList.get(0)).isEqualTo(1);
        assertThat(linkedList.indexOf(1)).isEqualTo(0);
        assertThat(linkedList.getLast()).isEqualTo(2);
        assertThat(linkedList.get(1)).isEqualTo(2);
        assertThat(linkedList.indexOf(2)).isEqualTo(1);

        checkSize(linkedList, 2);
    }

    @Test
    void addFirst_removeFirst_empty() {
        final LinkedList<Integer> linkedList = new LinkedListImpl<>();
        linkedList.addFirst(1);
        assertThat(linkedList.removeFirst()).isEqualTo(1);
        assertThrows(NoSuchElementException.class, linkedList::getFirst);
        assertThrows(NoSuchElementException.class, linkedList::getLast);
        checkSize(linkedList, 0);
    }

    @Test
    void addFirst_removeLast_empty() {
        final LinkedList<Integer> linkedList = new LinkedListImpl<>();
        linkedList.addFirst(1);
        assertThat(linkedList.removeLast()).isEqualTo(1);
        assertThrows(NoSuchElementException.class, linkedList::getFirst);
        assertThrows(NoSuchElementException.class, linkedList::getLast);

        checkSize(linkedList, 0);
    }

    @Test
    void addFirst_twice_removeFirst_last_one_remains() {
        final LinkedList<Integer> linkedList = new LinkedListImpl<>();
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        assertThat(linkedList.removeFirst()).isEqualTo(2);
        assertThat(linkedList.getFirst()).isEqualTo(1);
        assertThat(linkedList.getLast()).isEqualTo(1);
        assertThat(Objects.equals(linkedList.getFirst(), linkedList.getLast())).isTrue();
        checkSize(linkedList, 1);
    }

    @Test
    void addFirst_twice_removeLast_first_one_remains() {
        final LinkedList<Integer> linkedList = new LinkedListImpl<>();
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        assertThat(linkedList.removeLast()).isEqualTo(1);
        assertThat(linkedList.getFirst()).isEqualTo(2);
        assertThat(linkedList.getLast()).isEqualTo(2);
        assertThat(Objects.equals(linkedList.getFirst(), linkedList.getLast())).isTrue();
        checkSize(linkedList, 1);
    }

    @Test
    void addFirst_3times_3_remains() {
        final LinkedList<Integer> linkedList = new LinkedListImpl<>();
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addFirst(3);
        assertThat(linkedList.getFirst()).isEqualTo(3);
        assertThat(linkedList.getLast()).isEqualTo(1);
        checkSize(linkedList, 3);
    }

    @Test
    void add_one_to_wrong_index_exception_raised() {
        final LinkedList<Integer> linkedList = new LinkedListImpl<>();
        String msg1 = assertThrows(IndexOutOfBoundsException.class, () -> linkedList.add(-1, 1)).getMessage();
        assertThat(msg1).isEqualTo("Index: " + (-1) + ", Size: " + 0);
        String msg2 = assertThrows(IndexOutOfBoundsException.class, () -> linkedList.add(9999, 1)).getMessage();
        assertThat(msg2).isEqualTo("Index: " + 9999 + ", Size: " + 0);
    }

    @Test
    void add_one_to_0index_element_exists() {
        final LinkedList<Integer> linkedList = new LinkedListImpl<>();
        linkedList.add(0, 1);
        assertThat(linkedList.contains(1)).isTrue();
        assertThat(Objects.equals(linkedList.getFirst(), linkedList.getLast())).isTrue();

        checkSize(linkedList, 1);
    }

    @Test
    void add_twice_element_exists() {
        final LinkedList<Integer> linkedList = new LinkedListImpl<>();
        linkedList.add(0, 1);
        linkedList.add(0, 2);
        assertThat(linkedList.getFirst()).isEqualTo(2);
        assertThat(linkedList.get(0)).isEqualTo(2);
        assertThat(linkedList.getLast()).isEqualTo(1);
        assertThat(linkedList.get(1)).isEqualTo(1);

        checkSize(linkedList, 2);
    }

    @Test
    void complicate_add_element_exists() {
        final LinkedList<Integer> linkedList = new LinkedListImpl<>();
        linkedList.addFirst(1);
        linkedList.add(0, 2);
        linkedList.addFirst(3);
        linkedList.add(1, 4);
        assertThat(linkedList.get(0)).isEqualTo(3);
        assertThat(linkedList.get(1)).isEqualTo(4);
        assertThat(linkedList.get(2)).isEqualTo(2);
        assertThat(linkedList.get(3)).isEqualTo(1);

        checkSize(linkedList, 4);
    }

    @Test
    void add_same_element_indexOf_first_index() {
        final LinkedList<Integer> linkedList = new LinkedListImpl<>();
        linkedList.addFirst(1);
        linkedList.addFirst(1);
        assertThat(linkedList.indexOf(1)).isEqualTo(0);
        checkSize(linkedList, 2);
    }

    private void checkSize(LinkedList<Integer> linkedList, int size) {
        assertThat(linkedList.size()).isEqualTo(size);
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(size));
    }
}
