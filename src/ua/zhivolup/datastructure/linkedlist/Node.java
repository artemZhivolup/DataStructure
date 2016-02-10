package ua.zhivolup.datastructure.linkedlist;

public class Node<Object> {
    private Node prev;
    private Node next;
    private Object value;

    public Node(Object value){
        this.value = value;
    }

    public Node getPrev() {
        return prev;
    }

    public Node getNext() {
        return next;
    }

    public Object getValue() {
        return value;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
