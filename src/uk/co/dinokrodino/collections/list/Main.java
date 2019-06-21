package uk.co.dinokrodino.collections.list;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Theatre odeon = new Theatre("Odeon", 10, 10);
        //odeon.reserveSeat("A01");
        odeon.reserveSeat("B10");
        odeon.reserveSeat("B10");
        printList(odeon.getSeats());

        List<Theatre.Seat> orderedByComparator = new LinkedList<>(odeon.getSeats());
        Theatre.Seat b = odeon.new Seat("Z01", 6.00);
        orderedByComparator.add(odeon.new Seat("Z00", 5.00));
        orderedByComparator.add(b);
        Collections.sort(orderedByComparator, odeon.PRICE_ORDER);
        orderedByComparator.get(2).reserve();
        printList(orderedByComparator);

        odeon.reserveSeat("A01");


        printList(odeon.getSeats());
    }

    public static void printList(Collection<Theatre.Seat> seats) {
        for (Theatre.Seat seat : seats) {
            System.out.print(seat.getSeatNumber() + " $:" + seat.getPrice());
        }
        System.out.println("============================================");
    }
}
