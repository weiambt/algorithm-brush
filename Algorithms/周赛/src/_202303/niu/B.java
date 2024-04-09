package _202303.niu;
import java.util.*;
import java.math.*;
import java.io.*;

public class B {
		static int INF = 0x3f3f3f3f;
		static int N = 1001000 , M = 2*N;
		static int[] arr = new int[N];
		static int n,m;

		public static void main(String[] sss) {
			Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in))); 
			PrintWriter out = new PrintWriter(System.out);
			n = sc.nextInt();
			for(int i=1;i<=n;i++)
				arr[i] = sc.nextInt();
			int cnt=1,fuhao=1;
			int flag=0,ans=1;
			for(int i=1;i<=n;i++) {
				if(n-i+1<=ans) break;
				int j=i+1;
				while(j<=n && arr[j]==arr[i]+fuhao*cnt) {
					j++;
					fuhao = fuhao==1?-1:1;
					flag++;

					if(flag==2) {
						cnt++;
						flag=0;
					}
				}
				ans = Math.max(ans, j-i);
				i = j-1;

			}
			System.out.println(ans);
			out.flush();
		}
}
