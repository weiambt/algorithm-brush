package _13DFS;
import java.util.*;
import java.math.*;
import java.io.*;

public class ∞Àª ∫ÛŒ Ã‚ {
		static int INF = 0x3f3f3f3f;
		static int N = 101 , M = 2*N;
		static int[] dx = {1,0,-1,0};
		static int[] dy = {0,1,0,-1};
		static int n;
		static int[] hang = new int[N];
		static int[] lie = new int[N];
		static int[] zhu = new int[2*N];
		static int[] fu = new int[2*N];
		static char[][] g = new char[N][N];
		static void dfs(int len) {
			if(len==n) {
				for(int i=0;i<n;i++) {
					for(int j=1;j<=n;j++)
						System.out.print(g[i][j]);
					System.out.println();
				}
				System.out.println();
				return ;
			}
			for(int i=1;i<=n;i++) {
				if(hang[len]==0 && lie[i]==0 && zhu[i-len+N]==0 && fu[i+len]==0) {
					hang[len]=1;
					lie[i]=1;
					zhu[i-len+N]=1;
					fu[i+len]=1;
					g[len][i] = 'Q';
					dfs(len+1);
					g[len][i] = '.';
					hang[len]=0;
					lie[i]=0;
					zhu[i-len+N]=0;
					fu[i+len]=0;
				}
			}
		}

		public static void main(String[] sss) {
			Scanner sc = new Scanner(System.in);
			n = sc.nextInt();
			for(int i=0;i<n;i++) 
				for(int j=1;j<=n;j++)
					g[i][j] = '.';
			dfs(0);
		}
}
