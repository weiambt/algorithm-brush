package _05��_��״�����߶���;

import java.util.*;
import java.math.*;

public class _01��̬�����������_��״���� {
	static int INF = 0x3f3f3f3f;
	static int N = 101000 , M = 2*N;
	static int[] arr = new int[N];
	static int[] tree = new int[N];
	static int n,m;
	static int lowbit(int x) {
		return x&-x;
	}
	//��arr[x]��ֵ���v
	static void add(int x,int v) {
		for(int i=x;i<=n;i+=lowbit(i)) {
			tree[i]+=v;
		}
	}
	//����arr[1~x]�ĺ�
	static int query(int x) {
		int res = 0;
		for(int i=x;i>0;i-=lowbit(i)) {
			res += tree[i];
		}
		return res;
	}
	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		for(int i=1;i<=n;i++) 
			arr[i] = sc.nextInt();
		//������״����
		for(int i=1;i<=n;i++)
			add(i,arr[i]);
		int op,x,y;
		while(m-->0) {
			op = sc.nextInt();
			x = sc.nextInt();
			y = sc.nextInt();
			if(op==0) 
				System.out.println(query(y) - query(x-1));
			else
				add(x,y);
		}
		
	}

}
