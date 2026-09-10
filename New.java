import java.util.*;

class New {

    static int[][] key = {
        {3, 25},
        {24, 17}
    };

   
    static int inverse(int n) {

        for (int i = 1; i < 26; i++) {
            if ((n * i) % 26 == 1) {
                return i;
            }
        }

        return -1;
    }

   
    static int[][] inverseMatrix() {

        int det = key[0][0] * key[1][1]
                - key[0][1] * key[1][0];

        det = (det % 26 + 26) % 26;

        int invDet = inverse(det);

        int[][] inv = new int[2][2];

        inv[0][0] = key[1][1] * invDet % 26;
        inv[0][1] = -key[0][1] * invDet % 26;
        inv[1][0] = -key[1][0] * invDet % 26;
        inv[1][1] = key[0][0] * invDet % 26;

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                inv[i][j] = (inv[i][j] + 26) % 26;
            }
        }

        return inv;
    }

    
    static String process(String text, int[][] matrix) {

        String result = "";

        for (int i = 0; i < text.length(); i += 2) {

            int x = text.charAt(i) - 'A';
            int y = text.charAt(i + 1) - 'A';

            int a = (matrix[0][0] * x
                    + matrix[0][1] * y) % 26;

            int b = (matrix[1][0] * x
                    + matrix[1][1] * y) % 26;

            result += (char) (a + 'A');
            result += (char) (b + 'A');
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Plain Text: ");
        String text = sc.nextLine();

        text = text.toUpperCase().replaceAll("[^A-Z]", "");

        // Add Z if length is odd
        if (text.length() % 2 != 0) {
            text += "Z";
        }

        String encrypted = process(text, key);

        int[][] invKey = inverseMatrix();

        String decrypted = process(encrypted, invKey);

        System.out.println("\nPlain Text : " + text);
        System.out.println("Encrypted  : " + encrypted);
        System.out.println("Decrypted  : " + decrypted);

        sc.close();
    }
}
