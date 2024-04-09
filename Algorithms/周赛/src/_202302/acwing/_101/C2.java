package _202302.acwing._101;
import java.util.*;

public class C2 {
	static int INF = 0x3f3f3f3f;
	static int N = 101000,M = 2*N;

	static int n;
	

	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		n = sc.nextInt();

		for(int i=1;i<=n;i++) {
			w[i] = sc.nextInt();
		}
		
		//初始化：
		build(1,1,n);
		
		for(int i=1,j=1;i<=n;i++) {
			
		}

		//查询[a,b]的结果：
		query(1,a,b);


		
		
		
	}
	static int[] w = new int[N];//原数组
	static Node[] tree = new Node[4*N];//线段树数组

	//向上更新，根节点是u
	static void pushup(int u) {
		tree[u].val = Math.max(tree[u<<1].val , tree[u<<1|1].val);
		tree[u].val2 = Math.min(tree[u<<1].val2 , tree[u<<1|1].val2);
	}

	//构建线段树函数，根节点u，构建区间[l,r]
	static void build(int u,int l,int r) {
		//叶子节点直接记录权值
		if(l==r) 
			tree[u] = new Node(l, r, w[l],w[l]);
		else {
			tree[u] = new Node(l, r, 0,INF);//值先记为0，pushup再更新
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
		int ma = 0;//这个参数根据具体题目变化，如果是求和这里就是sum
		//如果左、右区间满足就加上
		if(l <= mid) ma = Math.max(ma, query(u<<1,l,r));
		if(r >= mid+1) ma = Math.max(ma,query(u<<1|1, l, r));
		return ma;
	}
	
	static int query2(int u,int l,int r) {
		//如果区间和val完全包含当前节点，就直接加上
		if(tree[u].l>=l && tree[u].r<=r) 
			return tree[u].val2;
		//否则，当前节点的范围一分为二
		int mid = tree[u].l + tree[u].r >>1;
		int mi = INF;//这个参数根据具体题目变化，如果是求和这里就是sum
		//如果左、右区间满足就加上
		if(l <= mid) mi = Math.max(mi, query2(u<<1,l,r));
		if(r >= mid+1) mi = Math.max(mi,query2(u<<1|1, l, r));
		return mi;
	}
	


}
class Node{
	int l,r,val,val2;
	public Node(int l,int r,int val,int val2) {
		this.l = l;
		this.r = r;
		this.val = val;
		this.val2 = val2;
	}
}

