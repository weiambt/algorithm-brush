package _2023ецЬт;

import java.util.*;
import java.io.*;
public class C {
	static int Mod = 998244353 ;
	static int N = 3001;
	static int[][] sum = new int[N][N],chafen = new int[N][N];

	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		int n = sc.nextInt();
		int m = sc.nextInt();
		while(m-->0) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			chafen[x1][y1] ++;
			chafen[x1][y2+1]--;
			chafen[x2+1][y1]--;
			chafen[x2+1][y2+1]++;
			
		}
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + chafen[i][j];
				out.print(sum[i][j]%2);
			}
			out.println();
		}
		out.flush();
		
	}
	
}
