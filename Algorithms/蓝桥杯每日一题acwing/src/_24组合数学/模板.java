package _24组合数学;
import java.util.*;
import java.io.*;
import java.math.*;
import java.time.DayOfWeek;

public class 模板 {
	static int INF = 0x3f3f3f3f;
	static int Mod = (int)1e9+7;
	static int N = 101000, M = 2*N;
	static int[] arr = new int[N];
	static int n,m,q;
	static long ans,cnt;
	
	//邻接表
	static int[] h = new int[N],e = new int[M],ne = new int[M],w = new int[M];
	static int idx;
	static void add(int a,int b,int c) {
		e[idx] = b;
		w[idx] = c;
		ne[idx] = h[a];
		h[a] = idx++;
	}
	static void init() {
		Arrays.fill(h, -1);
	}
	
	//快速幂
	static long qpow(long a,long b) {
		long res = 1;
		while(b>0) {
			if((b&1)==1) res = res * a%Mod;
			a = a*a %Mod;
			b>>=1;
		}
		return res;
	}
	
	
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	
	static int[] day = {0,31,30,31,30,31,30,31,31,30,31,30,31};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		for(int i=1;i<=n;i++)
			arr[i] = sc.nextInt();
		
//		for(int i=1;i<=n;i++)
//			for(int j=1;j<=m;j++)
//				arr[i][j] = sc.nextInt();
		
	}
	
	public static void main2(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		
		
		
		out.flush();
	}
}
class PII{
	int x,y;
	public PII(int x,int y) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
	}
}