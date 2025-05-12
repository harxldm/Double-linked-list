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
    }
    
    public void addFirst(Item item) {
        Node oldFirst = first;
        Node first = new Node();
        first.item = item;
        first.next = oldFirst;
    }
    
    public void add(Item item) {
        
    }
    
    
          
    @Override
    public Iterator iterator() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
