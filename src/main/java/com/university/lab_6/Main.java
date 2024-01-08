package com.university.lab_6;

public class Main {
    public static void main(String[] args) {
        Cinema cinema = new Cinema(5, 10, 20);
        cinema.initializeSeats();

        cinema.bookSeats(1, 3, new int[]{4, 5, 6});
        cinema.bookSeats(1, 3, new int[]{5, 6});

        cinema.printSeatingArrangement(1);

        cinema.cancelBooking(1, 3, new int[]{5, 6});

        cinema.printSeatingArrangement(1);

        boolean availability = cinema.checkAvailability(1, 3);
        System.out.println("Доступність 3 послідовних місць в залі 1: " + availability);
    }
}