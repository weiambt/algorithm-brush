package _9讲;
import java.util.*;
import java.math.*;
import java.io.*;

public class 区间合并 {
		static int INF = 0x3f3f3f3f;
		static int N = 110100 , M = 20010;
		static PII[] arr = new PII[N];
		static int n;

		public static void main(String[] sss) {
			Scanner sc = new Scanner(System.in);
			n = sc.nextInt();
			for(int i=1;i<=n;i++)
				arr[i] = new PII(sc.nextInt(),sc.nextInt());
			Arrays.sort(arr,1,n+1,(a,b)->(a.a!=b.a?a.a-b.a:a.b-b.b));
			int ans = 1;
			int r = arr[1].b;
			for(int i=2;i<=n;i++) {
				if(arr[i].a > r) {
					ans ++;
					r = arr[i].b;
				}
			}
			System.out.println(ans);
		}
}

class PII{
	int a,b;
	public PII(int a,int b) {
		// TODO Auto-generated constructor stub
		this.a = a;
		this.b = b;
	}
}
