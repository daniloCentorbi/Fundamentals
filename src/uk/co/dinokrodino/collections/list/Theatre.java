package uk.co.dinokrodino.collections.list;

import java.util.*;

public class Theatre {
    private final String theatreName;
    private List<Seat> seats = new LinkedList<>();

    static final Comparator<Seat> PRICE_ORDER;

    static {
        PRICE_ORDER = new Comparator<Seat>() {
            @Override
            public int compare(Seat seat1, Seat seat2) {
                if (seat1.getPrice() > seat2.getPrice()) {
                    return 1;
                } else if (seat1.getPrice() < seat2.getPrice()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        };
    }

    public Theatre(String theatreName, int numRows, int seatsPerRow) {
        this.theatreName = theatreName;
        double price = 12.00;
        int lastrow = 'A' + (numRows - 1);
        for (char row = 'A'; row <= lastrow; row++) {
            for (int numSeat = 1; numSeat <= seatsPerRow; numSeat++) {
                if ((row < 'D') && (numSeat >= 4 && numSeat <= 9)) {
                    price = 14.00;
                } else if ((row > 'F') || (numSeat < 4 || numSeat > 9)) {
                    price = 7.00;
                }
                Seat seat = new Seat(row + String.format("%02d", numSeat), price);
                seats.add(seat);
            }
        }
    }

    public boolean reserveSeat(String seatNumber) {
        Seat requestedSeat = new Seat(seatNumber, 0);
        int foundSeat = Collections.binarySearch(seats, requestedSeat, null);
        if (foundSeat >= 0) {
            return seats.get(foundSeat).reserve();
        } else {
            System.out.println("Seat not found");
            return false;
        }

        //Classic Search
//        for (Seat seat : seats) {
//            System.out.print(".");
//            if (seat.getSeatNumber().equals(seatNumber)) {
//                requestedSeat = seat;
//                break;
//            }
//        }
//        if (requestedSeat == null) {
//            System.out.println("seat not found");
//            return false;
//        }
//        return requestedSeat.reserve();
    }


    public Collection<Seat> getSeats() {
        return seats;
    }


    class Seat implements Comparable<Seat> {
        private String seatNumber;
        private boolean reserved;
        private double price;

        public Seat(String seatNumber, double price) {
            this.seatNumber = seatNumber;
            this.price = price;
        }

        @Override
        public int compareTo(Seat seat) {
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }

        public String getSeatNumber() {
            return seatNumber;
        }

        public boolean reserve() {
            if (!this.reserved) {
                this.reserved = true;
                System.out.println("seat " + this.getSeatNumber() + " reserved");
            } else {
                System.out.println("seat already reserved");
                return false;
            }
            return true;
        }

        private boolean cancel() {
            if (this.reserved) {
                this.reserved = false;
                System.out.println("the reservation for seat " + this.getSeatNumber() + " is cancelled");
                return true;
            } else {
                System.out.println("the seat was not booked");
                return false;
            }
        }

        public double getPrice() {
            return price;
        }
    }
}