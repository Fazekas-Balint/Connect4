package connectfour.player;

import java.util.Scanner;

public class PlayerName {

    private static String name;


    public  PlayerName() {
        name = askForName();
    }

    // Játékos nevének bekérése
    private String askForName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your name:");
        return scanner.nextLine().trim(); // Nevet bekérjük és visszaadjuk
    }

    public static void setName(final String name) {
        PlayerName.name = name;
    }

    public static String getName() {
        return name;
    }

    public static void printName() {
        System.out.println("Player's name: " + name);
    }
}
