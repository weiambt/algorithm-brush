package 搜索;
import java.util.*;
import java.math.*;
import java.io.*;
public class _03山峰和山谷2 {
	static int INF = 0x3f3f3f3f;
	static int N = 1010 , M = 2*N;
	static int[][] arr = new int[N][N];
	static int[][] st = new int[N][N];
	static int n;
	static long top,bottom;
	static int hasHigher = 0,hasLower = 0;
	
	static void bfs(int sx,int sy) {
		Queue<PII> q = new LinkedList<PII>();
		q.add(new PII(sx,sy));
		st[sx][sy] = 1;
		hasHigher = 0;hasLower=0;

		while(q.size()>0) {
			PII top = q.poll();
			int x = top.x;
			int y = top.y;
			for(int i=x-1;i<=x+1;i++) {
				for(int j=y-1;j<=y+1;j++) {
					if(i==x && j==y) continue;
					if(!(i>=0 &&i<n && j>=0 &&j<n)) continue;
					//统计下一层不相等的区域
					if(arr[i][j]!=arr[x][y]) {
						if(arr[i][j]>arr[x][y]) hasHigher = 1;
						else hasLower = 1;
						continue;
					}
					if(st[i][j]==1) continue;
//					System.out.println(i+" "+j+" "+arr[i][j]);
					q.add(new PII(i,j));
					st[i][j] = 1;
					
				}
			}
			
		}
				
	}

	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++)
				arr[i][j] = sc.nextInt();
		}
		
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++) {
				if(st[i][j]==0) {
					bfs(i,j);
					if(hasHigher==0) top++;
					if(hasLower==0) bottom++;
				}
			}
		System.out.println(top+" "+bottom);

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
