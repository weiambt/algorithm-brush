package _202302.acwing._103;


import java.util.*;
import java.io.*;
import java.math.*;
public class B {
	static int INF = 0x3f3f3f3f;
	static int N = 100100,M = 2*N;
	static int[] st = new int[N];
	static int n;

	
	public static void main(String[] args) {
		Scanner sc =  new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		n = sc.nextInt();
		ArrayList<Integer> ans = new ArrayList<Integer>();
		
		for(int i=2;i<=n;i++) {
			int x = i;
			for(int j=2;j<=x/j;j++) {
				if(x%j==0) {
					int cnt = 0;
					while(x%j==0) {
						x/=j;
						cnt++;
					}
					if(cnt>1 || !ans.contains(j)) {
						ans.add(i);
						break;
					}

				}
			}
			if(x>1) {
				if(!ans.contains(x)) {
					ans.add(i);
				}
			}
		}
		System.out.println(ans.size());
		if(ans.size()>0)
			for(Integer i:ans.toArray(new Integer[1])) {
				System.out.print(i+" ");
			}
		else
			System.out.println();
	}
}

