package 搜索;
import java.util.*;
import java.math.*;
import java.io.*;
public class _05武士风度的牛 {
	static int INF = 0x3f3f3f3f;
	static int N = 1010 , M = 2*N;
	static char[][] g = new char[N][N];
	static int[][] cen = new int[N][N];
	static int n,m,sx,sy,ex,ey;
	static int[] dx = {1,2,-1,-2,1,2,-1,-2};
	static int[] dy = {2,1,2,1,-2,-1,-2,-1};
	static int bfs(int sx,int sy) {
		for(int i=0;i<N;i++) {
			Arrays.fill(cen[i],INF);
		}
		Queue<PII> q = new LinkedList<PII>();
		q.add(new PII(sx,sy));
		cen[sx][sy] = 0;


		while(q.size()>0) {
			PII top = q.poll();
			int x = top.x;
			int y = top.y;
			for(int i=0;i<8;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx>=0 && nx<n && ny>=0 && ny<m && cen[nx][ny]==INF && g[nx][ny]=='.') {
					q.add(new PII(nx,ny));
					cen[nx][ny] = cen[x][y]+1;
					if(nx==ex && ny==ey) {
						return cen[ex][ey];
					}
				}
			}
		}
		return 0;
				
	}


	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		
		for(int i=0;i<n;i++) {
			g[i]= sc.next().toCharArray();
			for(int j=0;j<m;j++) {
				if(g[i][j]=='K') {
					sx = i;
					sy = j;
				}
				if(g[i][j]=='H') {
					ex = i;
					ey = j;
					g[i][j]='.';
				}
			}
		}
		
		int ans = bfs(sx,sy);
		System.out.println(ans);

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
