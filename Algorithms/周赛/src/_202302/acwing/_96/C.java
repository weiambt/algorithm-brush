package _202302.acwing._96;
import java.util.*;

public class C {
	static int INF = 0x3f3f3f3f;
	static int N = 200100,M = 2*N;
	static int[] arr = new int[N];
	static int[] tree = new int[4*N];
	static int n,k,a,b,q;
	//原数组:arr,树状数组：tree
	 	static int lowbit(int x) {
			return x&-x;
		}
		//在arr[x]的值添加v
		static void add(int x,int v) {
			for(int i=x;i<=n;i+=lowbit(i)) {
				tree[i]+=v;
				if(tree[i])
			}
		}
		//计算arr[1~x]的和
		static int query(int x) {
			int res = 0;
			for(int i=x;i>0;i-=lowbit(i)) {
				res += tree[i];
			}                                                             
			return res;
		}
	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		a = sc.nextInt();
		b = sc.nextInt();
		q = sc.nextInt();
		while(q-->0) {
			int op = sc.nextInt();
			if(op==1) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				add(x, y);
			}else {
				int p = sc.nextInt();
				System.out.println(query(x));
			}
		}
	}
}
