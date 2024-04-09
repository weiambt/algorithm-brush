package _01搜索;
import java.util.*;


public class 递归实现指数型枚举 {
	static int N = 30;
	static int n;
	static int[] a = new int[N];
	static void dfs(int u) {
		if(u==n) {
			ArrayList<Integer> ans = new ArrayList<Integer>();
			for(int i=0;i<n;i++) {
				if(a[i]==1)
					ans.add(i);
			}
			ans.sort((a,b)->(a-b));
			for(Integer x:ans)
				System.out.print(x+" ");
			System.out.println();
			return ;
		}
		a[u] = 1;
		dfs(u+1);
		a[u] = 0;
		dfs(u+1);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		dfs(0);
	}
}
