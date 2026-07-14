import java.util.Scanner;

public class CaesarCipher {

    public static String encrypt(String text, int shift) {
        StringBuilder encrypted = new StringBuilder();

        for (char ch : text.toCharArray()) {

            if (Character.isUpperCase(ch)) {
                char c = (char) ((ch - 'A' + shift) % 26 + 'A');
                encrypted.append(c);
            }
            else if (Character.isLowerCase(ch)) {
                char c = (char) ((ch - 'a' + shift) % 26 + 'a');
                encrypted.append(c);
            }
            else {
                encrypted.append(ch);
            }
        }

        return encrypted.toString();
    }

    public static String decrypt(String text, int shift) {
        StringBuilder decrypted = new StringBuilder();

        for (char ch : text.toCharArray()) {

            if (Character.isUpperCase(ch)) {
                char c = (char) ((ch - 'A' - shift + 26) % 26 + 'A');
                decrypted.append(c);
            }
            else if (Character.isLowerCase(ch)) {
                char c = (char) ((ch - 'a' - shift + 26) % 26 + 'a');
                decrypted.append(c);
            }
            else {
                decrypted.append(ch);
            }
        }

        return decrypted.toString();
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("=== Caesar Cipher Encryption & Decryption ===");

        System.out.print("Enter your message: ");
        String message = input.nextLine();

        System.out.print("Enter shift value: ");
        int shift = input.nextInt();

        String encrypted = encrypt(message, shift);
        String decrypted = decrypt(encrypted, shift);

        System.out.println("\nEncrypted Text : " + encrypted);
        System.out.println("Decrypted Text : " + decrypted);

        input.close();
    }
}