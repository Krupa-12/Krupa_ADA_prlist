import java.util.*;
public class MakingChange_Dynamic {
   public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enetr a number of you wants to use : ");
        int n = sc.nextInt() ;
        int d[] = new int[n+1] ;
        for(int i = 1; i <= n ; i++){
            d[i] = sc.nextInt() ;
        }
        System.out.print("Enetr a amount you wants to makeing change : ");
        int N = sc.nextInt() ;
        int c[][] = new int[n+1][N+1] ;
        for (int i = 1 ; i <= n ; i++)
            c[i][0] = 0 ;
        for (int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= N ; j++) {
                if(i == 1 && j <  d[i]){
                    c[i][j] = 99 ;
                }
                else if(i == 1) {
                    c[i][j] = 1+c[1][j-d[1]];
                }
                else if(j < d[i]){
                    c[i][j] = c[i-1][j] ;
                }
                else{
                    c[i][j] = Math.min(c[i-1][j],1+c[i][j-d[i]]) ;
                }
            } 
        }
        for(int i = 1 ; i <= n ; i++)
        {
            for(int j = 1 ; j <= N ; j++)
            {
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }
       
        System.out.println("Minimum coins required : " + c[n][N]);
         for(int i = n ; i >= 1 ; i--){
            if(c[i][N] != c[i-1][N]){
                N = N - d[i] ;
                System.out.print(d[i] + " ");
                i++ ;
            }
        }
        sc.close();
   }
}
/*output
Enetr a number of you wants to use : 3
1
4
6
Enetr a amount you wants to makeing change : 8
1 2 3 4 5 6 7 8 
1 2 3 1 2 3 4 2 
1 2 3 1 2 1 2 2 
Minimum coins required : 2
4 4 
*/
