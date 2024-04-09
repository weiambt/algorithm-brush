package _202302.acwing._106;


import java.util.*;
import java.io.*;
public class C {
	static int INF = 0x3f3f3f3f;
	static int N = 201000,M = 2*N;
	static int[] arr = new int[N],vis = new int[N];
	static int[] l = new int[N],r = new int[N];
	static int n,k,cnt;
	static void deleteNode(int x) {
		r[l[x]] = r[x];
		l[r[x]] = l[x];
	}
	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		ArrayList<String> ans = new ArrayList<String>();
		n = sc.nextInt();
		char[] sex = (" "+sc.next()).toCharArray();
		
		for(int i=1;i<=n;i++) 
			arr[i] = sc.nextInt();
		PriorityQueue<Node> q = new PriorityQueue<Node>((a,b)->(a.val-b.val!=0?a.val-b.val:a.l-b.l));
		
		for(int i=2;i<n;i++) {
			r[i] = i+1;
			l[i] = i-1;
		}
		for(int i=2;i<n;i++) {
			if(sex[i]!=sex[i-1])
				q.add(new Node(Math.abs(arr[i]-arr[i-1]),i-1,i));
			if(sex[i]!=sex[i+1])
				q.add(new Node(Math.abs(arr[i]-arr[i+1]),i,i+1));
		}
		if(q.size()==0) {
			System.out.println(0);
			return;
		}

		while(q.size()>0) {
			Node top = q.poll();
			if(top.l==0 || top.r==n+1) break;
			if(vis[top.l]==0 && vis[top.r]==0) {
				cnt++;
				ans.add(new String(top.l+" "+top.r));
//				System.out.println(top.l+" "+top.r);
				vis[top.l] = 1;
				vis[top.r] = 1;
				int j = l[top.l];
				int k = r[top.r];
				deleteNode(top.l);
				deleteNode(top.r);
				if(j==0 || k==0)
					continue;
				if(sex[j]!=sex[k]){
				    q.add(new Node(Math.abs(arr[j]-arr[k]),j,k));
				}
					
				
			}
		}
		out.println(cnt);
		for(String i:ans)
			out.println(i);
		out.flush();
	}
}
class Node{
	int val;
	int l,r;
	public Node(int val,int l,int r) {
		// TODO Auto-generated constructor stub
		this.val = val;
		this.l = l;
		this.r = r;
	}
}
