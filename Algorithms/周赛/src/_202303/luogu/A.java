package _202303.luogu;
import java.util.*;
import java.math.*;
import java.io.*;
public class A {
	static int INF = 0x3f3f3f3f;
	static int N = 1001000 , M = 2*N;

	static int n,m;
	static Node[] tree = new Node[4*N];//�߶�������
	

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


	//���ϸ��£����ڵ���u
	static void pushup(int u) {
		tree[u].val = Math.min(tree[u<<1].val, tree[u<<1|1].val);
	}
	//�����߶������������ڵ�u����������[l,r]
	static void build(int u,int l,int r) {
		//Ҷ�ӽڵ�ֱ�Ӽ�¼Ȩֵ
		if(l==r) 
			tree[u] = new Node(l, r, 0);
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
		//��������val��ȫ������ǰ�ڵ㣬��ֱ�Ӽ���
		if(tree[u].l>=l && tree[u].r<=r) 
			return tree[u].val;
		//���򣬵�ǰ�ڵ�ķ�Χһ��Ϊ��
		int mid = tree[u].l + tree[u].r >>1;
		int mx = INF;//����������ݾ�����Ŀ�仯�����������������sum
		//���������������ͼ���
		if(l <= mid) mx =  Math.min(mx, query(u<<1,l,r));
		if(r >= mid+1) mx =  Math.min(mx, query(u<<1|1,l,r));
		return mx;
	}
	
	//�����޸ģ���idxλ���ϵ���+v��u����ǰ�ڵ�
	static void modify(int u,int idx,int v) {
		//������Ҷ�ӽڵ���Ǿ����λ��idx
		if(tree[u].l==tree[u].r)
			tree[u].val += v;
		else {
			//�ж����ڸýڵ�u��������������������
			int mid = tree[u].l + tree[u].r >>1;
			if(idx<=mid) modify(u<<1, idx, v);
			else modify(u<<1|1, idx, v);
			pushup(u);//���ϸ���,����ǳ��������ǣ�����
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

