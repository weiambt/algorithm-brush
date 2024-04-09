package _03讲_数学与简单DP;
import java.util.*;
import java.math.*;
import java.io.*;

public class 摘花生 {
		static int INF = 0x3f3f3f3f;
		static int N = 1010 , M = 2*N;
		static int[][] arr = new int[N][N];
		static int t,n,m;

		public static void main(String[] sss) {
			Scanner sc = new Scanner(System.in);
			t = sc.nextInt();
			while(t-->0){
				n = sc.nextInt();
				m = sc.nextInt();

				for(int i=1;i<=n;i++) 
					for(int j=1;j<=m;j++)
						arr[i][j] = sc.nextInt();
				int ans = -INF;
				for(int i=1;i<=n;i++) {
					for(int j=1;j<=m;j++) {
						arr[i][j] += Math.max(arr[i-1][j], arr[i][j-1]);
						if(i==n) ans = Math.max(ans, arr[i][j]);
					}
				}
				System.out.println(ans);

			}
			
			
		}
}
