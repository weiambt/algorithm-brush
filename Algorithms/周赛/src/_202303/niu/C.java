package _202303.niu;
import java.util.*;
import java.math.*;
import java.io.*;

public class C {
		static int INF = 0x3f3f3f3f;
		static int N = 1001000 , M = 2*N;
		static int[] order = new int[N],cnt = new int[N];
		static int n,m;
		static void dfs(int x) {
			if(cnt[order[x]]==1)return;
			if()
			System.out.println();
			dfs(x+1);
		}

		public static void main(String[] sss) {
			Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in))); 
			PrintWriter out = new PrintWriter(System.out);
			n = sc.nextInt();
			for(int i=1;i<=n;i++)
				order[i] = sc.nextInt();
			for(int i=1;i<=n;i++)
				cnt[i] = sc.nextInt();
			
			dfs(1);
			
			out.flush();
		}
}
