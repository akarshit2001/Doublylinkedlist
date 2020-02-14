package Defination;

import adt.LinkedlistAdt;

public class Defination<E> implements LinkedlistAdt<E> {
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public void addFirst(E data) {
        if (head == null) {
            Node<E> node = new Node<E>(data, null, null);
            head = node;
            tail = node;
        } else {
            Node<E> node1 = null;
            node1 = new Node<E>(data, null, head);
            // this below statement means the preious of head that is the node we add first next.
            head.previous = node1;
            head = node1;
        }
        size++;

    }

    public void addAfter(Node<E> node, E data) {
        Node<E> nextNode = node.getNext();
        if (nextNode == null) {
            Node<E> node3 = new Node<E>(data, node, null);
            node.next = node3;
            tail = node3;
        } else {
            Node<E> node3 = new Node<E>(data, node, nextNode);
            node.next = node3;
            node.getNext().previous = node3;


        }
        size++;
    }

    public void addAt(int index, E data) {
        if (index == 0) {
            addFirst(data);

        } else {


            addAfter(getNode(index - 1), data);
        }

    }


    public Node<E> getNode(int index) {
        Node<E> response = head;
        for (int i = 0; i < index && response != null; i++) {
            response = response.getNext();
        }
        return response;

    }

    //public void addAt
    public E removeFirst() {
        E response;
        Node<E> temp = head;
        response = temp.getData();
        head = head.next;
        size--;
        return response;
    }

    public E removeAfter(Node<E> node) {
        E response = null;
        Node<E> node4 = node.getNext();
        if (node4 != null) {
            response = node4.getData();
            node.next = node4.getNext();
            size--;
        }
        return response;
    }

    public E removeAt(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        } else if (index == 0) {
            return removeFirst();

        } else {
            Node<E> store = getNode(index - 1);
            return removeAfter(store);
        }
    }

    @Override
    public void add(E item) {
        addAt(size, item);
    }

    @Override
    public E remove(int index) {
        return removeAt(index);
    }


    @Override
    public int search(E item) {
        Node<E> temp = head;
        int c = 0;
        for (int i = 0; i < size; i++) {

            E response = temp.getData();
            if (response.equals(item)) {
                c = 1;

            }
            temp = temp.getNext();

        }
        return c;

    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("[");
        Node<E> temp = head;
        for (int i = 0; i < size && temp != null; i++) {
            E data = temp.getData();
            sb.append(data);
            sb.append((i < size - 1) ? "," : "");
            temp = temp.getNext();

        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public void sort() {

    }

    private static class Node<E> {
        private E data;
        private Node<E> previous = null;
        private Node<E> next = null;

        public Node(E data) {
            this.data = data;
        }

        public Node(E data, Node<E> previous, Node<E> next) {
            this.data = data;
            this.previous = previous;
            this.next = next;
        }

        public E getData() {
            return data;
        }

        public Node<E> getNext() {
            return next;
        }

        public Node<E> getPrevious() {
            return previous;
        }
    }

}
