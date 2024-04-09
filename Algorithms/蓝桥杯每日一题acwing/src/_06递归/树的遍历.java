package _06递归;

import java.util.*;
import java.math.*;
import java.io.*;

public class 树的遍历 {
	static int INF = 0x3f3f3f3f;
	static int N = 101, M = 2*N;
	static int[] inOrder = new int[N];
	static int[] postOrder = new int[N];
	static int[] l = new int[N];
	static int[] r = new int[N];
	static int[] pos = new int[N];//pos[i]=j：节点i在中序遍历的下标是j
	static int n,m;
	static int build(int il,int ir,int pl,int pr) {
		int root = postOrder[pr];
		int rootIdx = pos[root];
		if(rootIdx-1>=il)
			l[root] = build(il, rootIdx-1, pl, pl+rootIdx-1-il);//后序左子树右端点x =  pl+rootIdx-1-il
		if(rootIdx+1<=ir)
			r[root] = build(rootIdx+1, ir, pl+rootIdx-il,pr-1);//后序右子树左端点：x+1
		return root;
	}
	static Queue<Integer> q = new LinkedList<Integer>();

	static void bfs(int root) {
		q.add(root);
		while(q.size()>0) {
			Integer top = q.poll();
			System.out.print(top+" ");
			if(l[top]!=0)
				q.add(l[top]);
			if(r[top]!=0)
				q.add(r[top]);
		}
	}

	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(int i=1;i<=n;i++)
			postOrder[i] = sc.nextInt();
		for(int i=1;i<=n;i++) {
			inOrder[i] = sc.nextInt();
			pos[inOrder[i]] = i;
		}
		int root = build(1,n,1,n);
		bfs(root);
		
	}
}
