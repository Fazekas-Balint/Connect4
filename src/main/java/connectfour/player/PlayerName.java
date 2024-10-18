package connectfour.player;

import java.util.Scanner;

public class PlayerName {
    /**
     * Változó a névre.
     */
    private static String name;

    /**
     * Konstruktor, ami bekéri a játékos nevét.
     */
    public  PlayerName() {
        name = askForName();
    }

    // Játékos nevének bekérése
    private String askForName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your name:");
        return scanner.nextLine().trim(); // Nevet bekérjük és visszaadjuk
    }

    /**
     * Játékos nevének lekérdezése.
     * @return visszaadja a nevet
     */
    public static String getName() {
        return name;
    }

    /**
     * Játékos nevének kiírása.
     */
    public void printName() {
        System.out.println("Player's name: " + name);
    }
}
