package _202302.acwing._97;
import java.util.*;

public class A {
	static int INF = 0x3f3f3f3f;
	static int N = 101000,M = 2*N;
	static int[] arr = new int[N];
	static int n,m;
	static int[] h = new int[N],e = new int[N],ne = new int[N],w = new int[N];
	static int idx,ans;
	static void add(int a,int b,int c) {
		e[idx] = b;
		w[idx] = c;
		ne[idx] = h[a];
		h[a] = idx++;
	}
	static void init() {
		for(int i=1;i<=n;i++)
			h[i] = -1;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b =sc.nextInt();
		System.out.println(Math.min(a, b)+" "+Math.abs(a-b)/2);
	}
}
