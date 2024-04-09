package _17floyd;

import java.util.*;
import java.math.*;
import java.io.*;

public class FloydÇó×î¶ÌÂ· {
	static int INF = 0x3f3f3f3f;
	static int N = 1010;
	static int[][] f = new int[N][N];
	static int n,m,k;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();
		for(int i=0;i<N;i++) {
			Arrays.fill(f[i], INF);
			f[i][i] = 0;
		}

		for(int i=1;i<=m;i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int z = sc.nextInt();
			f[x][y] = z;
		}
		for(int k=1;k<=n;k++)
			for(int i=1;i<=n;i++)
				for(int j=1;j<=n;j++)
					f[i][j] = Math.min(f[i][j], f[i][k]+f[k][j]);
		while(k-->0) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			System.out.println(f[x][y]==INF?"impossible":f[x][y]);
		}
		
	}

	
}
