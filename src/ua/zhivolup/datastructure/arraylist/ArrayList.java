package ua.zhivolup.datastructure.arraylist;

import ua.zhivolup.datastructure.List;

public class ArrayList implements List {
    private Object[] array;
    private int size;

    public ArrayList(){
        array = new Object[10];
    }

    public int size(){
        return size;
    }

    public void add(Object value){
        add(size, value);
    }

    public void add(int index, Object value){
        validateIndexForAdding(index);
        if (size == array.length){
            Object[] newArray = new Object[array.length * 2];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = value;
        size ++;
    }

    public Object get(int index) {
        validateIndex(index);
        return array[index];
    }

    public void remove(int index){
        validateIndex(index);
        System.arraycopy(array, index+1, array, index, size - index);
        size --;
    }

    public void remove(Object value){
        System.arraycopy(array, indexOf(value) + 1, array, indexOf(value), size - indexOf(value));
        size --;
    }

    public void set(int index, Object value){
        validateIndex(index);
        array[index] = value;
    }

    public int indexOf(Object value){
        for (int i = 0; i < size; i ++){
            if (array[i].equals(value)){
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(Object value){
        for (int i = size - 1; i >= 0; i --){
            if (array[i].equals(value)){
                return i;
            }
        }
        return -1;
    }

    public boolean contains(Object value){
        for (int i = 0; i < size; i ++){
            if (array[i].equals(value)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String result = "{ ";
        for (int i = 0; i < size; i ++){
            result += array[i];
            if (i < size - 1){
                result += ", ";
            }
        }
        result += " }";
        return result;
    }

    private void validateIndex(int index){
        if (index < 0 || index > size - 1){
            throw new IndexOutOfBoundsException("index " + index + "should be equals or bigger then 0" +
                    "\n and  smaller then " + size);
        }
    }

    private void validateIndexForAdding(int index){
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException("index " + index + "should be equals or bigger then 0" +
                    "\n and equals or smaller than " + size);
        }
    }

    public void clear(){
        size = 0;
    }

    public boolean isEmpty(){
        return size == 0;
    }
}
