import java.util.Scanner;

public class LCSWithTable {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string X: ");
        String X = sc.next();
        System.out.print("Enter string Y: ");
        String Y = sc.next();

        int m = X.length();
        int n = Y.length();

        int[][] c = new int[m + 1][n + 1];
        String[][] b = new String[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                    b[i][j] = "D"; // Diagonal match
                } else if (c[i - 1][j] >= c[i][j - 1]) {
                    c[i][j] = c[i - 1][j];
                    b[i][j] = "U"; // From above
                } else {
                    c[i][j] = c[i][j - 1];
                    b[i][j] = "L"; // From left
                }
            }
        }
        System.out.println("\n--- LCS Length Table (c) ---");
        printIntTable(c, X, Y);

        System.out.println("\n--- LCS Direction Table (b) ---");
        printStringTable(b, X, Y);

        System.out.print("\nFinal LCS: ");
        printLCS(b, X, m, n);
        System.out.println("\nLCS Length: " + c[m][n]);
    }

    // Helper to print the Length Table
    public static void printIntTable(int[][] table, String X, String Y) {
        System.out.print("      ");
        for (int j = 0; j < Y.length(); j++) System.out.print(Y.charAt(j) + "  ");
        System.out.println();
        for (int i = 0; i < table.length; i++) {
            if (i > 0) System.out.print(X.charAt(i - 1) + "  ");
            else System.out.print("   ");
            for (int j = 0; j < table[i].length; j++) {
                System.out.printf("%2d ", table[i][j]);
            }
            System.out.println();
        }
    }
    public static void printStringTable(String[][] table, String X, String Y) {
        for (int i = 1; i < table.length; i++) {
            System.out.print(X.charAt(i - 1) + "  ");
            for (int j = 1; j < table[i].length; j++) {
                System.out.print(table[i][j] + "  ");
            }
            System.out.println();
        }
    }
    public static void printLCS(String[][] b, String X, int i, int j) {
        if (i == 0 || j == 0) return;
        if ("D".equals(b[i][j])) {
            printLCS(b, X, i - 1, j - 1);
            System.out.print(X.charAt(i - 1));
        } else if ("U".equals(b[i][j])) {
            printLCS(b, X, i - 1, j);
        } else {
            printLCS(b, X, i, j - 1);
        }
    }
}
/*output
Enter string X: ABCBDAB
Enter string Y: BDCABA

--- LCS Length Table (c) ---
      B  D  C  A  B  A  
    0  0  0  0  0  0  0 
A   0  0  0  0  1  1  1 
B   0  1  1  1  1  2  2 
C   0  1  1  2  2  2  2 
B   0  1  1  2  2  3  3 
D   0  1  2  2  2  3  3 
A   0  1  2  2  3  3  4 
B   0  1  2  2  3  4  4 

--- LCS Direction Table (b) ---
A  U  U  U  D  L  D  
B  D  L  L  U  D  L  
C  U  U  D  L  U  U  
B  D  U  U  U  D  L  
D  U  D  U  U  U  U  
A  U  U  U  D  U  D  
B  D  U  U  U  D  U  

Final LCS: BCBA
LCS Length: 4*/
