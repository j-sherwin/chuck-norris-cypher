package chucknorris;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

class ChuckException extends Exception {
}
public class Main {

    public static void chuckDecodeInput() throws ChuckException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input encoded string:");
        String input = scanner.nextLine();
        checkChar(input);
        checkOddBlocks(input);
        checkBlockSequence(input);
        checkBinaryString(input);
        decoder(input);
    }

    public static void checkChar(String input) throws ChuckException {
        input = input.replaceAll("\\s", "");
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != '0') {
                throw new ChuckException();
            }
        }
    }

    public static void checkOddBlocks(String input) throws ChuckException {
        String[] words = input.split("\\s+");
        if (words.length % 2 != 0) {
            throw new ChuckException();
        }
    }

    public static void checkBinaryString(String input) throws ChuckException {
        int counter = 0;
        String[] words = input.split("\\s+");
        for (int i = 1; i < words.length; i++) {
            counter += words[i].length();
            i++;
        }
        if (counter % 7 != 0) {
            throw new ChuckException();
        }

    }
    public static void checkBlockSequence(String input) throws ChuckException {
        String[] words = input.split("\\s+");
        for (int i = 0; i < words.length; i++) {
            if (Objects.equals(words[i], "0") || Objects.equals(words[i], "00")) {
                i++;
            } else {
                throw new ChuckException();
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Please input operation (encode/decode/exit):");
            String input = scanner.nextLine();
            switch (input) {
                case "encode":
                    encoder();
                    break;
                case "decode":
                    try {
                        chuckDecodeInput();
                    } catch (Exception e) {
                        System.out.println("Encoded string is not valid.\n");
                    }
                    break;
                case "exit":
                    System.out.println("Bye!");
                    return;
                default:
                    System.out.println("There is no '" + input + "' operation");
                    System.out.println();
                    break;
            }
        }
    }

    public static void encoder() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input string:");
        String input = scanner.nextLine();
        String lettersInBinary = "";
        char[] letters = new char[input.length()];

        System.out.println("Encoded string:");

        for (int i = 0; i < input.length(); i++) {
            letters[i] = input.charAt(i);
            String s = Integer.toBinaryString(letters[i]);
            int num = Integer.parseInt(s);
            lettersInBinary = lettersInBinary.concat(String.format("%07d", num));
        }

        for (int j = 0; j <lettersInBinary.length(); j++) {
            int count = 1;
            while (j + 1 < lettersInBinary.length() && lettersInBinary.charAt(j) == lettersInBinary.charAt(j + 1)) {
                j++;
                count++;
            }
            if (lettersInBinary.charAt(j) == '1') {
                System.out.print("0 " + "0".repeat(count) + " ");
            } else {
                System.out.print("00 " + "0".repeat(count) + " ");
            }
        }
        System.out.println();
        System.out.println();
    }
    public static void decoder(String input) {
            String[] encoded = input.split(" ");
            String output = "";
            for (int i = 1; i < encoded.length; i++) {
                int num = encoded[i].length();
                if (Objects.equals(encoded[i - 1], "0")) {
                    output = output.concat("1".repeat(num));
                }
                if (Objects.equals(encoded[i - 1], "00")) {
                    output = output.concat("0".repeat(num));
                }
                i++;
            }
            String[] decoded = output.split("(?<=\\G.{7})");
            System.out.println("Decoded string:");
            for (int i = 0; i < decoded.length; i++) {
                int a = Integer.parseInt(decoded[i], 2);
                char c = (char) a;
                System.out.print(c);
            }
            System.out.println();
            System.out.println();
    }
}