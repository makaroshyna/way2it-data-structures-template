package org.way2it.data_structures.linked_list;

public class LinkedList {

    // Represents the first node of this list
    // Should be initialized when first value is added
    private Node head;

    // Represents the number of values that were added to this list
    private int length = 0;

    public LinkedList() {
    }

    // Should add new value to the end of the list and increment length
    public void add(String value) {
        Node node = new Node();
        node.value = value;
        if (head == null) {
            head = node;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
        length++;
    }

    // Should add new value next to specified afterValue, increment length and return true
    // If afterValue is not present in list - do nothing and return false.
    public boolean addAfter(String value, String afterValue) {
        Node current = head;
        Node node = new Node();
        node.value = value;
        while (current != null) {
            if (current.value.equals(afterValue)) {
                node.next = current.next;
                current.next = node;
                length++;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Should return true if value exists in this list, false - otherwise
    public boolean contains(String value) {
        Node current = head;
        while (current != null) {
           if (current.value.equals(value)) {
               return true;
           }
           current = current.next;
        }
        return false;
    }

    // Should remove first occurrence of the specified value from this list and decrement the length
    // If value existed and was removed - return true, false - otherwise
    public boolean remove(String value) {
        if (head != null && head.value.equals(value)) {
            head = head.next;
            length--;
            return true;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.value.equals(value)) {
                current.next = current.next.next;
                length--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public int getLength() {
        return length;
    }

    private static class Node {
        String value;
        Node next;
    }
}
