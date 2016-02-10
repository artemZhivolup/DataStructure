package ua.zhivolup.datastructure;

public interface List {

    void add(Object value);
    void add(int index, Object value);
    int size();
    Object get(int index);
    void remove(int index);
    void remove(Object value);
    void set(int index, Object value);
    int indexOf(Object value);
    int lastIndexOf(Object value);
    boolean contains(Object value);
    void clear();
    boolean isEmpty();
}
