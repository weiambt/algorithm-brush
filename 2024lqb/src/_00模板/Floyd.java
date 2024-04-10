package _00Ä£°å;
import java.util.*;

public class Floyd {
	static int INF = 0x3f3f3f3f;
	static int N = 101000,M = 2*N;
	static int[][] g = new int[N][N];
	static int n,m;
	static long ans;
	static void floyd() {
		for(int k=1;k<=n;k++) {
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					g[i][j] = Math.min(g[i][j],g[i][k]+g[k][j]);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i=1;i<=n;i++) {
			Arrays.fill(g[i],INF);
			g[i][i] = 0;
		}
		n = sc.nextInt();
		m = sc.nextInt();
		for(int i=1;i<=m;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			g[a][b] = c;
			g[b][a] = c;
		}
		floyd();
	}
}
