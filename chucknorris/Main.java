package chucknorris;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input string:");
        String input = scanner.nextLine();
        char[] letters = new char[input.length()];
        System.out.println("The result:");
        for (int i = 0; i < input.length(); i++) {
            letters[i] = input.charAt(i);
            String lettersInBinary = Integer.toBinaryString(letters[i]);
            int num = Integer.parseInt(lettersInBinary);
            String binary = String.format("%07d", num);
            System.out.println(letters[i] + " = " + binary);
        }

    }
}