package uk.co.dinokrodino.collections.LinkedList;

public class Main {

    public static LinkedList myList;

    public static void main(String[] args) {

        myList = new LinkedList();
        String concatList = "ddd,ccc,ppp,aaa,eee,mmm,zzz,sss";
        for(Object value : concatList.split(",")) {
            Item item = new Item(value);
            myList.addItem(item);
        }
        ListItem root = myList.getRoot();
        System.out.println("Head of the list: " + root);
        myList.traverseList(root);
    }


}
