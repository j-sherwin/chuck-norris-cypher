package chucknorris;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input string:");
        String input = scanner.nextLine();
        String lettersInBinary = "";
        char[] letters = new char[input.length()];

        System.out.println("The result:");

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
    }
}