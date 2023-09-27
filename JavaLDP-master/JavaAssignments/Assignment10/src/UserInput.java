import java.util.Scanner;

public class UserInput {
    private int currentPosition;
    private SListIterator<Integer> listIterator;
    private SList<Integer> head;
    private Scanner scannerObject;

    UserInput() {
        currentPosition = 0;
        scannerObject = new Scanner(System.in);
        head = new SList<>(0);
        listIterator = head.iterator();
        listIterator.remove();
    }

    private void insert() {
        System.out.println("Enter element to insert:");
        int data = scannerObject.nextInt();
        listIterator.insert(data);
        if (currentPosition == 0)
            currentPosition = 1;
    }

    private void delete() {
        if (listIterator.hasNext()) {
            listIterator.remove();
            currentPosition++;
        } else
            System.out.println("deletion not possible");
    }

    private void moveToNext() {
        if (listIterator.hasNext()) {
            listIterator.next();
            currentPosition++;
            System.out.println("Current position : " + currentPosition);
        } else {
            System.out.println("No elements ahead");
        }
    }

    private void moveToHead() {
        if (head != null) {
            listIterator = head.iterator();
            currentPosition = 0;
        }
    }

    private void display() {
        if (head == null)
            System.out.println("Empty list");
        else
            System.out.println(head);
    }

    public void startProgram() {
        while (true) {
            System.out.println("enter 1-insert 2-delete 3-move_to_next 4-move_to_head 5-display_objects 6-to_exit");
            int operation = scannerObject.nextInt();
            switch (operation) {
                case 1:
                    insert();
                    break;
                case 2:
                    delete();
                    break;
                case 3:
                    moveToNext();
                    break;
                case 4:
                    moveToHead();
                    break;
                case 5:
                    display();
                    break;
                case 6:
                    System.out.println("Bye bye");
                    return;
                default:
                    System.out.println("Please enter valid operation number");
            }
        }
    }
}
