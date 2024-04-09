package _202302.acwing_acc2;


import java.util.*;

public class C {
	static int INF = 0x3f3f3f3f;
	static int N = 1010,M = 2*N;
	static char[][] arr = new char[N][N];
	static int[][] dist = new int[N][N],vis = new int[N][N],pianyi = new int[N][N];
	static PII[][] path = new PII[N][N];
	static int ans,n,m,k,x1,y1,x2,y2;
	
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	
	static void bfs() {
		for(int i=0;i<N;i++)
			Arrays.fill(dist[i], INF);
		Queue<PII> q = new LinkedList<PII>();
		q.add(new PII(x1,y1));
		dist[x1][y1] = 0;
		vis[x1][y1] = 1;
		while(q.size()>0) {
			PII top = q.poll();
			int x = top.x;
			int y = top.y;
			for(int i=0;i<4;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(check(nx,ny) && arr[nx][ny]=='.' && vis[nx][ny]==0) {
					q.add(new PII(nx,ny));
					vis[nx][ny] = 1;
					dist[nx][ny] = dist[x][y] + 1;
					path[nx][ny] = new PII(x,y);
					pianyi[nx][ny] = i;
				}
			}
		}
//		System.out.println(dist[x2][y2]);
	}
	
	static void dfs() {
		int x = x2,y = y2;
		int cnt = 1;
		for(int i=1;i<dist[x2][y2];i++) {
			PII qian = path[x][y];
			if(cnt+1>k) {
				cnt = 1;
				ans++;
			}
			else if(pianyi[x][y] != pianyi[qian.x][qian.y]) {
				ans++;
				cnt = 1;
			}
			else
				cnt++;
			x = qian.x;
			y = qian.y;
		}
		System.out.println(ans+1);
	}

	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();
		for(int i=1;i<=n;i++) {
			String x = " "+sc.next();
			for(int j=1;j<=m;j++)
				arr[i][j] = x.charAt(j);
		}
		x1 = sc.nextInt();		
		y1 = sc.nextInt();	
		x2 = sc.nextInt();	
		y2 = sc.nextInt();	
		
		bfs();
		if(dist[x2][y2]==INF) {
			System.out.println(-1);
			return;
		}
		dfs();
	}
	
	static boolean check(int x,int y) {
		if(x>=1 && x<=n && y>=1 && y<=m)
			return true;
		return false;
	}
}
class PII{
	int x,y;
	public PII(int x,int y) {
		this.x = x;
		this.y = y;
	}
}
