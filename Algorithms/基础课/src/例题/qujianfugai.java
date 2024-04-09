package ÀýÌâ;

import java.util.*;
import java.math.*;
import java.io.*;

public class qujianfugai {
		static int INF = 1000000007;
		static int N = 101000 , M = 2*N;
		static PII[] arr = new PII[N];
		static int n,start,end,ans;
		
		public static void main(String[] sss) {
			Scanner sc = new Scanner(System.in);
			start = sc.nextInt();end = sc.nextInt();
			n = sc.nextInt();
			for(int i=1;i<=n;i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				arr[i] = new PII(a,b);
			}
			Arrays.sort(arr,1,n+1,(a,b)->(a.l-b.l));
			int flag = 0;
			for(int i=1;i<=n;i++) {
				int j = i,r = -0x3f3f3f3f;
				while(j<=n && arr[j].l<=start) {
					r = Math.max(r,arr[j].r);
					j++;
				}
				if(r<start) {
					break;
				}
				ans++;
				start = r;
				if(r>=end) {
					flag = 1;
					break;
				}
				i = j-1;
			}
			if(flag==1) System.out.println(ans);
			else System.out.println(-1);
		}
		
}
//class PII{
//	int l,r;
//	public PII(int l,int r) {
//		// TODO Auto-generated constructor stub
//		this.l = l;
//		this.r = r;
//	}
//}
