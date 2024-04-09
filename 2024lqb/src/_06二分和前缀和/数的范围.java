package _06二分和前缀和;

import java.util.*;
import java.io.*;
import java.math.*;

public class 数的范围 {
	static int INF = 0x3f3f3f3f;
	static int N = 101000,M = 2*N;
	static int[] arr = new int[N];
	static int n,m;
	static long ans;
	static int find_l(int l,int r,int x) {
		while(l<r) {
			int mid = l+r>>1;
			if (arr[mid]>=x) 
				r = mid;
			else 
				l = mid+1;
		}
		return l;
	}
	static int find_r(int l,int r,int x) {
		while(l<r) {
			int mid = l+r+1>>1;
			if (arr[mid]<=x) 
				l = mid;
			else 
				r = mid-1;
		}
		return l;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		for(int i=1;i<=n;i++) {
			arr[i] = sc.nextInt();
		}
		while(m-->0) {
			int x = sc.nextInt();
			int ans1 = find_l(1,n,x);
			int ans2 = find_r(1,n,x);
			if(arr[ans1]!=x) {
				System.out.println("-1 -1");
				continue;
			}
				
			ans1 -= 1;
			ans2 -= 1;
			System.out.println(ans1+" "+ans2);
		}
	}
	
	
	static int[] h = new int[N],e = new int[M],ne = new int[M],w = new int[M];
	static int idx;
	static void add(int a,int b,int c) {
		e[idx] = b;
		w[idx] = c ;
		ne[idx] = h[a];
		h[a] = idx++;
	}
	static void init(){
		Arrays.fill(h,-1);
	}



	class Read{
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
	//	PrintWriter out = new PrintWriter(System.out);
	//	out.flush();
		int nextInt() throws IOException {
			st.nextToken();
			return (int)st.nval;
		}
		String getLine() throws IOException {
			return r.readLine();
		}
	}
}
