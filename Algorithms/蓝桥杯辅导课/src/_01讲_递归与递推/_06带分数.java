package _01讲_递归与递推;

import java.util.*;
public class _06带分数 {
	static int INF = 0x3f3f3f3f;
	static int N = 10 , M = 2*N;

	static int n,cnt;
	static int[] st = new int[N],ans = new int[N];
	static int cal(int l,int r) {
		int res = 0;
		while(l<=r) {
			res = ans[l] + res * 10;
			l++;
		}
		return res;
	}
	static void dfs(int pos) {
		if(pos>9) {
			//ans[1]~ans[9]
			for(int i=1;i<=7;i++) {//第一分割线
				for(int j=2;j<=8;j++) {//第二分割线
					int a = cal(1,i);
					int b = cal(i+1,j);
					int c = cal(j+1,9);
					if(n*c==a*c+b) // n = a+b/c
						cnt++;
				}	
			}
		}
		for(int i=1;i<=9;i++) {
			if(st[i]==0) {
				st[i] = 1;
				ans[pos] = i;
				dfs(pos+1);
				st[i] = 0;
			}
		}
	}
	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		dfs(1);
		System.out.println(cnt);
	}
}
