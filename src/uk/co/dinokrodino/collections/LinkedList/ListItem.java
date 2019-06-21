package uk.co.dinokrodino.collections.LinkedList;

public abstract class ListItem {
    protected ListItem nextItem;
    protected ListItem previousItem;
    protected Object value;

    public ListItem(Object value) {
        this.value = value;
    }

    abstract ListItem movePrevious();

    abstract ListItem moveNext();

    abstract ListItem setPrevious(ListItem item);

    abstract ListItem setNext(ListItem item);

    abstract int compareTo(ListItem item);

    public Object getValue() {
        return value;
    }
}
