import java.util.Scanner;

class Vigenere {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the message: ");
        String text = sc.nextLine();

        System.out.print("Enter the key: ");
        String key = sc.nextLine();

        String output = "";
        int keyIndex = 0;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (ch >= 'A' && ch <= 'Z') {
                int shift = Character.toUpperCase(key.charAt(keyIndex % key.length())) - 'A';
                ch = (char) ((ch - 'A' + shift) % 26 + 'A');
                keyIndex++;
            } 
            else if (ch >= 'a' && ch <= 'z') {
                int shift = Character.toUpperCase(key.charAt(keyIndex % key.length())) - 'A';
                ch = (char) ((ch - 'a' + shift) % 26 + 'a');
                keyIndex++;
            }

            output += ch;
        }

        System.out.println("Encrypted message: " + output);

        sc.close();
    }
}
