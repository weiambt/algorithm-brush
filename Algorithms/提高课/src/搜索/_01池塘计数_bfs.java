package 搜索;
import java.util.*;
import java.math.*;
import java.io.*;
public class _01池塘计数_bfs {
	static int INF = 0x3f3f3f3f;
	static int N = 1010 , M = 2*N;
	static char[][] arr = new char[N][N];
	static int[][] st = new int[N][N];
	static int n,m;
	static long ans = 0;
	
	static void bfs(int sx,int sy) {
		Queue<PII> q = new LinkedList<PII>();
		q.add(new PII(sx,sy));
		st[sx][sy] = 1;
		
		while(q.size()>0) {
			PII top = q.poll();
			int x = top.x;
			int y = top.y;
// 			st[x][y] = 1;//不能在出队的时候标记，要在加入队列的时候就标记
// 			System.out.println(x+" "+y);

			for(int i=x-1;i<=x+1;i++)
				for(int j=y-1;j<=y+1;j++) {
					if(i==x && j==y) continue;
					if(i>=0 &&i<n &&j>=0 &&j<m && arr[i][j]=='W' && st[i][j]==0){
					    q.add(new PII(i,j));
					    st[i][j] = 1;
					}
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
					bfs(i,j);
					ans++;
				}
			}
		}
		System.out.println(ans);
	}

}
class PII{
	int x,y;
	public PII(int x,int y) {
		this.x = x;
		this.y = y;
	}
}