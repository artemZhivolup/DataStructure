package ua.zhivolup.datastructure.linkedlist;

import ua.zhivolup.datastructure.List;

public class LinkedList implements List {
    private Node first;
    private Node last;
    private int size;

    @Override
    public void add(Object value) {
        add(size, value);
    }

    @Override
    public void add(int index, Object value) {
        validateIndexForAdding(index);
        Node node = new Node(value);

        if (index == 0) {
            if (size == 0){
                first = last = node;
            }
            node.setPrev(null);
            node.setNext(first);
            first = node;
        }

        if(index == size){
            last.setNext(node);
            node.setPrev(last);
            node.setNext(null);
            last = node;
        }

        Node current = first;
        for (int i = 1; i <= index; i ++) {
            if (i == index) {
                Node next = current.getNext();
                current.setNext(node);
                next.setPrev(node);
                node.setPrev(current);
                node.setNext(next);
            }
            current = current.getNext();
        }
        size ++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object get(int index) {
        validateIndex(index);
        Node node = first;
        for(int i = 0; i < index; i++) {
            node = node.getNext();
        }
        return node.getValue();
    }

    @Override
    public void remove(int index) {
        validateIndex(index);
        if (index == 0) {
            if (size == 1) {
                first = null;
                last = null;
                size = 0;
                return;
            }
            first = first.getNext();
            first.setPrev(null);
            size --;
            return;
        }

        Node node = first;
        for (int i = 0; i < size-1; i++) {
            if (i == index) {
                Node prev = node.getPrev();
                Node next = node.getNext();

                prev.setNext(next);
                next.setPrev(prev);
                size --;
                return;
            }
            node = node.getNext();
        }

        if (index == size-1) {
            last = last.getPrev();
            last.setNext(null);
            size --;
        }
    }

    @Override
    public void remove(Object value) {

        Node node = first;
        for (int i = 0; i < size; i ++) {

            if (get(i).equals(value)) {
                remove(i);
            }
            node = node.getNext();
        }
    }

    @Override
    public void set(int index, Object value) {
        validateIndex(index);
        Node node = first;
        for (int i = 0; i < size; i ++) {
            if (i == index){
                node.setValue(value);
                return;
            }
            node = node.getNext();
        }
    }

    @Override
    public int indexOf(Object value) {
        for (int i = 0; i < size; i ++) {
            if (get(i).equals(value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        for (int i = size - 1; i >= 0; i --) {
            if (get(i).equals(value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(Object value) {
        return indexOf(value) != -1;
    }

    @Override
    public void clear() {
        Node node = first;
        for (int i = 0; i < size; i ++){
            Node next = node.getNext();
            node.setValue(null);
            node.setNext(null);
            node.setPrev(null);
            node = next;
        }
        first = last = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder("");
        Node node = first;
        for (int i = 0; i < size; i ++) {
            str.append(node.getValue() + "\n");
            node = node.getNext();
        }
        return str.toString();
    }

    public void validateIndex(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("index " + index + " should be equals or bigger then 0" +
                    "\n and smaller than " + size);
        }
    }

    public void validateIndexForAdding(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index " + index + " should be equals or bigger then 0" +
                    "\n and equals or smaller than " + size);
        }
    }
}
