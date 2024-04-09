package _03二分;

import java.util.*;
import java.math.*;
import java.io.*;

public class 分巧克力 {
	static int INF = 0x3f3f3f3f;
	static int N = 20090000 , M = 2*N;
	static int n,k;
	static PII[] arr = new PII[N];
	static boolean check(int x) {
		int cnt = 0;
		for(int i=1;i<=n;i++) {
			cnt += arr[i].a/x * arr[i].b /x;
			if(cnt>=k) return true;
		}
		return false;
	}
	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		for(int i=1;i<=n;i++) {
			arr[i]=new PII(sc.nextInt(),sc.nextInt());
		}
		int l = 1,r = (int)1e5;
		while(l<r) {
			int mid = l+r+1>>1;
			if(check(mid)) l = mid;
			else r = mid -1;
		}
		System.out.println(l);
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

