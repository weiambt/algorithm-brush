package _00模板;

public class 并查集 {
	static int N = 10;
	static int n,m;
	static int[] fa = new int[N];
	static int find(int x) {
		if(x==fa[x]) return x;
		return fa[x] = find(fa[x]);
	}
	static void init() {
		for(int i=0;i<n;i++) {
			fa[i] = i;
		}
	}
	static void union(int a,int b) {
		fa[find(a)] = find(b);
	}
	public static void main(String[] args) {
		
	}
}
