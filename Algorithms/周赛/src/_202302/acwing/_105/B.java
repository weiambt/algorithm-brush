package _202302.acwing._105;


import java.util.*;
import java.util.Map.Entry;
import java.io.*;
import java.math.*;
public class B {
	static int INF = 0x3f3f3f3f;
	static int N = 100100,M = 2*N;
	static int[] arr = new int[N],ans = new int[N];
	static int n,b;
	
	public static void main(String[] args) {
		Scanner sc =  new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		n = sc.nextInt();
		for(int i=1;i<=n;i++)
			arr[i] = sc.nextInt();
		for(int i=1;i<=n;i++) {
			int[] mp = new int[n+1];
			int maxKey = n+1,maxCnt=-1;
			for(int j=i;j<=n;j++) {
				int val = mp[arr[j]];
				mp[arr[j]] =  val+1;
				if(val+1 > maxCnt) {
					maxCnt = val + 1;
					maxKey = arr[j];
					ans[arr[j]]++;
				}
				else if(val+1 == maxCnt && maxKey>arr[j]) {
						maxKey = arr[j];
						ans[maxKey]++;
				}else {
					ans[maxKey]++;
				}
				
			}
		}
		for(int i=1;i<=n;i++)
			System.out.print(ans[i]+" ");
	}
}


