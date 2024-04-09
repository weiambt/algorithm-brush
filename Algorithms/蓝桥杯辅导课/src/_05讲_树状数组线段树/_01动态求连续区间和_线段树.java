package _05讲_树状数组线段树;
import java.util.*;
public class _01动态求连续区间和_线段树 {
	static int N = 100010;
	static int[] w = new int[N];//原数组
	static Node[] tree = new Node[4*N];//最多有4*N个节点
	static int n,m;
	
	//向上更新，根节点是u
	static void pushup(int u) {
		tree[u].sum = tree[u<<1].sum + tree[u<<1|1].sum;
	}
	//构建线段树函数，根节点u，构建区间[l,r]
	static void build(int u,int l,int r) {
		//叶子节点直接记录权值
		if(l==r) 
			tree[u] = new Node(l, r, w[l]);
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
		//如果区间和sum完全包含当前节点，就直接加上
		if(tree[u].l>=l && tree[u].r<=r) 
			return tree[u].sum;
		//否则，当前节点的范围一分为二
		int mid = tree[u].l + tree[u].r >>1;
		int sum = 0;
		//如果左、右区间满足就加上
		if(l <= mid) sum += query(u<<1,l,r);
		if(r >= mid+1) sum += query(u<<1|1, l, r);
		return sum;
	}
	
	//单点修改：给idx位置上的数+v。u代表当前节点
	static void modify(int u,int idx,int v) {
		//遍历到叶子节点就是具体的位置idx
		if(tree[u].l==tree[u].r)
			tree[u].sum += v;
		else {
			//判断是在该节点u的左子树还是右子树上
			int mid = tree[u].l + tree[u].r >>1;
			if(idx<=mid) modify(u<<1, idx, v);
			else modify(u<<1|1, idx, v);
			pushup(u);//向上更新
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		for(int i=1;i<=n;i++)
			w[i] = sc.nextInt();
		build(1, 1, n);
		while(m-->0) {
			int op,a,b;
			op = sc.nextInt();
			a = sc.nextInt();
			b = sc.nextInt();
			if(op==0) System.out.println(query(1, a, b));
			else modify(1, a, b);
		}
	}
}
//class Node{
//	int l,r;
//	int sum;
//	public Node(int l,int r,int sum) {
//		this.l = l;
//		this.r = r;
//		this.sum = sum;
//	}
//}