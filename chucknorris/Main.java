package chucknorris;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input string:");
        String input = scanner.nextLine();
        char[] letters = new char[input.length()];
        System.out.println("The result:");
        String lettersInBinary = "";
        for (int i = 0; i < input.length(); i++) {
            letters[i] = input.charAt(i);
            String binaryLetters = Integer.toBinaryString(letters[i]);
            int num = Integer.parseInt(binaryLetters);
            lettersInBinary = lettersInBinary.concat(String.format("%07d", num));
        }
        for (int j = 0; j <lettersInBinary.length(); j++) {
            int count = 1;
            while (j + 1 < lettersInBinary.length() && lettersInBinary.charAt(j) == lettersInBinary.charAt(j +1)) {
                j++;
                count++;
            }
            if (lettersInBinary.charAt(j) == '1') {
                System.out.print("0 ");
                System.out.print("0".repeat(count));
                System.out.print(" ");
            }
            if (lettersInBinary.charAt(j) == '0') {
                System.out.print("00 ");
                System.out.print("0".repeat(count));
                System.out.print(" ");
            }
        }
    }
}