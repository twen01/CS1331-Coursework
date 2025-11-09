//I worked on the homework assignment alone, using only course materials.

/**
 * Class to manage data in a linked list.
 *
 * @author Thomas Wen
 * @version 1
 * @param <E> the type of elements in this linked list
 */
public class LinkedList<E> {
    /**
     * Private inner class.
     *
     * @author Thomas Wen
     * @version 1
     * @param <E> the type of elements in this node
     */
    private class Node<E> {
        private E data;
        private Node<E> next;

        private Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<E> head;
    private int size;

    /**
     * 0-arg constructor.
     *
     */
    public LinkedList() {
        head = null;
        size = 0;
    }

    /**
     * Get size.
     *
     * @return size
     */
    public int size() {
        return size;
    }

    /**
     * Is size 0?.
     *
     * @return size is 0?
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Clear list.
     */
    public void clear() {
        head = null;
        size = 0;
    }

    /**
     * Add a value at specific index.
     *
     * @param index index to add
     * @param data  data to add
     * @throws IndexOutOfBoundsException if index is out of bounds
     */
    public void add(int index, E data) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }

        Node<E> current = head;
        if (index == 0) {
            head = new Node<>(data, head);
        } else {
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = new Node<>(data, current.next);
        }
        size++;
    }

    /**
     * Add data at end.
     *
     * @param data data to add
     */
    public void add(E data) {
        add(size, data);
    }

    /**
     * Returns whether the value is in the linked list.
     *
     * @param o an object
     * @return a boolean
     */
    public boolean contains(Object o) {
        Node<E> current = head;
        while (current != null) {
            if (o == null && current.data == null) {
                return true;
            }
            if (current.data != null && o.equals(current.data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /**
     * Returns value at index.
     *
     * @param index an index
     * @return an E
     * @throws IndexOutOfBoundsException if index is out of bounds
     */
    public E get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    /**
     * Returns index of first occurrence.
     *
     * @param o an Object
     * @return an int
     */
    public int indexOf(Object o) {
        Node<E> current = head;
        int index = 0;

        while (current != null) {
            if (o == null && current.data == null) {
                return index;
            }
            if (o != null && o.equals(current.data)) {
                return index;
            }
            current = current.next;
        }

        return -1;
    }

    /**
     * Removes at index.
     *
     * @param index the index
     * @return an E
     * @throws IndexOutOfBoundsException if index is out of bounds
     */
    public E remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }

        Node<E> current = head;
        if (index == 0) {
            head = head.next;
            size--;
            return current.data;
        }

        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        E remove = current.next.data;
        current.next = current.next.next;
        size--;

        return remove;
    }

    /**
     * Removes first occurrence.
     *
     * @param o an Object
     * @return a boolean
     */
    public boolean remove(Object o) {
        Node<E> current = head;
        if (current == null) {
            return false;
        }
        if (o == null && current.data == null) {
            head = head.next;
            size--;
            return true;
        }
        while (current.next != null) {
            if (o == null && current.next.data == null
                    || o.equals(current.next.data)) {
                current.next = current.next.next;
                size--;
                return true;
            }

            current = current.next;
        }
        return false;
    }

    /**
     * Updates value at index.
     *
     * @param index the index
     * @param data  the data
     * @return old E
     * @throws IndexOutOfBoundsException if index is out of bounds
     */
    public E set(int index, E data) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }

        Node<E> current = head;
        E oldData;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        oldData = current.data;
        current.data = data;
        return oldData;
    }

    /**
     * To String method.
     *
     * @return a String
     */
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        Node<E> current = head;
        String output = "[";
        while (current != null) {
            if (current.data == null) {
                output += "null";
            } else {
                output += String.valueOf(current.data);
            }
            current = current.next;
            if (current != null) {
                output += ", ";
            }
        }
        output += "]";
        return output;
    }

    /**
     * Equals method that returns true.
     *
     * @param o an Object
     * @return true
     */
    public boolean equals(Object o) {
        return true;
    }
}
