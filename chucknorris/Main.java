package chucknorris;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input string:");
        String input = scanner.nextLine();
        char[] letters = new char[input.length()];
        for (int i = 0; i < input.length(); i++) {
            letters[i] = input.charAt(i);
            System.out.print(letters[i] + " ");
        }

    }
}