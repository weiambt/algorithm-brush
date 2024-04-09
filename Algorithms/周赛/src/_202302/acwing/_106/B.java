package _202302.acwing._106;


import java.util.*;
import java.io.*;
import java.math.*;
public class B {
	static int INF = 0x3f3f3f3f;
	static int N = 100,M = 2*N;
	static int[][] g = new int[N][N];
	static int n,b;
	
	public static void main(String[] args) {
		Scanner sc =  new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		n = sc.nextInt();
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++)
				g[i][j] = sc.nextInt();
		}

		for(int k=1;k<=n;k++)
			for(int i=1;i<=n;i++)
				for(int j=1;j<=n;j++) {
					g[i][j] = Math.min(g[i][j],g[i][k]+g[k][j]);
				}
		int ans = 0;
		for(int i=1;i<=n;i++) 
			for(int j=1;j<=n;j++)
				ans = Math.max(ans,g[i][j]);
		System.out.println(ans);
	}
}


