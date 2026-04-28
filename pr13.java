import java.util.Scanner;
public class SCS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first string (s1): ");
        String s1 = sc.nextLine();
        System.out.print("Enter second string (s2): ");
        String s2 = sc.nextLine();
        String result = findSCS(s1, s2);
        System.out.println("\nShortest Common Supersequence: " + result);
        System.out.println("Length: " + result.length());
        sc.close();
    }
    public static String findSCS(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println("\nDP Table:");
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println();
        }
        StringBuilder sb = new StringBuilder();
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                sb.append(s1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] < dp[i][j - 1]) {
                sb.append(s1.charAt(i - 1));
                i--;
            } else {
                sb.append(s2.charAt(j - 1));
                j--;
            }
        }
        while (i > 0) {
            sb.append(s1.charAt(i - 1));
            i--;
        }
        while (j > 0) {
            sb.append(s2.charAt(j - 1));
            j--;
        }
        return sb.reverse().toString();
    }
}
/*OUTPUT
Enter first string (s1): ABCBDAB
Enter second string (s2): BDCABA

DP Table:
0	1	2	3	4	5	6	
1	2	3	4	4	5	6	
2	2	3	4	5	5	6	
3	3	4	4	5	6	7	
4	4	5	5	6	6	7	
5	5	5	6	7	7	8	
6	6	6	7	7	8	8	
7	7	7	8	8	8	9	

Shortest Common Supersequence: ABCBDCABA
Length: 9*/
