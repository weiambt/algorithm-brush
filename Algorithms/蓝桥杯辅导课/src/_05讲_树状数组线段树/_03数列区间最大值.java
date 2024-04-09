package _05讲_树状数组线段树;

import java.util.*;
import java.io.*;
import java.math.*;

public class _03数列区间最大值 {
	static int INF = 0x3f3f3f3f;
	static int N = 101000 , M = 2*N;
	static int n,m;
	static int[] w = new int[N];
	static Node[] tree = new Node[4*N];
	
	public static void main(String[] sss) throws IOException {
		FastRead sc = new FastRead();
		n = sc.nextInt();
		m = sc.nextInt();
		for(int i=1;i<=n;i++) 
			w[i] = sc.nextInt();
		build(1, 1, n);
		int a,b;
		while(m-->0) {
			a = sc.nextInt();
			b = sc.nextInt();
			sc.println(query(1, a, b));
		}
		sc.out.flush();
	}
	
	static void pushup(int u) {
		tree[u].val = Math.max(tree[u<<1].val, tree[u<<1|1].val);
	}
	static void build(int u,int l,int r) {
		if(l==r)
			tree[u] = new Node(l, r, w[l]);
		else {
			tree[u] = new Node(l, r, 0);
			int mid = l + r >>1;
			build(u<<1, l, mid);
			build(u<<1|1, mid+1, r);
			pushup(u);
		}
	}

	static int query(int u,int l,int r) {
		if(tree[u].l >=l && tree[u].r <=r)
			return tree[u].val;
		int mid = tree[u].l + tree[u].r >>1;
		int mx = Integer.MIN_VALUE;
		if(l<=mid) mx = Math.max(mx, query(u<<1, l, r));
		if(r>=mid+1) mx = Math.max(mx, query(u<<1|1, l, r)) ;
		return mx;
	}
	static void modify(int u,int idx,int v) {
		if(tree[u].l==tree[u].r)
			tree[u].val += v;
		else {
			int mid = tree[u].l + tree[u].r >>1;
			if(idx <= mid) modify(u<<1, idx, v);
			else modify(u<<1|1, idx, v);
		}
	}
}

class Node{
	int l,r,val;
	public Node(int l,int r,int val) {
		this.l = l;
		this.r = r;
		this.val = val;
	}
}
class FastRead {
    StreamTokenizer streamTokenizer;  //读取数字
    BufferedReader bufferedReader;  //读取字符串
	PrintWriter out;

    public FastRead() {
        streamTokenizer = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        out=new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    }

    int nextInt() throws IOException {
        streamTokenizer.nextToken();
        return (int) streamTokenizer.nval;
    }

    long nextLong() throws IOException {
        streamTokenizer.nextToken();
        return (long) streamTokenizer.nval; 
    }

    double nextDouble() throws IOException {
        streamTokenizer.nextToken();
        return streamTokenizer.nval;
    }

    String nextLine() throws IOException {
    	return bufferedReader.readLine();
    }
    
    void println(String s) throws IOException{
    	out.println(s);
    }
    
    void println(int s) throws IOException{
    	out.println(s);
    }
    
    void println(long s) throws IOException{
    	out.println(s);
    }
    
    void println(double s) throws IOException{
    	out.println(s);
    }
    
    void println(BigInteger s) throws IOException{
    	out.println(s);
    }
}