import java.util.Iterator;
import java.util.LinkedList;

public class SList<T> {
    public static SList head;
    public T data;
    public SList<T> next;

    SList(T data) {
        this.data = data;
        if(head == null)
            head = this;
    }

    public SListIterator iterator() {
        return new SListIterator();
    }

    public String toString() {
        Iterator<T> it = iterator();
        if (! it.hasNext())
            return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        while (true){
            T e = it.next();
            sb.append(e);
            if (! it.hasNext())
                return sb.append(']').toString();
            sb.append(',').append(' ');
        }
    }
}
