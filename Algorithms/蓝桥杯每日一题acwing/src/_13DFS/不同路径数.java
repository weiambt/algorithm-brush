package _13DFS;

import java.util.*;
import java.math.*;
import java.io.*;

public class ��ͬ·���� {
	static int INF = 0x3f3f3f3f;
	static int N = 1010 , M = 2*N;
	static int n,m,k;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};


	static int[][] g = new int[N][N];
	static HashSet<String> se = new HashSet<String>();
	static void dfs(int x,int y,int len,String ans) {
		if(len == k) {
			se.add(ans);
			return;
		}
		for(int i=0;i<4;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(check(nx,ny)) {
				dfs(nx, ny,len+1,ans+g[nx][ny]);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++)
				g[i][j] = sc.nextInt();
		
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++)
				dfs(i,j,0,g[i][j]+"");
		System.out.println(se.size());
	}
	static boolean check(int x,int y) {
		return x>=0 && x<n && y>=0 && y<m;
	}
	
}
