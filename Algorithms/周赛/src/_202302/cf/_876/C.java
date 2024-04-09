package _202302.cf._876;
import java.util.*;
import java.io.*;
public class C {
	static int INF = 0x3f3f3f3f;
	static int N = 201000,M = 2*N;
	static int[] arr = new int[N],vis = new int[N];
	static int n,k,cnt;
	//1  3  5 6 8
	//比x小的最大的
	static int find1(Integer[] a,int l,int r,int x) {
		while(l<r) {
			int mid = l+r+1>>1;
			if(a[mid]<x) l = mid;
			else r = mid-1;
		}
		return l;
	}
	//比x大的最小的
	static int find2(Integer[] a,int l,int r,int x) {
		while(l<r) {
			int mid = l+r>>1;
			if(a[mid]>x) r = mid;
			else l = mid+1;
		}
		return l;
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
			if(vis[top.l]==0 && vis[top.r]==0) {
				cnt++;
				ans.add(new String(top.l+" "+top.r));
//				System.out.println(top.l+" "+top.r);
				vis[top.l] = 1;
				vis[top.r] = 1;
				int j = top.l-1;
				while(j>=1 && vis[j]==1) {
					j--;
				}
				int k = top.r+1;
				while(k<=n && vis[k]==1) {
					k++;
				}
				if(k>n || j<1) continue;
				if(sex[j]!=sex[k])
					q.add(new Node(Math.abs(arr[j]-arr[k]),j,k));
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
