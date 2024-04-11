package _00Ä£°å;

public class Ê÷×´Êý×é {
	static int N = 10;
	static int[] tree = new int[N], arr = new int[N];
	static int n,m;
	static int lowbit(int x) {
		return x&-x;
	}
	static void add(int idx,int v) {
		for(int i=idx;i<=n;i+=lowbit(i)) {
			tree[i] += v;
		}
	}
	static int query(int idx) {
		int res = 0;
		for(int i=idx;i>0;i-=lowbit(i)) {
			res += tree[i];
		}
		return res;
	}
	static int query(int l,int r) {
		return query(r)-query(l-1);
	}
	public static void main(String[] args) {
		for(int i=1;i<=n;i++) {
			add(i,arr[i]);
		}
	}
}
