package _02讲_二分和前缀和;
import java.util.*;
import java.math.*;

public class _04子矩阵的和 {
		static int INF = 0x3f3f3f3f;
		static int N = 1010;
		static int[][] s = new int[N][N];
		static int n,m,q;

		public static void main(String[] sss) {
			Scanner sc = new Scanner(System.in);
			n = sc.nextInt();
			m = sc.nextInt();
			q = sc.nextInt();
			for(int i=1;i<=n;i++) 
				for(int j=1;j<=m;j++) {
					s[i][j] = sc.nextInt();
					s[i][j] += s[i-1][j]+s[i][j-1]-s[i-1][j-1];
				}
			
			while(q-->0) {
				int x1 = sc.nextInt();
				int y1 = sc.nextInt();
				int x2 = sc.nextInt();
				int y2 = sc.nextInt();
				System.out.println(s[x2][y2]-s[x1-1][y2]-s[x2][y1-1]+s[x1-1][y1-1]);
			}
		}

}
