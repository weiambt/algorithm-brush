package _01ËÑË÷;

import java.util.*;
import java.io.*;
import java.math.*;

public class ·ÉÐÐÔ±ÐÖµÜ {
	static int INF = 0x3f3f3f3f;
	static int N = 10,M = 2*N;
	static char[][] g = new char[N][N],tmp = new char[N][N];
	static int n=4,m=4,k;
	static long ans;
	static ArrayList<Integer[]> ansl;
	static void toggle_one(int a,int b) {
		if(g[a][b]=='+')
			g[a][b] = '-';
		else
			g[a][b] = '+';
	}
	static void toggle(int a,int b) {
		for(int i=0;i<n;i++) {
			if(i==a) continue;
			toggle_one(i, b);
		}
		for(int i=0;i<m;i++) {
			if(i==b) continue;
			toggle_one(a, i);
		}
		toggle_one(a, b);
	}
	static int get(int a,int b) {
		return 4*a+b;
	}
	static void solve() {
		for(int st=0;st<(1<<(m*n));st++) {
			int cnt = 0;
			for(int i=0;i<n;i++)
				for(int j=0;j<m;j++)
					g[i][j] = tmp[i][j];
			ArrayList<Integer[]> anstmp = new ArrayList<>();
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if((st>>get(i,j)&1)==1) {
						anstmp.add(new Integer[] {i+1,j+1});
						toggle(i,j);
						cnt += 1;
					}	
				}
			}
			
			int flag = 1;
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(g[i][j]=='+') {
						flag = 0;
						break;
					}
				}
			}
			if(flag==1) {
				if(cnt < ans) {
					ans = cnt;
					ansl = (ArrayList<Integer[]>) anstmp.clone();
				}
			}
				
		}
		System.out.println(ans);
		for(Integer[] x : ansl)
			System.out.println(x[0]+" "+x[1]);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		for(int i=0;i<n;i++) {
			String val = sc.next();
			
			for(int j=0;j<m;j++) {
				g[i][j] = val.charAt(j);
				tmp[i][j] = g[i][j];
			}
		}
		ans = INF;
		
		solve();
		
		
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