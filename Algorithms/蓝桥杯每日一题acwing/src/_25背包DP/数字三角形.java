package _25背包DP;
import java.util.*;
import java.math.*;
import java.io.*;

public class 数字三角形 {
		static int INF = 0x3f3f3f3f;
		static int N = 1010 , M = 2*N;
		static int[][] arr = new int[N][N];

		static int n,m;

		public static void main(String[] sss) {
			Scanner sc = new Scanner(System.in);
			n = sc.nextInt();

			for(int i=1;i<=n;i++) 
				for(int j=1;j<=i;j++)
					arr[i][j] = sc.nextInt();
			
			for(int i=n-1;i>0;i--) 
				for(int j=i;j>0;j--)
					arr[i][j] += Math.max(arr[i+1][j],arr[i+1][j+1]);
			

			System.out.println(arr[1][1]);
			
		}
}
