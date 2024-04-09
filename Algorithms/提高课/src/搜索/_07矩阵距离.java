package ËÑË÷;

import java.util.*;
import java.math.*;
import java.io.*;
public class _07¾ØÕó¾àÀë {
	static int INF = 0x3f3f3f3f;
	static int N = 1010 , M = 2*N;
	static char[][] g = new char[N][N];
	static int[][] cen = new int[N][N];
	static int n,m;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static Queue<PII> q = new LinkedList<PII>();

	static void bfs() {

		while(q.size()>0) {
			PII top = q.poll();
			int x = top.x;
			int y = top.y;
			for(int i=0;i<4;i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(nx>=0 && nx<n && ny>=0 &&ny<m && cen[nx][ny]==INF) {
					cen[nx][ny] = cen[x][y] + 1;
					q.add(new PII(nx,ny));
				}
			}
		}
	}


	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<N;i++)
			Arrays.fill(cen[i],INF);

		n = sc.nextInt();
		m = sc.nextInt();
		for(int i=0;i<n;i++) {
			g[i] = sc.next().toCharArray();
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(g[i][j]=='1') {
					q.add(new PII(i,j));
					cen[i][j] = 0;
				}
			}
		}
		bfs();
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) 
				System.out.print(cen[i][j]+" ");
			System.out.println();
		}
	}
}
//class PII{
//int x,y;
//public PII(int x,int y) {
//	// TODO Auto-generated constructor stub
//	this.x = x;
//	this.y = y;
//}
//}