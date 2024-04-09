package ����;
import java.util.*;
import java.math.*;
import java.io.*;
public class _02�Ǳ����� {
	static int INF = 0x3f3f3f3f;
	static int N = 1010 , M = 2*N;
	static int[][] arr = new int[N][N];
	static int[][] st = new int[N][N];
	static int n,m;
	static long ans,area;
	
	static int bfs(int x,int y) {
		Queue<PII> q = new LinkedList<PII>();
		q.add(new PII(x,y));
		st[x][y] = 1;
		int cnt = 1;
		int[] dx = {0,-1,0,1}; 
		int[] dy = {-1,0,1,0};
		while(q.size()>0) {
			PII top = q.poll();
			for(int i=0;i<4;i++) {
				int nx = top.x+dx[i];
				int ny = top.y+dy[i];
				if(nx>=0 &&nx<n && ny>=0 &&ny<m &&st[nx][ny]==0 && ((arr[top.x][top.y]>>i)&1)==0) {
					q.add(new PII(nx,ny));
					st[nx][ny] = 1;
					cnt++;
				}
			}

		}
		return cnt;
				
	}

	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++)
				arr[i][j] = sc.nextInt();
		}
		
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++) {
				if(st[i][j]==0) {
					area = Math.max(area,bfs(i,j));
					ans++;
				}
			}
		System.out.println(ans);
		System.out.println(area);
	}

}
//class PII{
//	int x,y;
//	public PII(int x,int y) {
//		// TODO Auto-generated constructor stub
//		this.x = x;
//		this.y = y;
//	}
//}
