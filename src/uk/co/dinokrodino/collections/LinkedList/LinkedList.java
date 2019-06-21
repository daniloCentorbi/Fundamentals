package uk.co.dinokrodino.collections.LinkedList;

import java.util.Scanner;

public class LinkedList {

    Scanner scanner = new Scanner(System.in);
    private ListItem root = null;


    public boolean addItem(Item item) {
        if (root == null) {
            root = item;
            return true;
        }
        ListItem currentItem = root;
        ListItem lastAccessed = null;
        while (currentItem != null) {
            int comparator = item.compareTo(currentItem);
            if (comparator == 0) {
                System.out.println("Element present");
                return false;
            } else if (comparator < 0) {
                item.setNext(currentItem);
                item.setPrevious(currentItem.previousItem);
                currentItem.setPrevious(item);
                if (currentItem == root) {
                    root = item;
                }
                return true;
            } else if (comparator > 0) {
                lastAccessed = currentItem;
                currentItem = currentItem.nextItem;
            }
        }
        if (currentItem == null) {
            item.setPrevious(lastAccessed);
            lastAccessed.setNext(item);
            return true;
        }
        return false;
    }

    public void traverseList(ListItem currentItem) {
        System.out.println("0 Go to previous");
        System.out.println("1 Go to next");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 0:
                if (currentItem == root) {
                    System.out.println("we are at the root of the list");
                    traverseList(root);
                    break;
                } else {
                    currentItem = currentItem.movePrevious();
                    System.out.println("Going back you have: " + currentItem.getValue());
                    traverseList(currentItem);
                    break;
                }
            case 1: {
                System.out.println("moveNext " + currentItem);
                currentItem = currentItem.moveNext();
                if (currentItem == null) {
                    System.out.println("We reached the end of the list, bye!");
                } else {
                    System.out.println("Going forward you have: " + currentItem.getValue());
                    traverseList(currentItem);
                    break;
                }
            }
            case 9:
                removeItem(root.nextItem);
                break;
        }
    }

    public void removeItem(ListItem item) {
        ListItem currentItem = root;
        while(currentItem != null) {
            if (currentItem == item){
                System.out.println("inside while" );
                System.out.println("current item: " + currentItem);
                item.nextItem.setPrevious(item.previousItem);
                item.previousItem.setNext(item.nextItem);
                currentItem = null;
                System.out.println("element removed");
            }else {
                currentItem = currentItem.nextItem;
            }
        }
        if(currentItem == null){
            System.out.println("no more element");
        }
    }

    public ListItem getRoot() {
        return root;
    }
}
