package org.example;

public class Cinema {
    // 3D масив для представлення кінотеатру
    private int[][][] seatingArrangement;

    // Конструктор для ініціалізації масиву
    public Cinema() {
        // П'ять залів, кожен з 10 рядами та 20 місцями
        seatingArrangement = new int[5][10][20];
        // Ініціалізація масиву нулями, що вказує на вільні місця
        for (int hall = 0; hall < 5; hall++) {
            for (int row = 0; row < 10; row++) {
                for (int seat = 0; seat < 20; seat++) {
                    seatingArrangement[hall][row][seat] = 0;
                }
            }
        }
    }

    // Метод для бронювання місць
    public void bookSeats(int hallNumber, int row, int[] seats) {
        for (int seat : seats) {
            if (seatingArrangement[hallNumber][row][seat] == 0) {
                seatingArrangement[hallNumber][row][seat] = 1;
                System.out.println("Місце " + seat + " в ряду " + row + " в залі " + hallNumber + " було успішно заброньоване.");
            } else {
                System.out.println("Місце " + seat + " в ряду " + row + " в залі " + hallNumber + " вже заброньоване.");
            }
        }
    }

    // Метод для скасування бронювання місць
    public void cancelBooking(int hallNumber, int row, int[] seats) {
        for (int seat : seats) {
            if (seatingArrangement[hallNumber][row][seat] == 1) {
                seatingArrangement[hallNumber][row][seat] = 0;
                System.out.println("Бронювання для місця " + seat + " в ряду " + row + " в залі " + hallNumber + " скасоване.");
            } else {
                System.out.println("Місце " + seat + " в ряду " + row + " в залі " + hallNumber + " не було заброньоване.");
            }
        }
    }

    // Метод для перевірки наявності заданої кількості послідовних місць
    public boolean checkAvailability(int hallNumber, int numSeats) {
        for (int row = 0; row < 10; row++) {
            for (int seat = 0; seat <= 20 - numSeats; seat++) {
                boolean available = true;
                for (int i = 0; i < numSeats; i++) {
                    if (seatingArrangement[hallNumber][row][seat + i] == 1) {
                        available = false;
                        break;
                    }
                }
                if (available) {
                    System.out.println("Доступно " + numSeats + " послідовних місць у ряду " + row + " в залі " + hallNumber + ".");
                    return true;
                }
            }
        }
        System.out.println("Не вдалося знайти " + numSeats + " послідовних вільних місць в залі " + hallNumber + ".");
        return false;
    }

    // Метод для друку схеми розміщення місць
    public void printSeatingArrangement(int hallNumber) {
        System.out.println("Схема розміщення місць для залу " + hallNumber + ":");
        for (int row = 0; row < 10; row++) {
            for (int seat = 0; seat < 20; seat++) {
                if (seatingArrangement[hallNumber][row][seat] == 0) {
                    System.out.print("O "); // O - вільне місце
                } else {
                    System.out.print("X "); // X - заброньоване місце
                }
            }
            System.out.println(); // Перехід до наступного ряду
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Cinema cinema = new Cinema();

        // Приклад використання
        cinema.bookSeats(2, 3, new int[]{5, 6, 7});
        cinema.bookSeats(2, 3, new int[]{6, 7});
        cinema.printSeatingArrangement(2);

        cinema.cancelBooking(2, 3, new int[]{6, 7});
        cinema.printSeatingArrangement(2);

        cinema.checkAvailability(1, 3);
        cinema.checkAvailability(1, 5);
    }
}