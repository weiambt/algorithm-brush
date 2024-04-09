package _05��_��״�����߶���;
import java.util.*;
public class _01��̬�����������_�߶��� {
	static int N = 100010;
	static int[] w = new int[N];//ԭ����
	static Node[] tree = new Node[4*N];//�����4*N���ڵ�
	static int n,m;
	
	//���ϸ��£����ڵ���u
	static void pushup(int u) {
		tree[u].sum = tree[u<<1].sum + tree[u<<1|1].sum;
	}
	//�����߶������������ڵ�u����������[l,r]
	static void build(int u,int l,int r) {
		//Ҷ�ӽڵ�ֱ�Ӽ�¼Ȩֵ
		if(l==r) 
			tree[u] = new Node(l, r, w[l]);
		else {
			tree[u] = new Node(l, r, 0);//ֵ�ȼ�Ϊ0��pushup�ٸ���
			int mid = l+r>>1;
			build(u<<1, l, mid);//����������
			build(u<<1|1, mid+1, r);//����������
			pushup(u);//���ϸ���val
		}
	}
	
	//���㵱ǰ�ڵ�u�µ���[l,r]��Χ�ڵĺͣ�u����ǰ�ڵ�(�ݹ��ʱ��l,r�ǲ����)
	static int query(int u,int l,int r) {
		//��������sum��ȫ������ǰ�ڵ㣬��ֱ�Ӽ���
		if(tree[u].l>=l && tree[u].r<=r) 
			return tree[u].sum;
		//���򣬵�ǰ�ڵ�ķ�Χһ��Ϊ��
		int mid = tree[u].l + tree[u].r >>1;
		int sum = 0;
		//���������������ͼ���
		if(l <= mid) sum += query(u<<1,l,r);
		if(r >= mid+1) sum += query(u<<1|1, l, r);
		return sum;
	}
	
	//�����޸ģ���idxλ���ϵ���+v��u����ǰ�ڵ�
	static void modify(int u,int idx,int v) {
		//������Ҷ�ӽڵ���Ǿ����λ��idx
		if(tree[u].l==tree[u].r)
			tree[u].sum += v;
		else {
			//�ж����ڸýڵ�u��������������������
			int mid = tree[u].l + tree[u].r >>1;
			if(idx<=mid) modify(u<<1, idx, v);
			else modify(u<<1|1, idx, v);
			pushup(u);//���ϸ���
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