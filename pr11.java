import java.util.Scanner;
public class p11{
    static int[][] m;
    static int[][] s;
    public static void MCM(int p[], int n) {
        m = new int[n][n];
        s = new int[n][n];
        for (int i = 1; i < n; i++) {
            m[i][i] = 0;
        }
        for (int l = 2; l < n; l++) { // chain length
            for (int i = 1; i < n - l + 1; i++) {
                int j = i + l - 1;
                m[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j - 1; k++) {
                    int q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (q < m[i][j]) {
                        m[i][j] = q;
                        s[i][j] = k;
                    }
                }
            }
        }
    }
    public static void printOptimal(int i, int j) {
        if (i == j) {
            System.out.print("A" + i);
        } else {
            System.out.print("(");
            printOptimal(i, s[i][j]);
            printOptimal(s[i][j] + 1, j);
            System.out.print(")");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no. of matrices: ");
        int n = sc.nextInt();
        int p[] = new int[n + 1];
        System.out.println("Enter dimensions:");
        for (int i = 0; i <= n; i++) {
            p[i] = sc.nextInt();
        }
        MCM(p, n + 1);
        System.out.println("Minimum no. of multiplications: " + m[1][n]);
        System.out.print("Optimal Parenthesization: ");
        printOptimal(1, n);

        System.out.println("\nmultiplication Matrix:");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(m[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("\nsequence of multiplication Matrix:");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(s[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
/* output 
Enter no. of matrices: 4
Enter dimensions:
5 
4
6
2
7
Minimum no. of multiplications: 158
Optimal Parenthesization: ((A1(A2A3))A4)
multiplication Matrix:
0	120	88	158	
0	0	48	104	
0	0	0	84	
0	0	0	0	

sequence of multiplication Matrix:
0	1	1	3	
0	0	2	3	
0	0	0	3	
0	0	0	0
*/
