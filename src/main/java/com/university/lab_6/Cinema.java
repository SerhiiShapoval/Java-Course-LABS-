package com.university.lab_6;

import java.util.Arrays;

public class Cinema {
    private int[][][] seatingArrangement;

    public Cinema(int halls, int rows, int seatsPerRow) {
        this.seatingArrangement = new int[halls][rows][seatsPerRow];
    }

    public void initializeSeats() {
        for (int[][] hall : seatingArrangement) {
            for (int[] row : hall) {
                Arrays.fill(row, 0);
            }
        }
    }

    public boolean bookSeats(int hallNumber, int row, int[] seats) {
        boolean result = true;

        for (int seat : seats) {
            if (seatingArrangement[hallNumber][row][seat] == 1) {
                System.out.println("Місце " + seat + " в ряду " + row + " в залі " + hallNumber + " вже заброньоване.");
                result = false;
            } else {
                seatingArrangement[hallNumber][row][seat] = 1;
                System.out.println("Місце " + seat + " в ряду " + row + " в залі " + hallNumber + " успішно заброньоване.");
            }
        }

        return result;
    }

    public boolean cancelBooking(int hallNumber, int row, int[] seats) {
        boolean result = true;

        for (int seat : seats) {
            if (seatingArrangement[hallNumber][row][seat] == 0) {
                System.out.println("Місце " + seat + " в ряду " + row + " в залі " + hallNumber + " не було заброньоване.");
                result =  false;
            } else {
                seatingArrangement[hallNumber][row][seat] = 0;
                System.out.println("Бронювання для місця " + seat + " в ряду " + row + " в залі " + hallNumber + " скасоване.");
            }
        }

        return result;
    }

    public boolean checkAvailability(int hallNumber, int numSeats) {
        for (int[] row : seatingArrangement[hallNumber]) {
            int consecutiveSeats = 0;
            for (int seat : row) {
                if (seat == 0) {
                    consecutiveSeats++;
                    if (consecutiveSeats == numSeats) {
                        return true;
                    }
                } else {
                    consecutiveSeats = 0;
                }
            }
        }
        return false;
    }

    public void printSeatingArrangement(int hallNumber) {
        System.out.println("Схема розміщення місць для залу " + hallNumber + ":");
        for (int i = 0; i < seatingArrangement[hallNumber].length; i++) {
            for (int j = 0; j < seatingArrangement[hallNumber][i].length; j++) {
                System.out.print(seatingArrangement[hallNumber][i][j] + " ");
            }
            System.out.println();
        }
    }

    public int[][][] getSeatingArrangement() {
        return this.seatingArrangement;
    }
}