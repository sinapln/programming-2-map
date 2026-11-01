package part04;

import java.util.HashMap;
import java.util.Map;

/**
 * This is an extra class, which is not included in the grading of the
 * assignment. Feel free to complete this class or skip it entirely. If you
 * decide to complete it, you can use the MorseCodeTest class to test your
 * implementation. You can also create complete the MorseApp class, which uses
 * this class to translate between morse code and text.
 *
 * Based on Wikipedia, "Morse code is a method used in telecommunication to
 * encode text characters as standardized sequences of two different signal
 * durations, called dots and dashes, or dits and dahs"
 * (https://en.wikipedia.org/wiki/Morse_code).
 *
 * In this class, the morse code is represented as a string of dots (.) and
 * dashes (-). Characters are separated by a single space and words are
 * separated by three spaces.
 *
 * Your task is to implement the methods morseToText and textToMorse, which
 * translate between "normal" text and morse code. In the textToMorse method,
 * the input text can contain any characters, including special characters. You
 * only need to implement translation for the upper and lower case letters a-z
 * and the numbers 0-9.
 *
 * The mapping between characters and morse code can be found online, and is not
 * included in this assignment. You can use a Map to store the morse codes and
 * their corresponding characters.
 */
public class MorseCode {

    /**
     * Translates a string of morse code to text. The morse code is represented as
     * dots (.) and dashes (-). Characters are separated by a single space and words
     * are separated by three spaces. Characters a-z and 0-9 are supported.
     *
     * For example, ".... . .-.. .-.. --- .-- --- .-. .-.. -.." translates to
     * "hello world".
     *
     * @param morse the morse code to translate
     * @return the translated text (in lower case)
     */
    public String morseToText(String morse) {
        Map<String, Character> codes = createMorseMap();

        StringBuilder result = new StringBuilder();

        String[] words = morse.trim().split(" {3}");

        for (String word : words) {
            String[] letters = word.split(" ");

            for (String letter : letters) {
                if (codes.containsKey(letter)) {
                    result.append(codes.get(letter));
                }
            }

            result.append(" ");
        }

        if (result.length() > 0) {
            result.setLength(result.length() - 1);
        }

        return result.toString();
    }

    /**
     * Translates a string of text to morse code. The morse code is represented as
     * dots (.) and dashes (-). Characters are separated by a single space and words
     * are separated by three spaces.
     *
     * Upper and lower case letters a-z and numbers 0-9 are supported. Other
     * characters are ignored.
     *
     * For example, "Hello World" translates to
     * ".... . .-.. .-.. --- .-- --- .-. .-.. -..".
     *
     * @param text the text to translate
     * @return the translated morse code as a single string
     */
    public String textToMorse(String text) {
        Map<Character, String> codes = createTextMap();

        StringBuilder result = new StringBuilder();

        String[] words = text.toLowerCase().split(" ");

        for (int i = 0; i < words.length; i++) {
            StringBuilder morseWord = new StringBuilder();

            for (int j = 0; j < words[i].length(); j++) {
                char letter = words[i].charAt(j);

                if (codes.containsKey(letter)) {
                    if (morseWord.length() > 0) {
                        morseWord.append(" ");
                    }

                    morseWord.append(codes.get(letter));
                }
            }

            if (morseWord.length() > 0) {
                if (result.length() > 0) {
                    result.append("   ");
                }

                result.append(morseWord);
            }
        }

        return result.toString();
    }

    private Map<Character, String> createTextMap() {
        Map<Character, String> map = new HashMap<>();

        map.put('a', ".-");
        map.put('b', "-...");
        map.put('c', "-.-.");
        map.put('d', "-..");
        map.put('e', ".");
        map.put('f', "..-.");
        map.put('g', "--.");
        map.put('h', "....");
        map.put('i', "..");
        map.put('j', ".---");
        map.put('k', "-.-");
        map.put('l', ".-..");
        map.put('m', "--");
        map.put('n', "-.");
        map.put('o', "---");
        map.put('p', ".--.");
        map.put('q', "--.-");
        map.put('r', ".-.");
        map.put('s', "...");
        map.put('t', "-");
        map.put('u', "..-");
        map.put('v', "...-");
        map.put('w', ".--");
        map.put('x', "-..-");
        map.put('y', "-.--");
        map.put('z', "--..");

        map.put('0', "-----");
        map.put('1', ".----");
        map.put('2', "..---");
        map.put('3', "...--");
        map.put('4', "....-");
        map.put('5', ".....");
        map.put('6', "-....");
        map.put('7', "--...");
        map.put('8', "---..");
        map.put('9', "----.");

        return map;
    }

    private Map<String, Character> createMorseMap() {
        Map<String, Character> map = new HashMap<>();

        for (Map.Entry<Character, String> entry : createTextMap().entrySet()) {
            map.put(entry.getValue(), entry.getKey());
        }

        return map;
    }
}
