package _9½²;
import java.util.*;
import java.math.*;
import java.io.*;

public class ÅÅ¶Ó´òË® {
		static int INF = 0x3f3f3f3f;
		static int N = 110100 , M = 20010;
		static int[] arr = new int[N];
		static int n;

		public static void main(String[] sss) {
			Scanner sc = new Scanner(System.in);
			n = sc.nextInt();
			for(int i=1;i<=n;i++)
				arr[i] = sc.nextInt();
			
			Arrays.sort(arr,1,n+1);
			
			int wait = arr[1],ans = 0;
			for(int i=2;i<=n;i++) {
				ans += wait;
				wait += arr[i];
			}
			System.out.println(ans);
		}
}
