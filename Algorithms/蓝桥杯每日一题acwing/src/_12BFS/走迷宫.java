package _12BFS;

import java.util.*;
import java.math.*;
import java.io.*;

public class ื฿รินฌ {
	static int INF = 0x3f3f3f3f;
	static int N = 1010 , M = 2*N;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static int[][] arr = new int[N][N],st = new int[N][N],dist = new int[N][N];
	static int n,m;

	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		for(int i=1;i<=n;i++) 
			for(int j=1;j<=m;j++)
				 arr[i][j] = sc.nextInt();
		System.out.println(bfs());
	}
	static int bfs() {
//		Arrays.fill(dist,INF);
		Queue<PII> q = new LinkedList<PII>();
		q.add(new PII(1,1));
		st[1][1]=1;
		dist[1][1]=0;
		while(q.size()>0) {
			PII top = q.poll();
			for(int i=0;i<4;i++) {
				int nx = top.x+dx[i];
				int ny = top.y+dy[i];
				if(check(nx,ny)) {
					q.add(new PII(nx,ny));
					dist[nx][ny] = dist[top.x][top.y]+1;
					st[nx][ny] = 1;
				}
			}
		}
		return dist[n][m];
	}
	static boolean check(int x,int y) {
		return x>=1 && x<=n && y>=1 && y<=m && arr[x][y]==0 && st[x][y]==0;
	}
}
class PII{
	int x,y;
	PII(int x,int y){
		this.x = x;
		this.y = y;
	
	}
}
