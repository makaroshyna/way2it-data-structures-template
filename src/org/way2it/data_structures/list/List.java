package org.way2it.data_structures.list;

import java.util.Arrays;

public class List {

    // Represent values in this list
    private String[] values = new String[4];

    // Represent the number of values that were added to this list
    private int length = 0;

    public List() {
    }

    // Should add new value to the end of the list, increment length and extend array by x2 if needed
    public void add(String value) {
        if (values.length == length) {
            values = newValues(values);
        }
        values[length] = value;
        length++;
    }

    // Should add new value at the specified index, moving other values to the right,
    // increment length and extend array by x2 if needed
    public void addAtIndex(String value, int index) {
        if (values.length == length) {
            values = newValues(values);
        }
        String[] result = new String[values.length];
        System.arraycopy(values, 0, result, 0, index);
        System.arraycopy(values, index, result, index + 1, values.length - index - 1);
        result[index] = value;
        values = Arrays.copyOf(result, values.length);
        length++;
    }

    // Should return a value at specified index, or null if index is out of list bounds
    public String get(int index) {
        if (index > length) {
            return null;
        } else {
            return values[index];
        }
    }

    // Should return the index of the first occurrence of specified value in list
    // If the value does not exist - return -1
    public int indexOf(String value) {
        for (int i = 0; i < length; i++) {
            if (values[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    // Should remove the value at specified index, decrementing the length of this list and moving next values to the left
    public void remove(int index) {
        String[] result = new String[values.length];
        System.arraycopy(values, 0, result, 0, index);
        System.arraycopy(values, index + 1, result, index, values.length - index - 1);
        values = Arrays.copyOf(result, values.length);
        length--;
    }

    public int getLength() {
        return length;
    }

    private String[] newValues(String[] values) {
        String[] newValues = Arrays.copyOf(values, values.length * 2);
        return newValues;
    }
}
