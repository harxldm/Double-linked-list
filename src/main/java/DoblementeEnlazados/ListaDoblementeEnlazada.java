/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DoblementeEnlazados;
import java.util.Iterator;

/**
 *
 * @author harxl
 */
public class ListaDoblementeEnlazada<Item> implements Iterable{
    Node first;
    Node last;
    int count;

    
    private class Node {
    Item item;
    Node next;
    Node preview;
        
    }
    
    public void addLast(Item item) {
        Node oldLast = last;
        Node last = new Node();
        last.item = item;
        last.preview = oldLast;
        count++;
    }
    
    public void addFirst(Item item) {
        Node oldFirst = first;
        Node first = new Node();
        first.item = item;
        first.next = oldFirst;
        count++;
    }
    
    public Item remove() {
        Item item = last.item;
        last.item = null;
        last = last.preview ;
        count--;
        if(isEmpty())
            last = null;
        return item;
    }
    
    public boolean isEmpty() {
        return count == 0;
    }
    
    public int size() {
        return count ;
    }
    
    public void add(int i, Item item) {
       int cont = 0;
        for (Node x = first; x != null; x = x.next) {
            if (cont == i) {
                Node prev = x.preview;
                Node newNode = new Node();
                newNode.item = item;
                prev.next = newNode;
                x.preview = newNode;
                newNode.next = x;
                count++;
            } else {
                cont++;
            }
        }
    }
    
    public void set(int i, Item item) {
        int cont = 0;
        for (Node x = first; x != null; x = x.next) {
            if (cont == i) {
                x.item = item;
                count++;
            } else {
                cont++;
            }
        }
    }
    
    public void removeByElement(Item item) {
        for (Node x = first; x != null; x = x.next) {
            if (x.item.equals(item)) {
                Node prev = x.preview;
                Node next = x.next;
                
                if (prev != null) {
                prev.next = next;
            } else {
                first = next;
            }

            if (next != null) {
                next.preview = prev;
            } else {
                last = prev;
            }
                count--;
                break;
            }
        }
    }
    
      @Override
     public Iterator<Item> iterator() {
        return new LinkedListIterator ();  
     }
    private class LinkedListIterator implements Iterator<Item>{
        
        private Node current = first;

        @Override
        public boolean hasNext() {
             return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
        
    }
}
