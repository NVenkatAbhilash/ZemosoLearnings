import javax.swing.plaf.SliderUI;
import java.util.Iterator;

public class SListIterator<T> implements Iterator<T> {
    private SList<T> currentNode,previousNode;

    SListIterator(){
        currentNode = SList.head;
        previousNode = null;
    }

    @Override
    public boolean hasNext() {
        return currentNode!=null;
    }

    @Override
    public T next() {
        T data = currentNode.data;
        previousNode = currentNode;
        currentNode = currentNode.next;
        return data;
    }

    @Override
    public void remove() {
        if(previousNode!=null) {
            previousNode.next = currentNode.next;

        }
        else {
            SList.head = currentNode.next;
        }
        currentNode = currentNode.next;
    }

    public void insert(T data){
        SList<T> newNode = new SList<>(data);
        newNode.next = currentNode;
        if(previousNode!=null){
            previousNode.next = newNode;
        }
        else {
            SList.head = newNode;
        }
        currentNode = newNode;
    }
}
