package 数据结构;

import java.util.*;
import java.math.*;
import java.io.*;

public class 最大数 {
	static int INF = 0x3f3f3f3f;
	static int N = 201000 , M = 2*N;
	static Node[] tree = new Node[4*N];
	static int m,p;

	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		int n = 0,last = 0;
		m = sc.nextInt();
		p = sc.nextInt();
		build(1,1,m);
		for(int i=1;i<=m;i++) {
			String op = sc.next();
			int val = sc.nextInt();
			if(op.equals("Q")) {
				last = query(1, n-val+1, n);
				System.out.println(last);
			}else {
				n++;
				modify(1, n, (val+last)%p);
			}
		}
	}
	static void pushUp(int u) {
		tree[u].val = Math.max(tree[u<<1].val ,tree[u<<1|1].val);
	}
	static void build(int u,int l,int r) {
		if(l==r) tree[u] = new Node(l, r, 0);
		else {
			tree[u] = new Node(l,r,0);
			int mid = l+r>>1;
			build(u<<1,l,mid);
			build(u<<1|1,mid+1,r);
			pushUp(u);
		}
		
	}
	static int query(int u,int l,int r) {
		if(tree[u].l>=l && tree[u].r<=r)
			return tree[u].val;
		int mid = tree[u].l+tree[u].r>>1;
		int mx = 0;
		if(l<=mid) mx = query(u<<1,l,r);
		if(r>=mid+1) mx = Math.max(mx,query(u<<1|1,l,r));
		return mx;
	}
	static void modify(int u,int idx,int val) {
		if(tree[u].l==tree[u].r)
			tree[u].val = val;
		else {
			int mid = tree[u].l+tree[u].r>>1;
			if(idx<=mid) modify(u<<1,idx,val);
			else modify(u<<1|1,idx,val);
			pushUp(u);
		}
	}
}
class Node{
	int l,r,val;
	public Node(int l,int r,int val) {
		// TODO Auto-generated constructor stub
		this.l = l;
		this.r = r;
		this.val = val;
	}
}
