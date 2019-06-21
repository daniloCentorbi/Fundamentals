package uk.co.dinokrodino.collections.LinkedList;

public class Item extends ListItem {

    public Item(Object item) {
        super(item);
    }

    @Override
    ListItem movePrevious() {
        return this.previousItem;
    }

    @Override
    ListItem moveNext() {
        return this.nextItem;
    }

    @Override
    ListItem setPrevious(ListItem item) {
        this.previousItem = item;
        return previousItem;
    }

    @Override
    ListItem setNext(ListItem item) {
        this.nextItem = item;
        return null;
    }

    @Override
    int compareTo(ListItem item) {
        if(item != null) {
            int comparator = ((String) this.getValue()).compareTo((String) item.getValue());
            return comparator;
        }else{
            return -1;
        }

    }

    @Override
    public String toString() {
        return " " + value;
    }
}
