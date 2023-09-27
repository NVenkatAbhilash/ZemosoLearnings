
import java.util.AbstractList;


/** A class that implements a doubly linked list
 *
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
class MyLinkedList<E> extends AbstractList<E> {
    LLNode<E> head;
    LLNode<E> tail;
    int size;

    /** Create a new empty LinkedList */
    public MyLinkedList() {
        // TODO: Implement this method
        head = new LLNode<>(null);
        tail = new LLNode<>(null);
        size = 0;
        head.next = tail;
        tail.prev = head;
    }

    /**
     * Appends an element to the end of the list
     * @param element The element to add
     */
    public boolean add(E element )
    {
        // TODO: Implement this method
        if(element==null)
            throw new NullPointerException();
        LLNode<E> newNode = new LLNode<>(element);
        LLNode<E> prevNode = tail.prev;
        newNode.prev = prevNode;
        newNode.next = tail;
        prevNode.next = newNode;
        tail.prev = newNode;
        size++;
        return true;
    }

    /** Get the element at position index
     * @throws IndexOutOfBoundsException if the index is out of bounds. */
    public E get(int index)
    {
        // TODO: Implement this method.
        if(index<0 || index>=size) {
            throw new IndexOutOfBoundsException();
        }
        LLNode<E> node = head.next;
        for(int i=0;i<index;i++)
            node = node.next;
        return node.data;
    }

    /**
     * Add an element to the list at the specified index
     * @param The index where the element should be added
     * @param element The element to add
     */
    public void add(int index, E element )
    {
        // TODO: Implement this method
        if(element==null)
            throw new NullPointerException();
        if(index<0 || index>size) {
            throw new IndexOutOfBoundsException();
        }
        LLNode<E> newNode = new LLNode<>(element);
        LLNode<E> prevNode = head;
        while(index!=0) {
            prevNode = prevNode.next;
            index--;
        }
        newNode.prev = prevNode;
        newNode.next = prevNode.next;
        prevNode.next = newNode;
        newNode.next.prev = newNode;
        size++;
    }


    /** Return the size of the list */
    public int size()
    {
        // TODO: Implement this method
        return size;
    }

    /** Remove a node at the specified index and return its data element.
     * @param index The index of the element to remove
     * @return The data element removed
     * @throws IndexOutOfBoundsException If index is outside the bounds of the list
     *
     */
    public E remove(int index)
    {
        // TODO: Implement this method
        if(index<0 || index>=size) {
            throw new IndexOutOfBoundsException();
        }
        LLNode<E> node,prevNode = head;
        while(index!=0) {
            prevNode = prevNode.next;
            index--;
        }
        node = prevNode.next;
        node.next.prev = prevNode;
        prevNode.next = node.next;
        size--;
        return node.data;
    }

    /**
     * Set an index position in the list to a new element
     * @param index The index of the element to change
     * @param element The new element
     * @return The element that was replaced
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    public E set(int index, E element)
    {
        // TODO: Implement this method
        if(element==null)
            throw new NullPointerException();
        if(index<0 || index>size) {
            throw new IndexOutOfBoundsException();
        }
        LLNode<E> newNode = new LLNode<>(element);
        LLNode<E> node = head.next;
        while(index!=0) {
            node = node.next;
            index--;
        }
        E data = node.data;
        node.data = element;
        return data;
    }

    public void display(){
        LLNode<E> node = head.next;
        for(int i=0;i<size;i++) {
            System.out.print(node.data+" ");
            node = node.next;
        }
        System.out.println();
    }
}


class LLNode<E>
{
    LLNode<E> prev;
    LLNode<E> next;
    E data;

    // TODO: Add any other methods you think are useful here
    // E.g. you might want to add another constructor

    public LLNode(E e)
    {
        this.data = e;
        this.prev = null;
        this.next = null;
    }

}

public class LinkedListDemo {
    public static void main(String args[]){
        MyLinkedList<Integer> ddl = new MyLinkedList<>();
        ddl.add(4);
        ddl.add(14);
        ddl.add(42);
        ddl.display();
        ddl.add(0,0);
        ddl.add(2,2);
        ddl.add(5,5);
        ddl.display();
        ddl.add(6);
        ddl.remove(0);
        ddl.remove(5);
        ddl.display();
        ddl.set(0,100);
        System.out.println(ddl.get(0));
        ddl.display();
    }
}
