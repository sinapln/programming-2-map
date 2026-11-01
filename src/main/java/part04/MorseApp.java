package part04;

import java.util.Scanner;

/**
 * This is an extra class, which is not included in the grading of the
 * assignment. Feel free to complete this class or skip it entirely.
 *
 * See the MorseCode class for more information.
 */
public class MorseApp {

    public static void main(String... args) {
        MorseCode morseCode = new MorseCode();

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Morse Code Translator ===");
        System.out.println("1. Text to Morse code");
        System.out.println("2. Morse code to text");
        System.out.print("Choose an option: ");

        String choice = scanner.nextLine();

        if (choice.equals("1")) {
            System.out.print("Enter text: ");
            String text = scanner.nextLine();

            System.out.println("Morse code: " + morseCode.textToMorse(text));

        } else if (choice.equals("2")) {
            System.out.print("Enter Morse code: ");
            String morse = scanner.nextLine();

            System.out.println("Text: " + morseCode.morseToText(morse));

        } else {
            System.out.println("Invalid option.");
        }

        scanner.close();
    }
}