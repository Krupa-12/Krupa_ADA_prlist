import java.util.*;
public class prim's MST{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of vertices : ");
        int num = sc.nextInt();
        int matrix[] [] = new int[num][num];
        int vi[] = new int[num];
        for(int i = 0 ; i < num ; i++)
        {
            for(int j = 0 ; j < num ; j++)
            {
                matrix[i][j]=sc.nextInt();
            }
            vi[i] = 0;
        }
        for(int i = 0 ; i < num ; i++)
        {
            for(int j = 0 ; j < num ; j++)
            {
                System.out.print( matrix[i][j] + " ");
            }
            System.out.println();
        }
        int count = 0 ;
        vi[0] = 1 ;
        int U =0 , V =0 ;
        int min =0;
        int total =0 ;
        while(count < num-1)
        {
            min = 99;
            for(int i = 0 ; i < num ; i++)
            {
                if(vi[i] == 1)
                {
                    for(int j = 0 ; j < num ; j++)
                    {
                        //min = matrix[i][j] ;
                        if(matrix[i][j] < min)
                        {
                            min = matrix[i][j];
                            U = i ;
                            V = j ;
                        } 
                    }
                }
            }
            if(vi[U] == 0 && vi[V] == 1 || vi[U] == 1 && vi[V] ==0)
            {
                System.out.println(U + " " + V + " ->" + min);
                count++;
                total += min ;
                vi[U] = vi[V] = 1 ;
            }
            matrix[U][V] = matrix[V][U] = 99 ;
        }
        System.out.println("total = " + total);
        sc.close();
    }
}
/*output 
Enter number of vertices : 
5
enter adjacency matrix
99 4 2 99 99
4 99 1 5 99
2 1 99 8 10
99 5 8 99 2
99 99 10 2 99

99 4 2 99 99 
4 99 1 5 99 
2 1 99 8 10 
99 5 8 99 2 
99 99 10 2 99 

0 2 ->2
2 1 ->1
1 3 ->5
3 4 ->2
total = 10*/
