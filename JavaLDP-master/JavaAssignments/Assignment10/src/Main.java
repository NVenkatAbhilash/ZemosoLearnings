import java.util.Iterator;
import java.util.Scanner;

public class Main {
    private static void manualEntry(){
        SList<Integer> head = new SList<>(0);
        System.out.println(head);
        SListIterator<Integer> listIterator = head.iterator();
        //insert data through iterator
        listIterator.insert(1);
        System.out.println(head);
        listIterator.next();
        listIterator.insert(2);
        System.out.println(head);
        listIterator = head.iterator();
        //remove data through iterator
        listIterator.remove();
        System.out.println(head);
        listIterator.next();
        listIterator.remove();
        System.out.println(head);
        if(listIterator.hasNext())
            listIterator.remove();
        listIterator = head.iterator();
        if(listIterator.hasNext())
            listIterator.remove();
        System.out.println(head);
    }

    public static void main(String args[]){
        boolean takeUserInput = true;
        if(takeUserInput) {
            UserInput program = new UserInput();
            program.startProgram();
        }
        else
            manualEntry();
    }
}
