package ËÑË÷;
import java.util.*;
import java.math.*;
import java.io.*;
public class _01³ØÌÁ¼ÆÊı_DFS {
	static int INF = 0x3f3f3f3f;
	static int N = 1010 , M = 2*N;
	static char[][] arr = new char[N][N];
	static int[][] st = new int[N][N];
	static int n,m;
	static long ans = 0;
	
	static void dfs(int x,int y) {
		st[x][y] = 1;
		for(int i=x-1;i<=x+1;i++){
			for(int j=y-1;j<=y+1;j++) {
				if(i==x && j==y) continue;
				if(i>=0 && i<n && j>=0 && j<m && arr[i][j]=='W' && st[i][j]==0)
					dfs(i,j);
			}
		}
	}

	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		for(int i=0;i<n;i++) {
			arr[i] = sc.next().toCharArray();
		}
		
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++) {
				if(arr[i][j]=='W' && st[i][j]==0) {
					dfs(i,j);
					ans++;
				}
			}
		}
		System.out.println(ans);
	}
}