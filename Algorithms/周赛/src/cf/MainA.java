package cf;
import java.util.*;
import java.math.*;

public class MainA {
		static int INF = 0x3f3f3f3f;
		static int N = 1010 , M = 2*N;
		static int[] arr = new int[N];
		static int n,m;

		public static void main(String[] sss) {
			Scanner sc = new Scanner(System.in);
			m = sc.nextInt();
			while(m-->0) {
				int cnt = 0;
				n = sc.nextInt();
				for(int i=1;i<=n;i++) {
					arr[i] = sc.nextInt();
					if(arr[i]==2) cnt++;
				}
				if(cnt==0) System.out.println(1);
				else if(cnt%2==1) System.out.println(-1);	
				else {
				
					int c = 0;
					for(int i=1;i<=n-1;i++) {
						if(arr[i]==2) {
							c++;
							if(c==cnt/2) {
								System.out.println(i);
								break;
							}
						}	
					}
				}
				
			}
		}
}
