package _05½²_Ê÷×´Êý×éÏß¶ÎÊ÷;
import java.util.*;
import java.math.*;
import java.io.*;
public class ²î·Ö¾ØÕó {
		
		static int INF = 0x3f3f3f3f;
		static int N = 1010 , M = 2*N;
		static int[][] s = new int[N][N];
		static int[][] chafen = new int[N][N];
		static int n,m,q;

		public static void main(String[] sss) throws IOException {
			Scanner sc = new Scanner(System.in);
			n = sc.nextInt();
			m = sc.nextInt();
			q = sc.nextInt();
			for(int i=1;i<=n;i++) 
				for(int j=1;j<=m;j++) {
					s[i][j] = sc.nextInt();
					chafen[i][j] = s[i][j] - s[i-1][j] - s[i][j-1] + s[i-1][j-1];
				}
			
			while(q-->0){
				int x1,y1,x2,y2,c;
				x1 = sc.nextInt();
				y1 = sc.nextInt();
				x2 = sc.nextInt();
				y2 = sc.nextInt();
				c = sc.nextInt();
				
				chafen[x1][y1] += c;
				chafen[x1][y2+1] -= c;
				chafen[x2+1][y1] -= c;
				chafen[x2+1][y2+1] += c;
 			}
			
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=m;j++) {
					s[i][j] = s[i-1][j] + s[i][j-1] - s[i-1][j-1] + chafen[i][j];
					System.out.print(s[i][j]+" ");
				}
				System.out.println();
			}

				
		}

}
