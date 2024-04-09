package À—À˜;
import java.util.*;
import java.math.*;
import java.io.*;
public class _04√‘π¨Œ Ã‚ {
	static int INF = 0x3f3f3f3f;
	static int N = 1010 , M = 2*N;
	static int[][] g = new int[N][N];
	static int[][] cen = new int[N][N];
	static PII[][] pre = new PII[N][N];
	static int n;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static void bfs(int sx,int sy) {
		for(int i=0;i<N;i++) {
			Arrays.fill(cen[i],INF);
		}
		Queue<PII> q = new LinkedList<PII>();
		q.add(new PII(sx,sy));
		cen[sx][sy] = 0;
		pre[sx][sy] = new PII(-1,-1);

		while(q.size()>0) {
			PII top = q.poll();
			int x = top.x;
			int y = top.y;
			for(int i=0;i<4;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx>=0 && nx<n && ny>=0 && ny<n && g[nx][ny]==0 && cen[nx][ny]==INF) {
					q.add(new PII(nx,ny));
					cen[nx][ny] = cen[x][y]+1;
					pre[nx][ny] = new PII(x,y);
				}
			}
			
		}
				
	}
	static void find(int x,int y) {
		if(x==-1 && y==-1) return;
		find(pre[x][y].x,pre[x][y].y);
		System.out.println(x+" "+y);
	}

	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++)
				g[i][j] = sc.nextInt();
		}
		
		bfs(0,0);
		find(n-1,n-1);

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
