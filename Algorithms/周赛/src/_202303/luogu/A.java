package _202303.luogu;
import java.util.*;
import java.math.*;
import java.io.*;
public class A {
	static int INF = 0x3f3f3f3f;
	static int N = 1001000 , M = 2*N;

	static int n,m;
	static Node[] tree = new Node[4*N];//线段树数组
	

	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		build(1, 1, N-1);
		int cnt=1;
		m = sc.nextInt();
		
		while(m-->0) {
			int op = sc.nextInt();
			n = sc.nextInt();
			if(op==1) {
				while(n-->0) {
					int x = sc.nextInt();
					modify(1, cnt++, x);
				}
			}else {
				System.out.println(query(1, 1, n));
			}
		}
	}


	//向上更新，根节点是u
	static void pushup(int u) {
		tree[u].val = Math.min(tree[u<<1].val, tree[u<<1|1].val);
	}
	//构建线段树函数，根节点u，构建区间[l,r]
	static void build(int u,int l,int r) {
		//叶子节点直接记录权值
		if(l==r) 
			tree[u] = new Node(l, r, 0);
		else {
			tree[u] = new Node(l, r, 0);//值先记为0，pushup再更新
			int mid = l+r>>1;
			build(u<<1, l, mid);//构建左子树
			build(u<<1|1, mid+1, r);//构建右子树
			pushup(u);//向上更新val
		}
	}
	
	//计算当前节点u下的在[l,r]范围内的和，u代表当前节点(递归的时候l,r是不变的)
	static int query(int u,int l,int r) {
		//如果区间和val完全包含当前节点，就直接加上
		if(tree[u].l>=l && tree[u].r<=r) 
			return tree[u].val;
		//否则，当前节点的范围一分为二
		int mid = tree[u].l + tree[u].r >>1;
		int mx = INF;//这个参数根据具体题目变化，如果是求和这里就是sum
		//如果左、右区间满足就加上
		if(l <= mid) mx =  Math.min(mx, query(u<<1,l,r));
		if(r >= mid+1) mx =  Math.min(mx, query(u<<1|1,l,r));
		return mx;
	}
	
	//单点修改：给idx位置上的数+v。u代表当前节点
	static void modify(int u,int idx,int v) {
		//遍历到叶子节点就是具体的位置idx
		if(tree[u].l==tree[u].r)
			tree[u].val += v;
		else {
			//判断是在该节点u的左子树还是右子树上
			int mid = tree[u].l + tree[u].r >>1;
			if(idx<=mid) modify(u<<1, idx, v);
			else modify(u<<1|1, idx, v);
			pushup(u);//向上更新,这里非常容易忘记！！！
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

