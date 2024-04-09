package _202302.acwing._100;
import java.util.*;
import java.io.*;

public class B {
	static int INF = 0x3f3f3f3f;
	static int N = 101000,M = 2*N;
	static int[] arr = new int[N],st = new int[N];
	static int n,m,l,r,x;
	static int idx,ans;
	
	static void dfs(int pos) {
		if(pos>=n) {
			int cnt = 0,sum=0,ma = 0,mi=INF;
			for(int i=0;i<n;i++) {
//				System.out.print(st[i]+" ");
				if(st[i]==2) {
					cnt++;
					sum += arr[i];
					ma = Math.max(ma,arr[i]);
					mi = Math.min(mi,arr[i]);
				}
				
			}
			if(cnt>=2 && sum>=l && sum<=r && ma-mi>=x)
				ans++;
			return ;
		}
		
		
		st[pos] = 1;
		dfs(pos+1);
		
		st[pos] = 2;
		dfs(pos+1);
		st[pos] = 0;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		l = sc.nextInt();
		r = sc.nextInt();
		x = sc.nextInt();
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		dfs(0);
		System.out.println(ans);
		
	}
}

